package 窗体;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class 计算器模型 extends JFrame {
	public JTextField display;
	private ActionListener insert = new CommandAction();

	public 计算器模型(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 350, 300, 300);
		Container c = getContentPane();
		setLayout(new BorderLayout());

		JPanel displayPanel = new JPanel();// JPanel是java图形化界面中最常使用的容器。实例：在窗体中添加一个蓝色的面板
		c.add(displayPanel, BorderLayout.NORTH);// 将组件加入容器的上端

		display = new JTextField();// 插入文本框
		display.setText("0");
		display.setHorizontalAlignment(SwingConstants.RIGHT);//右边显示数据
		display.setEditable(false);// 设置不可以输入
		display.setFont(new Font("微软雅黑", Font.PLAIN, 20));// Font.PLAIN为不采取方式
		display.setColumns(13);
		displayPanel.add(display);

		JPanel displayPanel2 = new JPanel();// JPanel是java图形化界面中最常使用的容器。实例：在窗体中添加一个蓝色的面板

		c.add(displayPanel2, BorderLayout.CENTER);
		displayPanel2.setLayout(new GridLayout(4, 4, 5, 5));

		JButton l7 = new JButton("7");
		l7.addActionListener(insert);//添加动作监听
		l7.setFont(new Font("楷体", Font.PLAIN, 25));
		displayPanel2.add(l7);

		JButton l8 = new JButton("8");
		l8.addActionListener(insert);
		l8.setFont(new Font("楷体", Font.PLAIN, 25));
		displayPanel2.add(l8);

		JButton l9 = new JButton("9");
		l9.addActionListener(insert);
		l9.setFont(new Font("楷体", Font.PLAIN, 25));
		displayPanel2.add(l9);

		JButton lc = new JButton("/");
		lc.addActionListener(insert);
		lc.setFont(new Font("楷体", Font.PLAIN, 25));
		displayPanel2.add(lc);

		JButton l4 = new JButton("4");
		l4.addActionListener(insert);
		l4.setFont(new Font("楷体", Font.PLAIN, 25));
		displayPanel2.add(l4);

		JButton l5 = new JButton("5");
		l5.addActionListener(insert);
		l5.setFont(new Font("楷体", Font.PLAIN, 25));
		displayPanel2.add(l5);

		JButton l6 = new JButton("6");
		l6.addActionListener(insert);
		l6.setFont(new Font("楷体", Font.PLAIN, 25));
		displayPanel2.add(l6);

		JButton lcf = new JButton("*");
		lcf.addActionListener(insert);
		lcf.setFont(new Font("楷体", Font.PLAIN, 25));
		displayPanel2.add(lcf);

		JButton l1 = new JButton("1");
		l1.addActionListener(insert);
		l1.setFont(new Font("楷体", Font.PLAIN, 25));
		displayPanel2.add(l1);

		JButton l2 = new JButton("2");
		l2.addActionListener(insert);
		l2.setFont(new Font("楷体", Font.PLAIN, 25));
		displayPanel2.add(l2);

		JButton l3 = new JButton("3");
		l3.addActionListener(insert);
		l3.setFont(new Font("楷体", Font.PLAIN, 25));
		displayPanel2.add(l3);

		JButton lj = new JButton("-");
		lj.addActionListener(insert);
		lj.setFont(new Font("楷体", Font.PLAIN, 25));
		displayPanel2.add(lj);

		JButton ld = new JButton(".");
		ld.addActionListener(insert);
		ld.setFont(new Font("楷体", Font.PLAIN, 25));
		displayPanel2.add(ld);

		JButton l0 = new JButton("0");
		l0.addActionListener(insert);
		l0.setFont(new Font("楷体", Font.PLAIN, 25));
		displayPanel2.add(l0);

		JButton lden = new JButton("=");
		lden.addActionListener(insert);
		lden.setFont(new Font("楷体", Font.PLAIN, 25));
		displayPanel2.add(lden);

		JButton ljia = new JButton("+");
		ljia.addActionListener(insert);
		ljia.setFont(new Font("楷体", Font.PLAIN, 25));
		displayPanel2.add(ljia);
		setVisible(true);
		pack();// 调整此窗口的大小，以适合其子组件的首选大小和布局。如果该窗口和/或其所有者仍不可显示，则两者在计算首选大小之前变得可显示。在计算首选大小之后，将会验证该
				// Window。
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new 计算器模型("计算器1.0").setVisible(true);
		;
	}

	private class CommandAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			display.setText("");
			String input = e.getActionCommand();
			display.setText(input);

		}

	}
}
