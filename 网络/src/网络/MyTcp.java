package ����;

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
	private BufferedReader reader;// �����ֽ���
	private ServerSocket server;
	private PrintWriter writer;
	private JButton button;
	private Socket socket;
	private JTextArea jt;// �ı���
	private JTextField jField;// �ı���
	Container con;// ��ȡ��������
	private int s = 0;

	public MyTcp(String title) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 800, 500);
		con = getContentPane();// ����
		con.setLayout(new BorderLayout());
		ScrollPane pane = new ScrollPane();
		jt = new JTextArea();
		jt.setLayout(new BorderLayout());
		jt.setFont(new Font("����", Font.PLAIN, 25));
		jt.setEditable(false);// ���ó��ı��������ֶ���� ���ɱ༭
		pane.add(jt);
		con.add(pane, BorderLayout.CENTER);
		jField = new JTextField();
		jField.setFont(new Font("����", Font.PLAIN, 25));
		con.add(jField, BorderLayout.SOUTH);

		jField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				writer.println(jField.getText());// ���������λ��
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

	private void getserver() {
		try {
			server = new ServerSocket(8998);
			jt.append("�������׽����Ѿ������ɹ�" + "\n");
			while (true) {
				jt.append("�ȴ��ͻ������ӡ�����\n");
				socket = server.accept();// ���������ܵ����׽��ֵ�����,����һ��Socket����
				// accept()�������������󡣷���������ʹ��ϵͳ����socket��bind��listen����һ���׽��֣������󶨵�֪���Ķ˿ڣ�
				// ��ָ����������Ķ��г��ȡ�Ȼ�󣬷���������accept����ȴ�״̬��ֱ������һ����������
				jt.append("�ͻ������ӳɹ�\n");
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
				writer = new PrintWriter(socket.getOutputStream(), true);// ��ȡ�����
				jt.append("�ͻ���[" +socket.getInetAddress()+"]"+ reader.readLine() + "\n");
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
		MyTcp myTcp = new MyTcp("������");
		myTcp.getserver();
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
}
