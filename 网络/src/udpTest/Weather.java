package udpTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Weather extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel sJLabel;
	private boolean sss = true;
	private JButton button;// 按钮
	private JTextArea jt;// 文本域
	private JTextField jField;// 文本框
	Container con;// 获取界面容器
	String weString = "";
	int port = 9898;
	private int s = 0;
	InetAddress iAddress = null;// Ip有关的类
	MulticastSocket socket = null;// 声明多点广播套接字
	DatagramPacket packet = null;
	Thread thread;

	Weather() {
		super("服务器");
		getJFrame();
		try {
			iAddress = InetAddress.getByName("224.255.10.2");// 224.0.0.0-239.255.255.255
			socket = new MulticastSocket(port);// 实例化多播套接字
			// socket.setTimeToLive(1);//指定发送范围为本地网络
			socket.joinGroup(iAddress);// 添加广播组
		} catch (IOException e) {
			e.printStackTrace();
		}
		run2().start();
	}

	public  void getJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 800, 500);
		con = getContentPane();// 容器
		con.setLayout(new BorderLayout());
		ScrollPane pane = new ScrollPane();
		jt = new JTextArea();
		jt.setLayout(new BorderLayout());
		jt.setFont(new Font("楷体", Font.PLAIN, 25));
		jt.setEditable(false);// 设置成文本不可以手动添加不可编辑
		pane.add(jt);
		con.add(pane, BorderLayout.CENTER);
		jField = new JTextField();
		jField.setFont(new Font("楷体", Font.PLAIN, 25));
		con.add(jField, BorderLayout.SOUTH);
		button = new JButton("变色");
		con.add(button, BorderLayout.WEST);
		button.addActionListener(this);
		sJLabel = new JLabel("1");
		sJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sJLabel.setFont(new Font("楷体", Font.PLAIN, 25));
		sJLabel.setForeground(Color.BLUE);
		jField.addActionListener(this);
		con.add(sJLabel, BorderLayout.NORTH);
		run1().start();
		setVisible(true);
	}

	public Thread run2() {
		Runnable tRunnable = new Runnable() {
			public void run() {
				while (true) {
					Date date = new Date();
					SimpleDateFormat sFormat = new SimpleDateFormat("HH:mm:ss");
					String massege = "[" + sFormat.format(date) + "],天气预报：晴";
					byte data[] = massege.getBytes();
					packet = new DatagramPacket(data, data.length, iAddress, port);// 创建数据包
					jt.append("时间：" + massege + "\n");
					try {
						socket.send(packet);// 发送出去
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread = new Thread(tRunnable);
		return thread;
	}

	public Thread run1() {
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
		new Weather();
	}

	public void actionPerformed(ActionEvent e) {// 添加动作监听
		if (e.getSource() == jField) {
			String text = jField.getText();
			byte data[] = text.getBytes();
			packet = new DatagramPacket(data, data.length, iAddress, port);// 创建数据包
			try {
				socket.send(packet);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			jt.append(jField.getText() + "\n");
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
