package 窗体;

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

public class 登录界面 extends JFrame {
	/**
	 * luojianjia
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField jtex;
	public JLabel jtab;
	private JLabel jtab1;
	private JPasswordField jpass;
	private JButton jbutt;
	private JButton jbut;

	public 登录界面() {
		setTitle("登录");
		setBounds(600, 400, 480, 300);// 设置大小位置
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
		jbut = new JButton("重置");
		jbut.setFont(new Font("楷体", Font.PLAIN, 20));
		jbut.setBounds(260, 190, 100, 30);
		jbut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtex.setText("");
				jpass.setText("");
			}
		});
		return jbut;
	}

	private JButton getJButton() {
		jbutt = new JButton("登录");
		jbutt.setFont(new Font("楷体", Font.PLAIN, 20));
		jbutt.setBounds(140, 190, 100, 30);
		jbutt.addActionListener(new ActionListener() {// 点击获取密码
			public void actionPerformed(ActionEvent arg0) {
				if (jtex.getText().trim().equals("") && new String(jpass.getPassword()).trim().equals("")) {
					JOptionPane.showMessageDialog(null, "用户名密码不允许为空");

				} else if (jtex.getText().trim().equals("1870161788")
						&& new String(jpass.getPassword()).trim().equals("123456")) {
					JOptionPane.showMessageDialog(null, "登录成功");

				} else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
				}
				System.out.println(jtex.getText());
				// System.out.println(jpass.getText());// 获取密码
				System.out.println(jpass.getPassword());// 获取密码
			}
		});
		return jbutt;

	}

	private JLabel getJLabel() {
		jtab = new JLabel("输入账号：");
		jtab.setBounds(80, 80, 100, 30);
		jtab.setFont(new Font("楷体", Font.PLAIN, 20));
		return jtab;
	}

	private JTextField getJTextField() {// 获取文本框
		jtex = new JTextField(20);
		jtex.setFont(new Font("楷体", Font.PLAIN, 20));
		jtex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(jtex.getText());
			}
		});
		jtex.setBounds(180, 80, 200, 30);
		return jtex;
	}

	private JLabel getJLabel1() {
		jtab1 = new JLabel("输入密码：");
		jtab1.setFont(new Font("楷体", Font.PLAIN, 20));
		jtab1.setBounds(80, 120, 100, 30);
		return jtab1;
	}

	private JPasswordField getJPasswordField() {// 获取密码框
		jpass = new JPasswordField(20);
		jpass.setFont(new Font("楷体", Font.PLAIN, 20));
		jpass.setEchoChar('*');// 设置密码框显示内容
		jpass.setBounds(180, 120, 200, 30);
		jpass.addActionListener(new ActionListener() {// 按回车动作反应
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				System.out.println(jpass.getText());
			}
		});
		return jpass;

	}

	public static void main(String[] args) {
		登录界面 ads = new 登录界面();
		ads.setVisible(true);
	}

}
