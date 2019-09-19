package �߳�;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/* run�����̱߳�����ʱִ�еĲ���
 * void start() �����̣߳�ִ��run��������
 * getName���������߳���
 * setName()�����߳���
 * static Thread currentThread���������ص�ǰ�߳�
 * static void yield�����߳��ò�
 * ��ͣ��ǰִ�е��̣߳���ִ�л����ø����ȼ����Ӹߵ��߳�
 * join������ĳ���߳�ִ�����е��������̵߳�join��������ʱ�������߳̽���������ֱ��join�����߳�ִ����Ϊֹ
 * static void sleep��long �������룩��ǰ��߳�ָ��ʱ�������CPU���ƣ������̻߳ᱻִ�У�ʱ������������Ŷӡ�
 * stop����ǿ�ƽ����̣߳����Ƽ�ʹ�á�
 * boolean isAlive��������boolean���ж��߳��Ƿ񻹴�
 * 
 */

public class MyThread extends JFrame {

	private static final long serialVersionUID = 1L;
	public JTextArea jt = null;

	public MyThread() {
		setTitle("123456");
		setBounds(300, 100, 800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();//��ȡ����
		JScrollPane js = new JScrollPane(name());
		setLayout(new BorderLayout());//���ò��ַ�ʽ
		container.add(js);
	}

	public JTextArea name() {
		jt = new JTextArea();
		jt.setFont(new Font("����", Font.PLAIN, 18));
		jt.setBackground(Color.YELLOW);
		jt.setForeground(Color.GRAY);
		return jt;
	}

	public void name1(String dString) {
		jt.append(dString);
	}

	public static void main(String[] rags) {

		new Thread() {//�����������߳�
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
		threa.setPriority(thread.MAX_PRIORITY);//���õ�ǰ�߳����ȼ����
		
		threa.setName("ż��");
		threa.start();// ����start���������߳�
		thread.currentThread();// ��ȡ��ǰ�߳�
		thread.currentThread().setName("������");// ���õ�ǰ�߳�
		thread.currentThread().setPriority(thread.MIN_PRIORITY);//�����������߳����ȼ����
		int s=0;
		for (int i = 0; i < 1000; i++) {
			if (i % 2 != 0) {
				System.out.print(thread.currentThread().getName());// ��ȡ��ǰ�߳�����
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

	public void run() {// ��дrun���������߳�Ҫ�ɵ��°�������
		for (int i = 0; i < 1000; i++) {
			synchronized (MyThread.class) {//�߳�ͬ�����������ÿ�������
				
				if (i % 2 != 0) {
					try {
						sleep(10);// �̶߳���1��
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					System.out.println(getName() + ":" + i);
					
				}
			}
		}
	}
}