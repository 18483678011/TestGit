package ����;

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
	private JTextArea jt;// �ı���
	private JTextField jField;// �ı���
	Container con;// ��ȡ��������
	private int s = 0;

	public SocketTest(String title) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 800, 500);

		con = getContentPane();// ����
		con.setLayout(new BorderLayout());
		ScrollPane pane = new ScrollPane();
		con.add(pane, BorderLayout.CENTER);

		jt = new JTextArea();
		jt.setLayout(new BorderLayout());
		jt.setEditable(false);// ���ó��ı��������ֶ���� ���ɱ༭
		jt.setFont(new Font("����", Font.PLAIN, 25));
		pane.add(jt);

		jField = new JTextField();
		jField.setFont(new Font("����", Font.PLAIN, 25));
		con.add(jField, BorderLayout.SOUTH);
		jField.addActionListener(new ActionListener() {// �ı���س���������
			public void actionPerformed(ActionEvent e) {
				// socket.isConnected()
				writer.println(jField.getText());// PrintWriter ���ַ������, ֱ�������������, write�����byte ����char ����,
													// println��������ֺ���, Ҳ���ǻ�Ӹ������� \n
				jt.append("�ң�" + jField.getText() + "\n");
				jt.setSelectionEnd(jt.getText().length());
				jField.setText("");
			}
		});

		button = new JButton("��ɫ");
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
		sJLabel.setFont(new Font("����", Font.PLAIN, 25));
		sJLabel.setForeground(Color.BLUE);
		con.add(sJLabel, BorderLayout.NORTH);
		run().start();
		setVisible(true);
	}

	private void connect() {
		jt.append("�������ӷ����������Եȡ�����\n");
		try {
			socket = new Socket("127.0.0.1", 8998);
			writer = new PrintWriter(socket.getOutputStream(), true);
			jt.append("�������������\n");
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
					jt.append("��������" + reader.readLine() + "\n");
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

	public static void main(String[] args) {
		SocketTest socketTest = new SocketTest("�ͻ���");
		socketTest.connect();
	}
}
