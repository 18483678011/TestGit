package �ļ����洦��;

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

public class �����ļ���¼�Ľ��� extends JFrame {

	private static final long serialVersionUID = 1L;
	public JTextField jTextField;
	public JLabel jLabel;
	private JLabel jLabel2;
	private JPasswordField jField;
	private JButton jButton1;
	private JButton jButton2;
	private String string = "1870161788";// ��ȷ�˺�
	private String tring = "123";// ��ȷ����

	public �����ļ���¼�Ľ���() {
		setTitle("��¼");
		setBounds(720, 400, 480, 300);// ���ô�Сλ��
		JLabel jtab3 = new JLabel("��¼����");
		jtab3.setFont(new Font("����", Font.PLAIN, 35));// ��������
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
		jButton2 = new JButton("����");
		jButton2.setFont(new Font("����", Font.PLAIN, 20));
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
		jButton1 = new JButton("��¼");
		jButton1.setFont(new Font("����", Font.PLAIN, 20));
		jButton1.setBounds(140, 190, 100, 30);
		jButton1.addActionListener(new ActionListener() {// �����ȡ����
			public void actionPerformed(ActionEvent arg0) {
				if (jTextField.getText().trim().isEmpty()//�ܴa���
						&& new String(jField.getPassword()).trim().equals("")) {
					JOptionPane.showMessageDialog(null, "�û������벻����Ϊ��");

				} else if (jTextField.getText().trim().equals(string)
						&& new String(jField.getPassword()).trim().equals(tring)) {
					new ͼ�λ����洦���ļ�();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "�û������������");
				}
				System.out.println(jTextField.getText());
				// System.out.println(jField.getText());// ��ȡ����
				System.out.println(jField.getPassword());// ��ȡ����
			}
		});
		return jButton1;
	}

	private JLabel getJLabel() {
		jLabel = new JLabel("�����˺ţ�");
		jLabel.setBounds(80, 80, 100, 30);
		jLabel.setFont(new Font("����", Font.PLAIN, 20));
		return jLabel;
	}

	private JTextField getJTextField() {// ��ȡ�ı���
		jTextField = new JTextField(20);
		jTextField.setFont(new Font("����", Font.PLAIN, 20));
		jTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(jTextField.getText());
			}
		});
		jTextField.setBounds(180, 80, 200, 30);
		return jTextField;
	}

	private JLabel getJLabel1() {
		jLabel2 = new JLabel("�������룺");
		jLabel2.setFont(new Font("����", Font.PLAIN, 20));
		jLabel2.setBounds(80, 120, 100, 30);
		return jLabel2;
	}

	private JPasswordField getJPasswordField() {// ��ȡ�����
		jField = new JPasswordField(20);
		jField.setFont(new Font("����", Font.PLAIN, 20));
		jField.setEchoChar('*');// �����������ʾ����
		jField.setBounds(180, 120, 200, 30);
		jField.addActionListener(new ActionListener() {// ���س�������Ӧ
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				System.out.println(jField.getText());
			}
		});
		return jField;
	}

	public static void main(String[] args) {
		�����ļ���¼�Ľ��� ads = new �����ļ���¼�Ľ���();
		ads.setVisible(true);
	}
}
