package 线程;

import java.awt.Color;
import java.awt.Container;

import javax.swing.*;

public class SwingAndThread图片移动 extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JLabel jL = new JLabel();
	private JLabel jL1 = new JLabel();
	static Thread my_thread;
	private static Thread t;
	private int count = 0;
	static int a = 5, b = 5;// a是小球上下移动的速度,b是小球左右移动的速度.
	static int x = 0, y = 50;// 小球的初始坐标
	private Container container = getContentPane();

	/*
	 * public void run() { while (count <= 400) { jL.setBounds(count, kuan, 200,
	 * 50); try { Thread.sleep(45); } catch (InterruptedException e) {
	 * e.printStackTrace(); } count += 5; if (count >= 400 && kuan == 150) { count =
	 * 0; kuan = 0; while (kuan <= 400) { jL.setBounds(count, kuan, 200, 50); count
	 * += 1; kuan += 1; try { Thread.sleep(15); } catch (InterruptedException e) {
	 * e.printStackTrace(); } } if (count >= 400 && kuan >= 400) { count = 400; kuan
	 * = 0; while (count >= 0 && kuan <= 410) { jL.setBounds(count, kuan, 200, 50);
	 * count -= 1; kuan += 1; try { Thread.sleep(15); } catch (InterruptedException
	 * e) { e.printStackTrace(); } } } count = 0; kuan = 150; } } } };
	 */
	public Thread getT() {
		t = new Thread(this);
		return t;

	}

	public Thread getT1() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				while (true) {
					while (count <= container.getWidth()) {
						jL1.setBounds(container.getWidth() / 2 -jL1.getWidth()/2, count, 30, 30);
						try {
							thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						count += 3;
						if (count>=container.getWidth()) {
							count=10;
						}
					}
				}
			}
		});
		return t1;
	}

	public SwingAndThread图片移动() {
		setBounds(300, 330, 400, 430);
		setTitle("跳跳球2.0");
		container.setLayout(null);
		container.setBackground(Color.YELLOW);
		// setResizable(false);// 窗体不可以改变大小
		Icon icon = new ImageIcon("E:\\my_java\\线程\\src\\线程\\cut.png");
		jL.setIcon(icon);
		jL.setHorizontalAlignment(SwingConstants.LEFT);// 设置图片在标签最左边
		jL.setBounds(10, 10, 30, 30);
		getT().start();
		container.add(jL);
		Icon icon1 = new ImageIcon("E:\\my_java\\线程\\src\\线程\\cut2.png");
		jL1.setIcon(icon1);
		jL1.setHorizontalAlignment(SwingConstants.LEFT);// 设置图片在标签最左边
		jL1.setBounds(10, 10, 40, 40);
		//jL1.setOpaque(true);//设置这个为true 图片背景不是透明的。默认为透明
		getT1().start();
		container.add(jL1);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		SwingAndThread图片移动 swingAndThread图片移动 = new SwingAndThread图片移动();
		swingAndThread图片移动.setVisible(true);
	}

	@Override
	public void run() {
		while (true) {
			if (x < 0 || x >= container.getWidth() - 25)
				b = -b;
			if (y < 0 || y >= container.getHeight() - 25)
				a = -a;
			x = x + b;
			y = y + a;
			jL.setBounds(x, y,30, 30);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}

	}
}
