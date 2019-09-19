package 窗体;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class 进度条1  {//单例的
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		进度条 p=进度条.getjdt();
		进度条 p2=进度条.getjdt();
	}
}

class 进度条 extends JFrame{
	private static final long serialVersionUID = 1L;
	private static 进度条 jdt = null;
	private Thread thread1;
	private Thread thread2;
	private JProgressBar progressBar1 = new JProgressBar();// 进度条
	private JProgressBar progressBar2 = new JProgressBar();
	int count = 0;

	private 进度条() {
		super();
		setBounds(300, 300, 200, 100);
		Container contentPane = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.add(progressBar1, BorderLayout.NORTH);// 进度条位置
		contentPane.add(progressBar2, BorderLayout.SOUTH);
		progressBar1.setStringPainted(true);// 设置进度条显示数值字符百分比的
		progressBar2.setStringPainted(true);
		progressBar1.setBackground(Color.yellow);// 背景颜色
		progressBar1.setForeground(Color.blue);// 进度条颜色
		progressBar1.setFont(new Font("楷体", Font.PLAIN, 16));// 设置字体大小
		thread1 = new Thread(new Runnable() {
			int count = 0;

			public void run() {
				while (true) {
					progressBar1.setValue(++count);// 设置进度条当前值
					try {
						Thread.sleep(20);
						if (count == 10) {// 当线程1到30%时，换线程1执行，线程2执行完了再继续执行线程一
							thread2.join();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (count == 100) {
						count = 0;
					}
				}
			}
		});
		thread1.start();
		thread2 = new Thread(new Runnable() {
			int count = 0;

			public void run() {
				while (true) {
					progressBar2.setValue(++count);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (count == 100) {
						break;
					}
				}
			}
		});
		thread2.start();
		setVisible(true);
	}

	public static 进度条 getjdt() {
		if(jdt==null) {
			synchronized (进度条.class) {
				if(jdt==null) {
					jdt=new 进度条();
				}
			}
		}
		return jdt;
	}
}