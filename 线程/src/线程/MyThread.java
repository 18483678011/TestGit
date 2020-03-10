package 线程;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/* run（）线程被调度时执行的操作
 * void start() 启动线程，执行run（）方法
 * getName（）返回线程名
 * setName()设置线程名
 * static Thread currentThread（）：返回当前线程
 * static void yield（）线程让步
 * 暂停当前执行的线程，把执行机会让给优先级更加高的线程
 * join（）当某个线程执行流中调用其他线程的join（）方法时；调用线程将被堵塞，直到join方法线程执行完为止
 * static void sleep（long ）（毫秒）当前活动线程指定时间放弃对CPU控制，其他线程会被执行，时间结束后重新排队。
 * stop（）强制结束线程，不推荐使用。
 * boolean isAlive（）返回boolean，判断线程是否还存活。
 * 
 */

public class MyThread extends JFrame {

	private static final long serialVersionUID = 1L;
	public JTextArea jt = null;

	public MyThread() {
		setTitle("123456");
		setBounds(300, 100, 800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();//获取容器
		JScrollPane js = new JScrollPane(name());
		setLayout(new BorderLayout());//设置布局方式
		container.add(js);
	}

	public JTextArea name() {
		jt = new JTextArea();
		jt.setFont(new Font("楷体", Font.PLAIN, 18));
		jt.setBackground(Color.YELLOW);
		jt.setForeground(Color.GRAY);
		return jt;
	}

	public void name1(String dString) {
		jt.append(dString);
	}

	public static void main(String[] rags) {

		new Thread() {//创建的匿名线程
			public void run() {
				int s=0;
				while (s<100) {
					System.out.print(s*2+"\t");
					s++;
				}
			};
		}.start();
		
		MyThread md = new MyThread();
		md.setVisible(true);

		Thread threa = new Thread();
		threa.setPriority(thread.MAX_PRIORITY);//设置当前线程优先级最高
		
		threa.setName("偶数");
		threa.start();// 调用start方法启动线程
		thread.currentThread();// 获取当前线程
		thread.currentThread().setName("主方法");// 设置当前线程
		thread.currentThread().setPriority(thread.MIN_PRIORITY);//设置主函数线程优先级最低
		int s=0;
		for (int i = 0; i < 1000; i++) {
			if (i % 2 != 0) {
				System.out.print(thread.currentThread().getName());// 获取当前线程名字
			s=s+1;
				md.name1(thread.currentThread().getName() + ':' + i +"  "+s+ "******************" + '\n');
				try {
					thread.currentThread();
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println();
				try {
					threa.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class thread extends Thread {

	public thread(runnab runnab) {
		
	}

	public void run() {// 重写run方法将新线程要干的事包含在内
		for (int i = 0; i < 1000; i++) {
			synchronized (MyThread.class) {//线程同步代码块可以用可以用类
				
				if (i % 2 != 0) {
					try {
						sleep(10);// 线程堵塞1秒
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					System.out.println(getName() + ":" + i);
					
				}
			}
		}
	}
}