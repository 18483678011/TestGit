package 窗体;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class 复选框 extends JFrame {

	private static final long serialVersionUID = 1L;
	public JButton jbutt;// 按钮
	private JButton jbt;
	private JButton jbt1;
	public JButton jbutt2;
	private JTextArea jt;// 文本域
	private JRadioButton jr1;// 单选框
	private JRadioButton jr2;
	private JRadioButton jr3;
	private JCheckBox jc1;// 复选框
	private JCheckBox jc2;
	private JCheckBox jc3;
	private ButtonGroup buton;// 单选框组
	private JComboBox<String> jcoComboBox;// 下拉列表
	private JList<String> jlis;

	public 复选框() {
		setTitle("复选框");
		setBounds(500, 400, 800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container con = getContentPane();
		jt = new JTextArea();
		// jt.setBackground(Color.YELLOW);//设置文本框背景颜色
		JScrollPane jsc = new JScrollPane(jt);
		con.add(jsc);
		con.add(JButton1());
		setLayout(new GridLayout(3, 2));

		JPanel j1 = new JPanel();
		j1.setLayout(new FlowLayout());
		butt();
		j1.add(jr1);
		j1.add(jr2);
		j1.add(jr3);
		j1.add(jbutton());
		con.add(j1);

		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		JCheckBox();
		jp2.add(jc1);
		jp2.add(jc2);
		jp2.add(jc3);
		jp2.add(jbutton2());
		con.add(jp2);

		JPanel jp3 = new JPanel();
		jp3.setLayout(new FlowLayout());
		con.add(jp3);
		JLabel l = new JLabel("请选择证件：");
		jp3.add(l);
		jp3.add(jcom());
		jp3.add(jbutton3());

		JPanel jp4 = new JPanel();
		jp4.setLayout(new FlowLayout());
		con.add(jlist());
		setVisible(true);
	}

	public JList<String> jlist() {
		// ---------------方法1---------------------数组初始化
		String[] str = new String[] { "列表1", "列表2", "列表3", "列表4" };
		jlis = new JList<String>(str);
		// ----------------方法2---------------------Vector类型数据做初始化参数
		Vector<String> cont = new Vector<String>();
		jlis = new JList<String>(cont);
		cont.add("列表1");
		cont.add("列表2");
		cont.add("列表3");
		cont.add("列表4");
		cont.add("列表5");
		// ----------------方法2--------------------------DefaultListModel类创建列表
		String[] str1 = new String[] { "列表1", "列表2", "列表3", "列表4", "列表5", "列表6", "列表7", "列表8", "列表9", "列表10" };
		DefaultListModel<String> ilte = new DefaultListModel<String>();
		jlis = new JList<String>(ilte);
		for (int i = 0; i < str1.length; i++) {
			ilte.addElement(str1[i]);
		}
		return jlis;
	}

	private JComboBox<String> jcom() {
		String[] abs = new String[] { "身份证", "学生证", "驾驶证" };
		String lj = "教师证";
		String l = "其他";
		jcoComboBox = new JComboBox<String>(abs);
		jcoComboBox.insertItemAt(lj, 2);// 插入新数据
		jcoComboBox.insertItemAt(l, 4);
		jcoComboBox.setEnabled(true);
		jcoComboBox.setEditable(true);// 设置为可以自己编辑模式
		return jcoComboBox;
	}

	private void JCheckBox() {
		jc1 = new JCheckBox("学生证");
		jc2 = new JCheckBox("身份证");
		jc3 = new JCheckBox("驾驶证");

	}

	private JButton jbutton3() {
		jbutt2 = new JButton("录入");
		jbutt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jt.setText("");
				jt.setForeground(Color.RED);// 设置字体颜色
			
				jt.setFont(new Font("仿宋", Font.PLAIN, 20));// 设置字体样式，大小
				jt.append(jcoComboBox.getSelectedItem() + "的索引为：" + jcoComboBox.getSelectedIndex() + "\n");// 获取索引
				jt.append(jcoComboBox.getSelectedItem() + "\n");// 获取内容
			}
		});

		return jbutt2;
	}

	private JButton jbutton2() {
		jbt1 = new JButton("录入");
		jbt1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jt.setText("");
				jt.setForeground(Color.RED);// 设置字体颜色
				jt.setFont(new Font("仿宋", Font.PLAIN, 20));// 设置字体样式，大小
				if (jc1.isSelected()) {
					jt.append(jc1.getText() + "选定状态：" + jc1.isSelected() + "（选中）" + "!" + '\n');
				}
				if (jc2.isSelected()) {
					jt.append(jc2.getText() + "选定状态：" + jc2.isSelected() + "（选中）" + "!" + '\n');
				}
				if (jc3.isSelected()) {
					jt.append(jc3.getText() + "选定状态：" + jc3.isSelected() + "（选中）" + "!" + '\n');
				}
				jt.append("" + '\n');
				jt.append(jc1.getText() + "选定状态：" + jc1.isSelected() + "!" + '\n' + jc2.getText() + "选定状态："
						+ jc2.isSelected() + "!" + '\n' + jc3.getText() + "选定状态：" + jc3.isSelected() + "!" + '\n');
			}
		});
		return jbt1;
	}

	private JButton jbutton() {
		jbt = new JButton("打印");
		jbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jr1.isSelected()) {
					jt.setText("");
					jt.setForeground(Color.RED);// 设置字体颜色
					jt.setFont(new Font("楷体", Font.PLAIN, 20));// 设置字体样式，大小
					jt.append(jr1.getText() + "选定状态：" + jr1.isSelected() + "(选中)" + '\n');
					jt.append(jr2.getText() + "选定状态：" + jr2.isSelected() + "(没选中)" + '\n');
					jt.append(jr3.getText() + "选定状态：" + jr3.isSelected() + "(没选中)" + '\n');
				}
				if (jr2.isSelected()) {
					jt.setText("");
					jt.setForeground(Color.RED);
					jt.setFont(new Font("仿宋", Font.PLAIN, 20));
					jt.append(jr1.getText() + "选定状态：" + jr1.isSelected() + "(没选中)" + '\n');
					jt.append(jr2.getText() + "选定状态：" + jr2.isSelected() + "(选中)" + '\n');
					jt.append(jr3.getText() + "选定状态：" + jr3.isSelected() + "(没选中)" + '\n');
				}
				if (jr3.isSelected()) {
					jt.setText("");
					jt.setForeground(Color.RED);
					jt.setFont(new Font("黑体", Font.PLAIN, 20));
					jt.append(jr1.getText() + "选定状态：" + jr1.isSelected() + "(没选中)" + '\n');
					jt.append(jr2.getText() + "选定状态：" + jr2.isSelected() + "(没选中)" + '\n');
					jt.append(jr3.getText() + "选定状态：" + jr3.isSelected() + "(选中)" + '\n');

				}
			}
		});
		return jbt;
	}

	private void butt() {
		buton = new ButtonGroup();
		jr1 = new JRadioButton("1");
		jr1.setSelected(true);// 默认选中
		jr1.setBackground(Color.YELLOW);
		jr2 = new JRadioButton("2");
		jr3 = new JRadioButton("3");
		buton.add(jr1);
		buton.add(jr2);
		buton.add(jr3);

	}

	public JButton JButton1() {
		jbutt = new JButton();
		jbutt.setText("确定");
		jbutt.setBounds(30, 100, 100, 30);
		jbutt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbutt.setText("我被点击了！");
				Color color = jbutt.getBackground();
				Color col = JColorChooser.showDialog(jbutt, "选择颜色", color);
				jbutt.setBackground(col);
				jt.setForeground(col);
				//jt.setBackground(col);//设置背景颜色
				//JOptionPane.showMessageDialog(jbutt, "没有其他操作了！点击确定返回。");
				jbutt.setText("确定");
			}
		});
		return jbutt;
	}

	public static void main(String[] args) {
		new 复选框();

	}
}
