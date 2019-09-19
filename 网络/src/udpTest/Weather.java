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
	private JTextArea jt;// �ı���
	private JTextField jField;// �ı���
	Container con;// ��ȡ��������
	String weString = "";
	int port = 10240;
	private int s = 0;
	InetAddress iAddress = null;
	MulticastSocket socket = null;

	Weather() {
		getJFrame();
		try {
			iAddress = InetAddress.getByName("224.255.0.123");// 224.0.0.0-239.255.255.255
			socket = new MulticastSocket(port);// ʵ�����ಥ�׽���
			socket.joinGroup(iAddress);// ��ӹ㲥��
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 800, 500);
		con = getContentPane();// ����
		con.setLayout(new BorderLayout());
		ScrollPane pane = new ScrollPane();
		jt = new JTextArea();
		jt.setLayout(new BorderLayout());
		jt.setFont(new Font("����", Font.PLAIN, 25));
		jt.setEditable(false);// ���ó��ı��������ֶ���Ӳ��ɱ༭
		pane.add(jt);
		con.add(pane, BorderLayout.CENTER);
		jField = new JTextField();
		jField.setFont(new Font("����", Font.PLAIN, 25));
		con.add(jField, BorderLayout.SOUTH);
		button = new JButton("��ɫ");
		con.add(button, BorderLayout.WEST);
		getbutton(button);
		sJLabel = new JLabel("1");
		sJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sJLabel.setFont(new Font("����", Font.PLAIN, 25));
		sJLabel.setForeground(Color.BLUE);
		jField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jt.append("�ң�" + jField.getText() + "\n");
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
					String massege = "[" + sFormat.format(date) + "]����Ԥ������";
					byte data[] = massege.getBytes();
					packet = new DatagramPacket(data, data.length, iAddress, port);// �������ݰ�
					jt.append("�ң�" + massege + "\n");
					try {
						socket.send(packet);// ���ͳ�ȥ

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
					SimpleDateFormat sitDateFormat = new SimpleDateFormat("����ʱ�䣺" + "yyyy/MM/dd  HH:mm:ss");// ���ڸ�ʽ
					sJLabel.setText(sitDateFormat.format(new Date()));
					try {
						Thread.sleep(1000);// ��ʱһ��
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
