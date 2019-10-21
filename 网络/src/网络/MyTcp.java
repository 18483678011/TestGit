package 网络;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MyTcp extends JFrame {

	private static final long serialVersionUID = 1L;
	private boolean sss = true;
	private JLabel sJLabel;
	private BufferedReader reader;// 缓冲字节流
	private ServerSocket server;
	private PrintWriter writer;
	private JButton button;
	private Socket socket;
	private JTextArea jt;// 文本域
	private JTextField jField;// 文本框
	Container con;// 获取界面容器
	private int s = 0;

	public MyTcp(String title) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 800, 500);
		con = getContentPane();// 容器
		con.setLayout(new BorderLayout());
		ScrollPane pane = new ScrollPane();
		jt = new JTextArea();
		jt.setLayout(new BorderLayout());
		jt.setFont(new Font("楷体", Font.PLAIN, 25));
		jt.setEditable(false);// 设置成文本不可以手动添加 不可编辑
		pane.add(jt);
		con.add(pane, BorderLayout.CENTER);
		jField = new JTextField();
		jField.setFont(new Font("楷体", Font.PLAIN, 25));
		con.add(jField, BorderLayout.SOUTH);

		jField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				writer.println(jField.getText());// 定义输出流位置
				jt.append("我：" + jField.getText() + "\n");
				jt.setSelectionEnd(jt.getText().length());
				jField.setText("");
			}
		});
		button = new JButton("变色");
		con.add(button, BorderLayout.WEST);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = (s + 1) % 7;
				switch (s) {
				case 0:
					jt.setBackground(Color.WHITE);
					break;
				case 1:
					jt.setBackground(Color.YELLOW);
					break;
				case 2:
					jt.setBackground(Color.BLACK);
					jt.setForeground(Color.WHITE);
					break;
				case 3:
					jt.setForeground(Color.BLACK);
					jt.setBackground(Color.BLUE);
					break;
				case 4:
					jt.setBackground(Color.CYAN);
					break;
				case 5:
					jt.setBackground(Color.GRAY);
					break;
				case 6:
					jt.setBackground(Color.GREEN);
					break;
				default:
					break;
				}
			}
		});
		sJLabel = new JLabel("1");
		sJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sJLabel.setFont(new Font("楷体", Font.PLAIN, 25));
		sJLabel.setForeground(Color.BLUE);
		con.add(sJLabel, BorderLayout.NORTH);
		run().start();
		setVisible(true);
	}

	private void getserver() {
		try {
			server = new ServerSocket(8998);
			jt.append("服务器套接字已经创建成功" + "\n");
			while (true) {
				jt.append("等待客户机连接。。。\n");
				socket = server.accept();// 侦听并接受到此套接字的连接,返回一个Socket对象
				// accept()：接受连接请求。服务器进程使用系统调用socket，bind和listen创建一个套接字，将它绑定到知名的端口，
				// 并指定连接请求的队列长度。然后，服务器调用accept进入等待状态，直到到达一个连接请求。
				jt.append("客户机连接成功\n");
				jt.append("");
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getClientMessage();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getClientMessage() {
		try {
			while (true) {
				writer = new PrintWriter(socket.getOutputStream(), true);// 获取输出流
				jt.append("客户机[" +socket.getInetAddress()+"]"+ reader.readLine() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (reader != null) {
				reader.close();
			}
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MyTcp myTcp = new MyTcp("服务器");
		myTcp.getserver();
	}

	public Thread run() {
		return new Thread(new Runnable() {
			public void run() {
				while (sss) {
					SimpleDateFormat sitDateFormat = new SimpleDateFormat("北京时间：" + "yyyy/MM/dd  HH:mm:ss");// 日期格式
					sJLabel.setText(sitDateFormat.format(new Date()));
					try {
						Thread.sleep(1000);// 延时一秒
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
}
