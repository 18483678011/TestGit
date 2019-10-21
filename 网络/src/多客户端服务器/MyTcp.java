package 多客户端服务器;

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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MyTcp extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private boolean sss = true;
	private JLabel sJLabel;
	private BufferedReader reader;// 缓冲字节流
	private ServerSocket server;
	private JButton button;
	private Socket socket;
	private JTextArea jt;// 文本域
	private JTextField jField;// 文本框
	Container con;// 获取界面容器
	private int s = 0;
	static int count = 0;
	PrintWriter writer = null;

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
		jField.addActionListener(this);
		button = new JButton("变色");
		con.add(button, BorderLayout.WEST);
		button.addActionListener(this);
		sJLabel = new JLabel("1");
		sJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sJLabel.setFont(new Font("楷体", Font.PLAIN, 25));
		sJLabel.setForeground(Color.BLUE);
		con.add(sJLabel, BorderLayout.NORTH);
		setVisible(true);
	}

	private void getserver() {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Vector<rgg> userThreads = new Vector<>(5);
		try {
			server = new ServerSocket(8998);
			jt.append("服务器套接字已经创建成功" + "\n");
			while (true) {
				jt.append("等待客户机连接。。。\n");
				socket = server.accept();// 侦听并接受到此套接字的连接,返回一个Socket对象
				// accept()：接受连接请求。服务器进程使用系统调用socket，bind和listen创建一个套接字，将它绑定到知名的端口，
				// 并指定连接请求的队列长度。然后，服务器调用accept进入等待状态，直到到达一个连接请求。
				executorService.execute(new rgg(socket, jt,writer,jField,userThreads));
				//rgg serverThread = new rgg(socket, jt,writer,jField);
				//serverThread.start();
				count++;
				jt.append("当前连接线程数：" + count + "\n");
				//getClientMessage();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getClientMessage() {
		try {
				writer = new PrintWriter(socket.getOutputStream(), true);// 获取输出流
				jt.append("客户机:" + reader.readLine() + "\n");
			
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
		myTcp.run().start();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jField) {
			writer.println(jField.getText());// 定义输出流位置
			jt.append("我：" + jField.getText() + "\n");
			jt.setSelectionEnd(jt.getText().length());
			jField.setText("");
		}
		if (e.getSource() == button) {
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
	}
}

class rgg extends Thread {
	private Vector<rgg> userThreads;
	private JTextField jField;// 文本框
	Socket socket = null;
	private JTextArea jTextArea;
	PrintWriter writer = null; 

	public rgg(Socket socket, JTextArea jTextArea,PrintWriter writer,JTextField jField, Vector<rgg> userThreads) {
		this.socket = socket;
		this.jTextArea = jTextArea;
		this.writer=writer;
		this.jField=jField;
		this.userThreads=userThreads;
	}

	public void run() {
		InputStream in = null;
		InputStreamReader isrInputStreamReader = null;
		BufferedReader bufferedReader = null;
		OutputStream out = null;
		PrintWriter printWriter = null;
		
		try {
			while (true) {
				if (socket.isConnected()) {
					writer = new PrintWriter(socket.getOutputStream(), true);
					bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					jTextArea.append("服务器[" +socket.getInetAddress()+"]"+ bufferedReader.readLine() + "\n");
				}}
			/*in = socket.getInputStream();
			isrInputStreamReader = new InputStreamReader(in);
			bufferedReader = new BufferedReader(isrInputStreamReader);
			String string = null;
			while ((string = bufferedReader.readLine()) != null) {
				jTextArea.append("客户机:" + string + "\n");
			}
			out = socket.getOutputStream();
			writer = new PrintWriter(out, true);
			jTextArea.append("客户机:" + writer.toString() + "\n");*/
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != printWriter) {
				printWriter.close();
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != isrInputStreamReader) {
				try {
					isrInputStreamReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (null != socket) {
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
