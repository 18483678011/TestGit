package 窗体;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class 流布局 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public 流布局() {
		setTitle("流布局");
		setBounds(500, 250, 400, 250);
		// setResizable(false);//不可以改变大小
		setLayout(new FlowLayout(1, 10, 10));
		// 设置流布局 1、参数第一个为0为左对齐 ，为1为居中对齐 ，为2为右对齐。2、第二个参数为每个控件之间的x间距（水平间距），第三个参数为控件y间距（垂直间距）。
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		for (int x = 1; x <= 10; x++) {
			c.add(new JButton("按钮" + x));
		}
		setVisible(true);//设置窗体可见
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new 流布局();
	}

}
