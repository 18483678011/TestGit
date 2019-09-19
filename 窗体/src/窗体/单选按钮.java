package 窗体;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class 单选按钮 extends JFrame {

	public 单选按钮() {
		setTitle("单选按钮");
		setBounds(600, 300, 400, 300);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(0, 10, 10));// 采用流布局
		Container con = getContentPane();
		JPanel jpa = new JPanel();
//------------------------------------------------------------------------------
		con.add(jpa);
		JRadioButton jr1 = new JRadioButton("学生证");// 创建4个单选按钮
		JRadioButton jr2 = new JRadioButton("身份证");
		JRadioButton jr3 = new JRadioButton("工作证");
		JRadioButton jr4 = new JRadioButton("军人证");
		ButtonGroup group = new ButtonGroup();// 单选按钮数据组
		jpa.setLayout(new GridLayout(1, 4));
		jr1.setSelected(true);// 设置默认按钮为：jr1
		con.add(jpa);
		group.add(jr1);
		group.add(jr2);
		group.add(jr3);
		group.add(jr4);
		jpa.add(jr1);
		jpa.add(jr2);
		jpa.add(jr3);
		jpa.add(jr4);
		JButton jbu = new JButton("打印");// 按钮
		con.add(jbu);
		jbu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(jr1.getText() + "选定状态：" + jr1.isSelected());// 选定状态
				System.out.println(jr2.getText() + "选定状态：" + jr2.isSelected());
				System.out.println(jr3.getText() + "选定状态：" + jr3.isSelected());
				System.out.println(jr4.getText() + "选定状态：" + jr4.isSelected());
				group.clearSelection();// 清空单选选项
			}
		});
//-----------------------------------------------------------------------------------------
		JCheckBox jch1 = new JCheckBox("按钮1");// 多选框按钮
		JCheckBox jch2 = new JCheckBox("按钮2");
		JCheckBox jch3 = new JCheckBox("按钮3");
		con.add(jch1);
		con.add(jch2);
		con.add(jch3);
		JButton jbu1 = new JButton("打印");
		jbu1.addActionListener(new ActionListener() {// 多选框选定状态动作监听
			public void actionPerformed(ActionEvent e) {
				System.out.println(jch1.getText() + "选定状态：" + jch1.isSelected());// 选定状态
				System.out.println(jch2.getText() + "选定状态：" + jch2.isSelected());
				System.out.println(jch3.getText() + "选定状态：" + jch3.isSelected());
			}
		});
		con.add(jbu1);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new 单选按钮();
	}

}
