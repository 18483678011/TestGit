package �߳�;

import java.awt.Color;
import java.awt.Container;

import javax.swing.*;

public class SwingAndThreadͼƬ�ƶ� extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JLabel jL = new JLabel();
	private JLabel jL1 = new JLabel();
	static Thread my_thread;
	private static Thread t;
	private int count = 0;
	static int a = 5, b = 5;// a��С�������ƶ����ٶ�,b��С�������ƶ����ٶ�.
	static int x = 0, y = 50;// С��ĳ�ʼ����
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

	public SwingAndThreadͼƬ�ƶ�() {
		setBounds(300, 330, 400, 430);
		setTitle("������2.0");
		container.setLayout(null);
		container.setBackground(Color.YELLOW);
		// setResizable(false);// ���岻���Ըı��С
		Icon icon = new ImageIcon("E:\\my_java\\�߳�\\src\\�߳�\\cut.png");
		jL.setIcon(icon);
		jL.setHorizontalAlignment(SwingConstants.LEFT);// ����ͼƬ�ڱ�ǩ�����
		jL.setBounds(10, 10, 30, 30);
		getT().start();
		container.add(jL);
		Icon icon1 = new ImageIcon("E:\\my_java\\�߳�\\src\\�߳�\\cut2.png");
		jL1.setIcon(icon1);
		jL1.setHorizontalAlignment(SwingConstants.LEFT);// ����ͼƬ�ڱ�ǩ�����
		jL1.setBounds(10, 10, 40, 40);
		//jL1.setOpaque(true);//�������Ϊtrue ͼƬ��������͸���ġ�Ĭ��Ϊ͸��
		getT1().start();
		container.add(jL1);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		SwingAndThreadͼƬ�ƶ� swingAndThreadͼƬ�ƶ� = new SwingAndThreadͼƬ�ƶ�();
		swingAndThreadͼƬ�ƶ�.setVisible(true);
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
