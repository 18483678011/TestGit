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

public class Weather extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel sJLabel;
	private boolean sss = true;
	private JButton button;
	private JTextArea jt;// 文本域
	private JTextField jField;// 文本框
	Container con;// 获取界面容器
	String weString = "";
	int port = 10240;
	private int s = 0;
	InetAddress iAddress = null;
	MulticastSocket socket = null;

	Weather() {
		getJFrame();
		try {
			iAddress = InetAddress.getByName("224.255.0.123");// 224.0.0.0-239.255.255.255
			socket = new MulticastSocket(port);// 实例化多播套接字
			socket.joinGroup(iAddress);// 添加广播组
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getJFrame() {
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
		getbutton(button);
		sJLabel = new JLabel("1");
		sJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sJLabel.setFont(new Font("楷体", Font.PLAIN, 25));
		sJLabel.setForeground(Color.BLUE);
		jField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jt.append("我：" + jField.getText() + "\n");
				jt.setSelectionEnd(jt.getText().length());
				jField.setText("");
			}
		});
		con.add(sJLabel, BorderLayout.NORTH);
		run1().start();
		Thread thread = new Thread(new Runnable() {
			public void run() {
				while (true) {
					DatagramPacket packet;
					Date date = new Date();
					SimpleDateFormat sFormat = new SimpleDateFormat("HH:mm:ss");
					String massege = "[" + sFormat.format(date) + "]天气预报：晴";
					byte data[] = massege.getBytes();
					packet = new DatagramPacket(data, data.length, iAddress, port);// 创建数据包
					jt.append("我：" + massege + "\n");
					try {
						socket.send(packet);// 发送出去

						Thread.sleep(1000);
					} catch (IOException | InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
		setVisible(true);
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

	public void getbutton(JButton button) {
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
	}

	public static void main(String[] args) {
		new Weather();

	}

}
