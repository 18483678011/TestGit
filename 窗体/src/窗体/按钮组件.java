package 窗体;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class 按钮组件 extends JFrame {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	public JButton label1;

	public 按钮组件() {
		setTitle("按钮组件");
		setBounds(500, 400, 500, 200);//位置 大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		setLayout(new GridLayout(2, 4, 20, 20));
		JButton[] a = new JButton[6];
		for (int x = 0; x < 6; x++) {
			a[x] = new JButton("按钮" + (x + 1));
			con.add(a[x]);
		}
		a[0].setEnabled(false);// 设置按钮不可用
		a[0].setToolTipText("按钮不可用");// 给文本添加悬停提示
		a[1].setBackground(Color.RED);// 设置按钮背景颜色
		a[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				do_button2_actionPerformed(e);
			}
		});
		a[1].setToolTipText("按钮背景蓝色");// 给文本添加悬停提示

		a[2].setBorderPainted(false);// 设置按钮无边框
		a[2]. setForeground(Color.BLUE);//设置字体颜色
		a[2].setToolTipText("按钮无边框");// 给文本添加悬停提示

		a[3].setBorder(BorderFactory.createLineBorder(Color.GREEN));// 设置边框颜色
		a[3].setToolTipText("按钮绿色边框");// 给文本添加悬停提示

		Icon icon = new ImageIcon("src/java1.png");// 导入图片
		a[4].setIcon(icon);// 添加图片按钮
		a[4].setToolTipText("图片按钮");// 给文本添加悬停提示
		
		a[5].setForeground(Color.yellow);//改变字体颜色
		a[5].addActionListener(new ActionListener() {// 添加监听事件

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(按钮组件.this, "弹出对话框");
			}
		});
		label1 = new JButton("123");
		con.add(label1);
		setVisible(true);
	}

	protected void do_button2_actionPerformed(ActionEvent e) {
		setColor(label1);
	}

	private void setColor(JButton label) {
		Color color = label.getBackground();// 获取原来的按钮背景颜色对象
		// 显示颜色选择对话框
		Color newColor = JColorChooser.showDialog(this, "选择颜色", color);// 一个静态的便利方法显示一个模态颜色选择器对话框并返回用户选择的颜色。
	
		label.setBackground(newColor);// 把获取的颜色设置为标签的背景色
	}

	public static void main(String[] args) {
		new 按钮组件();
	}
}
