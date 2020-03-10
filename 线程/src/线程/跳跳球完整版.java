package 线程;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class 跳跳球完整版 extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	static int a = 10, b = 2;// a是小球上下移动的速度,b是小球左右移动的速度.
	static int x = 0, y = 50;// 小球的初始坐标
	static Thread my_thread;
	JPanel my_frame;
	JTextField jl1, jl2;
	JLabel j1, j2;
	JButton jb, jb2, jb3;
	JLabel ja;

	public 跳跳球完整版() {
		setSize(500, 500);
		setTitle("弹跳小球");
		my_frame = new JPanel(new BorderLayout());
		JPanel jp = new JPanel();
		
		JPanel jp1 = new JPanel();
		j1 = new JLabel("请输入小球初始水平速度a");
		j2 = new JLabel("请输入小球初始垂直速度b");
		jl1 = new JTextField("5", 2);
		jl2 = new JTextField("2", 2);
		jb = new JButton("开始弹跳");
		jb2 = new JButton("暂停弹跳2秒");
		jb3 = new JButton("结束弹跳");
		//ja = new JLabel("弹跳公式为:x=x+a;" + "\n" + " y=y+b;");
		//ja.setFont(new Font("隶书", Font.BOLD, 25));
		add(my_frame);
		my_frame.add(jp, BorderLayout.NORTH);
		my_frame.add(jp1, BorderLayout.SOUTH);
		//my_frame.add(ja, BorderLayout.CENTER);
		my_frame.setBackground(Color.YELLOW);
		jp.add(j1);
		jp.add(jl1);
		jp.add(j2);
		jp.add(jl2);
		jp1.add(jb);
		jb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					a = Integer.parseInt(jl1.getText());
					b = Integer.parseInt(jl2.getText());
				} catch (NumberFormatException p) {
				} finally {
					my_thread.start();
				}
			}
		});
		jp1.add(jb2);
		jb2.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				try {
					Thread.currentThread();
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		jp1.add(jb3);
		jb3.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				my_thread.stop();
			}
		});
		my_frame.setBounds(300, 500, 500, 500);
		setVisible(true);
		my_thread = new Thread(this);
		setDefaultCloseOperation(3);
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		跳跳球完整版 rel_ball = new 跳跳球完整版();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.GREEN);
		g.fillOval(x, y, 50, 50);
	}

	public void run() {
		while (true) {
			if (x < 0 || x >= my_frame.getWidth() - 50)
				b = -b;
			if (y < 50 || y >= my_frame.getHeight() - 50)
				a = -a;
			x = x + b;
			y = y + a;
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}
	}
}