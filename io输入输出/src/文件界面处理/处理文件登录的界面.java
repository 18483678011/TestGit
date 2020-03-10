package 文件界面处理;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class 处理文件登录的界面 extends JFrame {

	private static final long serialVersionUID = 1L;
	public JTextField jTextField;
	public JLabel jLabel;
	private JLabel jLabel2;
	private JPasswordField jField;
	private JButton jButton1;
	private JButton jButton2;
	private String string = "1870161788";// 正确账号
	private String tring = "123";// 正确密码

	public 处理文件登录的界面() {
		setTitle("登录");
		setBounds(720, 400, 480, 300);// 设置大小位置
		JLabel jtab3 = new JLabel("登录界面");
		jtab3.setFont(new Font("楷体", Font.PLAIN, 35));// 设置字体
		jtab3.setBounds(170, 0, 200, 60);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		Container con = getContentPane();
		con.add(jtab3);
		con.add(getJLabel());
		con.add(getJTextField());
		con.add(getJLabel1());
		con.add(getJPasswordField());
		con.add(getJButton());
		con.add(getJButton1());
		setResizable(false);
	}

	private JButton getJButton1() {
		jButton2 = new JButton("重置");
		jButton2.setFont(new Font("楷体", Font.PLAIN, 20));
		jButton2.setBounds(260, 190, 100, 30);
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextField.setText("");
				jField.setText("");
			}
		});
		return jButton2;
	}

	private JButton getJButton() {
		jButton1 = new JButton("登录");
		jButton1.setFont(new Font("楷体", Font.PLAIN, 20));
		jButton1.setBounds(140, 190, 100, 30);
		jButton1.addActionListener(new ActionListener() {// 点击获取密码
			public void actionPerformed(ActionEvent arg0) {
				if (jTextField.getText().trim().isEmpty()//密碼為空
						&& new String(jField.getPassword()).trim().equals("")) {
					JOptionPane.showMessageDialog(null, "用户名密码不允许为空");

				} else if (jTextField.getText().trim().equals(string)
						&& new String(jField.getPassword()).trim().equals(tring)) {
					new 图形化界面处理文件();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
				}
				System.out.println(jTextField.getText());
				// System.out.println(jField.getText());// 获取密码
				System.out.println(jField.getPassword());// 获取密码
			}
		});
		return jButton1;
	}

	private JLabel getJLabel() {
		jLabel = new JLabel("输入账号：");
		jLabel.setBounds(80, 80, 100, 30);
		jLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		return jLabel;
	}

	private JTextField getJTextField() {// 获取文本框
		jTextField = new JTextField(20);
		jTextField.setFont(new Font("楷体", Font.PLAIN, 20));
		jTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(jTextField.getText());
			}
		});
		jTextField.setBounds(180, 80, 200, 30);
		return jTextField;
	}

	private JLabel getJLabel1() {
		jLabel2 = new JLabel("输入密码：");
		jLabel2.setFont(new Font("楷体", Font.PLAIN, 20));
		jLabel2.setBounds(80, 120, 100, 30);
		return jLabel2;
	}

	private JPasswordField getJPasswordField() {// 获取密码框
		jField = new JPasswordField(20);
		jField.setFont(new Font("楷体", Font.PLAIN, 20));
		jField.setEchoChar('*');// 设置密码框显示内容
		jField.setBounds(180, 120, 200, 30);
		jField.addActionListener(new ActionListener() {// 按回车动作反应
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				System.out.println(jField.getText());
			}
		});
		return jField;
	}

	public static void main(String[] args) {
		处理文件登录的界面 ads = new 处理文件登录的界面();
		ads.setVisible(true);
	}
}
