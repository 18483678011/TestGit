package 窗体;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class dome extends JDialog {

	public dome() {
		// 一、这个堵塞弹出多个对话框 第一个是来自哪个窗体 二 、对话框名字 三、true为堵塞弹出 false为不堵塞
		Container c = getContentPane();// 获取容器
		JLabel v = new JLabel("这是一个对话框。");
		v.setForeground(Color.GREEN);// 字体颜色改变
		v.setFont(new Font("楷体", Font.BOLD, 20));// 字体以及大小
		c.add(v);// 容器包含v
		c.setBackground(Color.CYAN);// 背景颜色
		this.setResizable(false);// 不可以改变大小
		this.setLayout(new FlowLayout());// 布局格式设置成流布局。
		// setVisible(true);
		JLabel v1 = new JLabel("这是一个2对话框。");
		c.add(v1);
		JButton ton = new JButton();
		ton.setText("按钮2");
		c.add(ton);
		ton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				插入对话框 c = new 插入对话框();
				c.setVisible(true);

			}
		});
		setBounds(900, 500, 200, 150);// 窗体大小

	}

	public dome(JFrame d) {	
		super(d, "对话框1", true);
		setLayout(null);
		Container c = getContentPane();
		JLabel f = new JLabel("这是一个对话框。");
		f.setBounds(10, 10, 100, 40);
		c.add(f);
		c.setBackground(Color.GRAY);
		this.setResizable(false);// 设置可以改变大小
		
		setBounds(400, 500, 200, 150);
		setVisible(true);//可见
		// TODO 自动生成的构造函数存根
	}

}

public class 插入对话框 extends JFrame {
	private JPanel contentPane;

	public 插入对话框(int x) {

		setTitle("\u8BA1\u7B97\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));//
		setContentPane(contentPane);
	}

	public 插入对话框() {

		JFrame jf = new JFrame();// 创建一个窗体
		jf.setLocationByPlatform(true);// java.awt.Window中的一个方法，设置在下次窗口可见时，窗口是应显示位置
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));//
		setContentPane(contentPane);
		jf.setTitle("一个JFrame窗体");
		jf.setVisible(true);// 设置窗体为可见。
		jf.setBounds(760, 400, 500, 300);// 窗口大小 位置
		jf.setLayout(null);// 使用该窗体取消布局管理器设置, 可以自己分配位置
		jf.setResizable(false);// 禁止改变窗体大小
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 窗口关闭方式
		Container container = jf.getContentPane();// 获取窗体容器
		container.setBackground(Color.WHITE);// 窗体容器颜色

		JLabel s = new JLabel("罗建嘉 加油 gogogo...");// 创建标签及内容
		// s.setText("");// 改变标签内容
		s.setFont(new Font("楷体", Font.BOLD, 18));// 设置标签对应的字体、样式（加粗），大小。
		s.setForeground(Color.CYAN);// 字体颜色
		s.setBounds(200, 50, 200, 40);
		// jf.setLayout(new FlowLayout());//容器设置内容为流体显示
		// new JLabel("这是一个对话框。")
		// s.setHorizontalAlignment(SwingConstants.CENTER);//标签位置居中
		container.add(s);// 将标签添加到容器
		JButton c = new JButton("弹出对话框");// 创建一个按钮。
		c.setSize(50, 15);// 设置按钮大小
		c.setBounds(100, 50, 100, 40);// 设置按钮位置 大小
		container.add(c);// 将按钮添加到窗体容器中
		c.addActionListener(new ActionListener() {// 给按钮添加监听动作
			@Override
			public void actionPerformed(ActionEvent e) {
				dome da = new dome();
				da.setVisible(true);
			}
		});
	}

	public static void main(String[] args) {
		插入对话框 v = new 插入对话框();
		v.setVisible(true);
		new 插入对话框(1);

	}
}
