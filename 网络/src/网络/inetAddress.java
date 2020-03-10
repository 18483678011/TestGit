package 网络;

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
			InetAddress intAddress = InetAddress.getByName("www.baidu.com");// 淘宝
			InetAddress[] address = InetAddress.getAllByName("www.baidu.com");// 获取IP数组
			for (InetAddress b : address) {
				System.out.println(b);
			}
			String hostName = intAddress.getHostName();// 获取名字
			System.out.println(hostName + intAddress.getHostAddress());
			String hostAddress2 = intAddress.getHostAddress();// 获取IP地址
			System.out.println(intAddress.getHostName() + '\t' + hostAddress2);
			InetAddress intAddress2[];
			intAddress2 = InetAddress.getAllByName("www.baidu.com");
			for (InetAddress i : intAddress2) {
				System.out.println("www.baidu.com" + "IP:" + i.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} // 获取IP数组

		bbb .getbbb("本机IP1");
		
	}
}
class  bbb extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextArea jt;
	private static bbb setBbb=null;
	Container con;

	private bbb(String title) throws HeadlessException {
		super(title);
		this.setResizable(false);// 设置窗体不可以改变大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 400, 120);
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		ScrollPane pane = new ScrollPane();
		jt = new JTextArea();
		jt.setEditable(false);// 设置成文本不可以手动添加
		jt.setLayout(new BorderLayout());
		jt.setFont(new Font("楷体", Font.PLAIN, 25));
		pane.add(jt);
		con.add(pane, BorderLayout.CENTER);
		try {

			InetAddress inet4 = InetAddress.getLocalHost();// 获取本机IP地址
			String hostName = inet4.getHostName();// 获取本机名字
			String hostAddress = inet4.getHostAddress();// 获取本机IP
			jt.setText("  " + "本机名称：" + hostName + '\n' + "  " + "本机IP：" + hostAddress);
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