package 多客户test;

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
	 * 这块我用到了线程池来创建线程，给了5个线程，所以这个服务器端可以接受的客户端是5个，然后就是一个accept阻塞等待连接，直接给线程池提交任务。
	 */
	public Server() {
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
		sJLabel = new JLabel("");
		sJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sJLabel.setFont(new Font("楷体", Font.PLAIN, 25));
		sJLabel.setForeground(Color.BLUE);
		con.add(sJLabel, BorderLayout.NORTH);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Server();
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Vector<UserThread> userThreads = new Vector<>(5);// Vector 可实现自动增长的对象数组。 nextElement() 来获取下一个元素
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(8998);
			jt.append("服务器启动成功"+"\n");
			while (true) {
				Socket socket = serverSocket.accept();
				jt .append("客户端：" + socket.getRemoteSocketAddress() + "连接成功");// 端口号
				executorService.execute(new UserThread(socket, userThreads,jt));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jField) {
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

class UserThread implements Runnable {/*
										 * 这个类是真正实现逻辑的地方，说一下大体思路，就是不断的读信息，如果读到的信息类型（MessageType）是登录信息，那么就证明第一次连接建立，
										 * 如果读到的是发送信息，那么就根据信息的去向（to），在线程集合（Vector）中去找对应的线程，然后将Message转发给对应的线程。
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
				User message1 = new User(user.getID(), name, 11, "登录成功", MessageType.TYPE_LOGIN);
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
							 * 这个类主要是用来区分后面的类Message，也就是我们所说的信息的类型， 这里我们设定了两种类型，一种是登录信息，一种是发送信息，
							 * 服务器端可以通过这个属性来区分信息的类型。
							 */
	public static final int TYPE_LOGIN = 0X1;
	public static final int TYPE_SEND = 0X2;
}
