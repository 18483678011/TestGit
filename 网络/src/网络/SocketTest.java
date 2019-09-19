package 网络;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class SocketTest extends JFrame {
	private boolean sss = true;
	private JLabel sJLabel;
	private JButton button;
	private PrintWriter writer;
	BufferedReader reader;
	private static final long serialVersionUID = 1L;
	private Socket socket;
	private JTextArea jt;// 文本域
	private JTextField jField;// 文本框
	Container con;// 获取界面容器
	private int s = 0;

	public SocketTest(String title) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 800, 500);

		con = getContentPane();// 容器
		con.setLayout(new BorderLayout());
		ScrollPane pane = new ScrollPane();
		con.add(pane, BorderLayout.CENTER);

		jt = new JTextArea();
		jt.setLayout(new BorderLayout());
		jt.setEditable(false);// 设置成文本不可以手动添加 不可编辑
		jt.setFont(new Font("楷体", Font.PLAIN, 25));
		pane.add(jt);

		jField = new JTextField();
		jField.setFont(new Font("楷体", Font.PLAIN, 25));
		con.add(jField, BorderLayout.SOUTH);
		jField.addActionListener(new ActionListener() {// 文本框回车动作监听
			public void actionPerformed(ActionEvent e) {
				// socket.isConnected()
				writer.println(jField.getText());// PrintWriter 是字符输出流, 直接输出的是文字, write是输出byte 或许char 数组,
													// println是输出文字后换行, 也就是会加个结束符 \n
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

	private void connect() {
		jt.append("尝试连接服务器，请稍等。。。\n");
		try {
			socket = new Socket("127.0.0.1", 8998);
			writer = new PrintWriter(socket.getOutputStream(), true);
			jt.append("服务器连接完成\n");
			getClientMessage();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getClientMessage() {
		try {
			while (true) {
				if (socket.isConnected()) {
					writer = new PrintWriter(socket.getOutputStream(), true);
					reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					jt.append("服务器：" + reader.readLine() + "\n");
				}
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

	public static void main(String[] args) {
		SocketTest socketTest = new SocketTest("客户端");
		socketTest.connect();
	}
}
