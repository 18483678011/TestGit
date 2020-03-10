package 窗体;

import java.awt.Color;
import java.awt.Container;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

class jdialog extends JDialog {
	
	private  Container c = getContentPane();// 获取容器
	public jdialog(锁定弹出对话框 d1) {
		super(d1, "会话框1", true);// 锁定对话框
		setBounds(550, 300, 300, 200);// 大小
		c.setLayout(null);// 布局为绝对布局
		JLabel jl = new JLabel("点击右上角X关闭对话框！");// 定义按钮
		jl.setForeground(Color.BLUE);// 按钮颜色
		jl.setFont(new Font("楷体", Font.BOLD, 18));// 字体字体 加粗 字号。
		c.add(jl);// 按钮加入容器
		jl.setBounds(40, 30, 250, 50);// 按钮大小位置
		int y=this.getHeight()/2-jl.getHeight();
		
		System.out.println(y);
		new Thread() {
			public void run() {
				while (true) {
					int x = 0-jl.getWidth()+10;//获取长度和宽度
					while (x <= c.getHeight()+jl.getWidth()/2) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						x += 5;
						System.out.println(jl.getHeight());
						jl.setBounds(x, y, 230, 50);
					}
					x = 0-jl.getWidth()+10;//获取长度和宽度
				}
			};
		}.start();
		setResizable(false);// 窗体不可以改变大小
	}
}

public class 锁定弹出对话框 extends JFrame {
	public 锁定弹出对话框() {
		new JFrame("123...");
		setTitle("锁定对话框");
		setLayout(null);
		Container c = getContentPane();
		JButton jb = new JButton("点击按钮进入");
		jb.setBackground(Color.GREEN);
		jb.setBounds(180, 150, 120, 30);
		jb.addActionListener(new ActionListener() {// 添加监听
			public void actionPerformed(ActionEvent e) {
				new jdialog(锁定弹出对话框.this).setVisible(true);
			}
		});
		c.add(jb);
		setBounds(450, 200, 500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {

		new 锁定弹出对话框();

	}

}