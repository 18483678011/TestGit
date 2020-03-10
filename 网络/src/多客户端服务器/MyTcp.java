package ��ͻ��˷�����;

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
	private BufferedReader reader;// �����ֽ���
	private ServerSocket server;
	private JButton button;
	private Socket socket;
	private JTextArea jt;// �ı���
	private JTextField jField;// �ı���
	Container con;// ��ȡ��������
	private int s = 0;
	static int count = 0;
	PrintWriter writer = null;

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
		jField.addActionListener(this);
		button = new JButton("��ɫ");
		con.add(button, BorderLayout.WEST);
		button.addActionListener(this);
		sJLabel = new JLabel("1");
		sJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sJLabel.setFont(new Font("����", Font.PLAIN, 25));
		sJLabel.setForeground(Color.BLUE);
		con.add(sJLabel, BorderLayout.NORTH);
		setVisible(true);
	}

	private void getserver() {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Vector<rgg> userThreads = new Vector<>(5);
		try {
			server = new ServerSocket(8998);
			jt.append("�������׽����Ѿ������ɹ�" + "\n");
			while (true) {
				jt.append("�ȴ��ͻ������ӡ�����\n");
				socket = server.accept();// ���������ܵ����׽��ֵ�����,����һ��Socket����
				// accept()�������������󡣷���������ʹ��ϵͳ����socket��bind��listen����һ���׽��֣������󶨵�֪���Ķ˿ڣ�
				// ��ָ����������Ķ��г��ȡ�Ȼ�󣬷���������accept����ȴ�״̬��ֱ������һ����������
				executorService.execute(new rgg(socket, jt,writer,jField,userThreads));
				//rgg serverThread = new rgg(socket, jt,writer,jField);
				//serverThread.start();
				count++;
				jt.append("��ǰ�����߳�����" + count + "\n");
				//getClientMessage();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getClientMessage() {
		try {
				writer = new PrintWriter(socket.getOutputStream(), true);// ��ȡ�����
				jt.append("�ͻ���:" + reader.readLine() + "\n");
			
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
		myTcp.run().start();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jField) {
			writer.println(jField.getText());// ���������λ��
			jt.append("�ң�" + jField.getText() + "\n");
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
	private JTextField jField;// �ı���
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
					jTextArea.append("������[" +socket.getInetAddress()+"]"+ bufferedReader.readLine() + "\n");
				}}
			/*in = socket.getInputStream();
			isrInputStreamReader = new InputStreamReader(in);
			bufferedReader = new BufferedReader(isrInputStreamReader);
			String string = null;
			while ((string = bufferedReader.readLine()) != null) {
				jTextArea.append("�ͻ���:" + string + "\n");
			}
			out = socket.getOutputStream();
			writer = new PrintWriter(out, true);
			jTextArea.append("�ͻ���:" + writer.toString() + "\n");*/
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
