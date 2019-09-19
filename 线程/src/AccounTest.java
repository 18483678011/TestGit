
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;//lock�̰߳�ȫ������

public class AccounTest {

	public static void main(String[] args) {
		Accoun acct = new Accoun(0);
		DecimalFormat myFormat = new DecimalFormat();// ��ʾ��ʽ������
		String string = "0.00";// ��λС����ʾ��
		myFormat.applyPattern(string);
		System.out.println("�˻���ǰ���Ϊ��" + myFormat.format(acct.getMayle()));
		Customer c1 = new Customer(acct);
		Customer c3 = new Customer(acct);
		Customer c2 = new Customer(acct);
		Thread d1 = new Thread(c1);
		Thread d2 = new Thread(c2);
		Thread d3 = new Thread(c3);
		d1.setName("��");
		d2.setName("��");
		d3.setName("��");
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
			System.out.print(Thread.currentThread().getName() + ":��������>=0����");
			if (!scanner.hasNextDouble()) {
				System.out.println("���벻Ϊ������ʧ�ܡ�");
				return;
			}
			double amt = scanner.nextDouble();
			if (amt < 0) {
				System.out.println(Thread.currentThread().getName() + ":�洢��" + amt + " ��Ϊ������  " + "�洢ʧ�ܣ�");
				return;
			}

			if (amt > 0) {
				mayle += amt;
			}
			DecimalFormat myFormat = new DecimalFormat();// ��ʾ��ʽ������
			String string = "\u00A40,000.00";// ���Ӷ��ż���λС����ʾ��
			myFormat.applyPattern(string);// ���ӵ���applyPattern�����������ø�ʽ��ģʽ��
			System.out.println(Thread.currentThread().getName() + ":����ɹ������룺" + myFormat.format(amt) + "Ԫ����ǰ���Ϊ��"
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
				System.out.print(Thread.currentThread().getName() + ":�Ƿ������Ǯ��1����������/1.0��������ɣ���������");
				Scanner scanner = new Scanner(System.in);
				if (!scanner.hasNextInt()) {
					System.out.println(Thread.currentThread().getName() + "���߳�������");
					break;
				}
			}
		}
	}
}