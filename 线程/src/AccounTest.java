
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;//lock线程安全锁；；

public class AccounTest {

	public static void main(String[] args) {
		Accoun acct = new Accoun(0);
		DecimalFormat myFormat = new DecimalFormat();// 显示格式调整。
		String string = "0.00";// 两位小数显示。
		myFormat.applyPattern(string);
		System.out.println("账户当前余额为：" + myFormat.format(acct.getMayle()));
		Customer c1 = new Customer(acct);
		Customer c3 = new Customer(acct);
		Customer c2 = new Customer(acct);
		Thread d1 = new Thread(c1);
		Thread d2 = new Thread(c2);
		Thread d3 = new Thread(c3);
		d1.setName("甲");
		d2.setName("乙");
		d3.setName("丙");
		d1.start();
		d2.start();
		d3.start();
	}
}

class Accoun {
	private double mayle = 0;
	private ReentrantLock rLock = new ReentrantLock();

	public Accoun(double mayle) {
		this.mayle = mayle;
	}

	public double getMayle() {
		return mayle;
	}

	public void deposit() {
		try {
			rLock.lock();
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.print(Thread.currentThread().getName() + ":输入存入金额（>=0）：");
			if (!scanner.hasNextDouble()) {
				System.out.println("输入不为金额！输入失败。");
				return;
			}
			double amt = scanner.nextDouble();
			if (amt < 0) {
				System.out.println(Thread.currentThread().getName() + ":存储金额：" + amt + " ，为负数！  " + "存储失败；");
				return;
			}

			if (amt > 0) {
				mayle += amt;
			}
			DecimalFormat myFormat = new DecimalFormat();// 显示格式调整。
			String string = "\u00A40,000.00";// ￥加逗号加两位小数显示。
			myFormat.applyPattern(string);// ￥加调用applyPattern（）方法设置格式化模式。
			System.out.println(Thread.currentThread().getName() + ":存入成功！存入：" + myFormat.format(amt) + "元；当前余额为："
					+ myFormat.format(mayle));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			rLock.unlock();
		}
	}
}

class Customer implements Runnable {
	private Accoun acct;

	public Customer(Accoun acct) {
		this.acct = acct;
	}

	public void run() {
		while (true) {
			synchronized (Customer.class) {
				acct.deposit();
				System.out.print(Thread.currentThread().getName() + ":是否继续存钱（1（继续！）/1.0（存入完成！））？：");
				Scanner scanner = new Scanner(System.in);
				if (!scanner.hasNextInt()) {
					System.out.println(Thread.currentThread().getName() + "：线程死亡！");
					break;
				}
			}
		}
	}
}