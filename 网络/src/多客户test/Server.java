package ��ͻ�test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Server extends JFrame implements ActionListener {
	private Container con;
	private static JTextArea jt;
	private JTextField jField;
	private JButton button;
	private int s;
	private JLabel sJLabel;

	/*
	 * ������õ����̳߳��������̣߳�����5���̣߳���������������˿��Խ��ܵĿͻ�����5����Ȼ�����һ��accept�����ȴ����ӣ�ֱ�Ӹ��̳߳��ύ����
	 */
	public Server() {
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
		sJLabel = new JLabel("");
		sJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sJLabel.setFont(new Font("����", Font.PLAIN, 25));
		sJLabel.setForeground(Color.BLUE);
		con.add(sJLabel, BorderLayout.NORTH);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Server();
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Vector<UserThread> userThreads = new Vector<>(5);// Vector ��ʵ���Զ������Ķ������顣 nextElement() ����ȡ��һ��Ԫ��
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(8998);
			jt.append("�����������ɹ�"+"\n");
			while (true) {
				Socket socket = serverSocket.accept();
				jt .append("�ͻ��ˣ�" + socket.getRemoteSocketAddress() + "���ӳɹ�");// �˿ں�
				executorService.execute(new UserThread(socket, userThreads,jt));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jField) {
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

class UserThread implements Runnable {/*
										 * �����������ʵ���߼��ĵط���˵һ�´���˼·�����ǲ��ϵĶ���Ϣ�������������Ϣ���ͣ�MessageType���ǵ�¼��Ϣ����ô��֤����һ�����ӽ�����
										 * ����������Ƿ�����Ϣ����ô�͸�����Ϣ��ȥ��to�������̼߳��ϣ�Vector����ȥ�Ҷ�Ӧ���̣߳�Ȼ��Messageת������Ӧ���̡߳�
										 */
	private String name;
	private User user;
	private JTextArea jt;
	private Socket socket;
	private Vector<UserThread> userThreads;
	private ObjectInputStream objectInputStream = null;
	private ObjectOutputStream objectOutputStream = null;

	public UserThread(Socket socket, Vector<UserThread> userThreads,JTextArea jt ) {
		this.socket = socket;
		this.userThreads = userThreads;
		this.jt=jt;
		userThreads.add(this);
	}

	@Override
	public void run() {
		try {
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				if (socket.isBound() == false) {
					break;
				}
				user = (User) objectInputStream.readObject();
				jt.append(user.toString());
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}

			if (user.getUser() == MessageType.TYPE_LOGIN) {
				this.name = user.getName();
				User message1 = new User(user.getID(), name, 11, "��¼�ɹ�", MessageType.TYPE_LOGIN);
				try {
					objectOutputStream.writeObject(message1);
					objectOutputStream.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (user.getUser() == MessageType.TYPE_SEND) {
				int ID = user.getID();
				Iterator<UserThread> iterator = userThreads.iterator();
				while (iterator.hasNext()) {
					UserThread next = iterator.next();
					if (next.getName().equals(ID)) {
						try {
							next.getObjectOutputStream().writeObject(user);
							next.getObjectOutputStream().flush();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					}
				}
			}
		}
	}

	public Vector<UserThread> getUserThreads() {
		return userThreads;
	}

	public void setUserThreads(Vector<UserThread> userThreads) {
		this.userThreads = userThreads;
	}

	public ObjectInputStream getObjectInputStream() {
		return objectInputStream;
	}

	public void setObjectInputStream(ObjectInputStream objectInputStream) {
		this.objectInputStream = objectInputStream;
	}

	public ObjectOutputStream getObjectOutputStream() {
		return objectOutputStream;
	}

	public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
		this.objectOutputStream = objectOutputStream;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getMessage() {
		return user;
	}

	public void setMessage(User message) {
		this.user = message;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}

final class MessageType { /*
							 * �������Ҫ���������ֺ������Message��Ҳ����������˵����Ϣ�����ͣ� ���������趨���������ͣ�һ���ǵ�¼��Ϣ��һ���Ƿ�����Ϣ��
							 * �������˿���ͨ�����������������Ϣ�����͡�
							 */
	public static final int TYPE_LOGIN = 0X1;
	public static final int TYPE_SEND = 0X2;
}
