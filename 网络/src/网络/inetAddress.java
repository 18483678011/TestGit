package ����;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.ScrollPane;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class inetAddress  {

	public static void main(String[] args) {

		try {
			InetAddress intAddress = InetAddress.getByName("www.baidu.com");// �Ա�
			InetAddress[] address = InetAddress.getAllByName("www.baidu.com");// ��ȡIP����
			for (InetAddress b : address) {
				System.out.println(b);
			}
			String hostName = intAddress.getHostName();// ��ȡ����
			System.out.println(hostName + intAddress.getHostAddress());
			String hostAddress2 = intAddress.getHostAddress();// ��ȡIP��ַ
			System.out.println(intAddress.getHostName() + '\t' + hostAddress2);
			InetAddress intAddress2[];
			intAddress2 = InetAddress.getAllByName("www.baidu.com");
			for (InetAddress i : intAddress2) {
				System.out.println("www.baidu.com" + "IP:" + i.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} // ��ȡIP����

		bbb .getbbb("����IP1");
		
	}
}
class  bbb extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextArea jt;
	private static bbb setBbb=null;
	Container con;

	private bbb(String title) throws HeadlessException {
		super(title);
		this.setResizable(false);// ���ô��岻���Ըı��С
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 400, 120);
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		ScrollPane pane = new ScrollPane();
		jt = new JTextArea();
		jt.setEditable(false);// ���ó��ı��������ֶ����
		jt.setLayout(new BorderLayout());
		jt.setFont(new Font("����", Font.PLAIN, 25));
		pane.add(jt);
		con.add(pane, BorderLayout.CENTER);
		try {

			InetAddress inet4 = InetAddress.getLocalHost();// ��ȡ����IP��ַ
			String hostName = inet4.getHostName();// ��ȡ��������
			String hostAddress = inet4.getHostAddress();// ��ȡ����IP
			jt.setText("  " + "�������ƣ�" + hostName + '\n' + "  " + "����IP��" + hostAddress);
			System.out.println(inet4);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		setVisible(true);
	}

	public static  bbb getbbb(String mane) {
		if (setBbb==null) {
			setBbb=new bbb(mane);
		}
		return setBbb;
	}
}