package 线程;

import java.awt.Color;
import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class 跳跳球 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jL = new JLabel();
	private static Thread t; 
	private Container container = getContentPane();
	static int a = 5, b = 7;// a是小球上下移动的速度,b是小球左右移动的速度
	static int x = 0, y = 0;// 小球的初始坐标
	
	private JLabel getJLabel() {
		Icon icon = new ImageIcon("E:\\my_java\\线程\\src\\线程\\cut.png");
		jL.setIcon(icon);
		jL.setHorizontalAlignment(SwingConstants.LEFT);// 设置图片在标签最左边
		jL.setBounds(10, 10, 40, 40);
		jL.setBackground(Color.YELLOW);
		//jL.setOpaque(true);//设置背景是否透明的
		return jL;
	}

	public 跳跳球() {
		setTitle("跳跳球");
		setBounds(300, 200, 400, 430);
		container.setLayout(null);
		container.setBackground(Color.YELLOW);
		//setResizable(false);//窗体不可以改变大小
		t = new Thread(new Runnable() {
			public void run() {
				while (true) {
					if (x < 0 || x >= container.getWidth()-40)//获取容器宽度 运行时都可以变
						b = -b;
					if (y < 0 || y >= container.getHeight()-40)//获取容器长度 运行时都可以变
						a = -a;
					x = x + b;
					y = y + a;
					jL.setBounds(x, y, 50, 50);
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
					}
				}
			}
				
		});
		t.start();
		container.add(getJLabel());setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new 跳跳球();
	}
}
