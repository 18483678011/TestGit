package �߳�;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ������������ extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	static int a = 10, b = 2;// a��С�������ƶ����ٶ�,b��С�������ƶ����ٶ�.
	static int x = 0, y = 50;// С��ĳ�ʼ����
	static Thread my_thread;
	JPanel my_frame;
	JTextField jl1, jl2;
	JLabel j1, j2;
	JButton jb, jb2, jb3;
	JLabel ja;

	public ������������() {
		setSize(500, 500);
		setTitle("����С��");
		my_frame = new JPanel(new BorderLayout());
		JPanel jp = new JPanel();
		
		JPanel jp1 = new JPanel();
		j1 = new JLabel("������С���ʼˮƽ�ٶ�a");
		j2 = new JLabel("������С���ʼ��ֱ�ٶ�b");
		jl1 = new JTextField("5", 2);
		jl2 = new JTextField("2", 2);
		jb = new JButton("��ʼ����");
		jb2 = new JButton("��ͣ����2��");
		jb3 = new JButton("��������");
		//ja = new JLabel("������ʽΪ:x=x+a;" + "\n" + " y=y+b;");
		//ja.setFont(new Font("����", Font.BOLD, 25));
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
		������������ rel_ball = new ������������();
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