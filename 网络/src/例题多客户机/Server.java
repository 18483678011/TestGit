package 例题多客户机;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class MessageType { /*
							 * 这个类主要是用来区分后面的类Message，也就是我们所说的信息的类型， 这里我们设定了两种类型，一种是登录信息，一种是发送信息，
							 * 服务器端可以通过这个属性来区分信息的类型。
							 */
	public static final int TYPE_LOGIN = 0X1;
	public static final int TYPE_SEND = 0X2;
}

class Message implements Serializable {// 根据上面我们的分析，也就是信息所要携带的四种属性：来向，去向，信息内容，信息类型，再就是一些getset方法。

	private static final long serialVersionUID = 1L;
	private String from;
	private String to;
	private String info;
	private int message;

	public Message(String from, String to, String info, int message) {
		this.from = from;
		this.to = to;
		this.info = info;
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message{" + "from='" + from + '\'' + ", to='" + to + '\'' + ", info='" + info + '\'' + ", message="
				+ message + '}';
	}

	public Message() {
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getMessage() {
		return message;
	}

	public void setMessage(int message) {
		this.message = message;
	}
}

public class Server {/*
						 * 这块我用到了线程池来创建线程，给了5个线程，所以这个服务器端可以接受的客户端是5个，然后就是一个accept阻塞等待连接，直接给线程池提交任务。
						 */
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Vector<UserThread> userThreads = new Vector<>(5);// Vector 可实现自动增长的对象数组。 nextElement() 来获取下一个元素
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(6666);
			System.out.println("服务器启动成功");
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("客户端：" + socket.getRemoteSocketAddress()+ "连接成功");//端口号
				executorService.execute(new UserThread(socket, userThreads));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class UserThread implements Runnable {/*
										 * 这个类是真正实现逻辑的地方，说一下大体思路，就是不断的读信息，如果读到的信息类型（MessageType）是登录信息，那么就证明第一次连接建立，
										 * 如果读到的是发送信息，那么就根据信息的去向（to），在线程集合（Vector）中去找对应的线程，然后将Message转发给对应的线程。
										 */
	private String name;
	private Message message;
	private Socket socket;
	private Vector<UserThread> userThreads;
	private ObjectInputStream objectInputStream = null;
	private ObjectOutputStream objectOutputStream = null;

	public UserThread(Socket socket, Vector<UserThread> userThreads) {
		this.socket = socket;
		this.userThreads = userThreads;
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
				if (socket.isBound()==false) {
					break; 
				}
				message = (Message) objectInputStream.readObject();
				System.out.println(message);
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}

			if (message.getMessage() == MessageType.TYPE_LOGIN) {
				this.name = message.getFrom();
				Message message1 = new Message("服务器", this.message.getFrom(), "登录成功", MessageType.TYPE_LOGIN);
				try {
					objectOutputStream.writeObject(message1);
					objectOutputStream.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (message.getMessage() == MessageType.TYPE_SEND) {
				String to = message.getTo();
				Iterator<UserThread> iterator = userThreads.iterator();
				while (iterator.hasNext()) {
					UserThread next = iterator.next();
					if (next.getName().equals(to)) {
						try {
							next.getObjectOutputStream().writeObject(message);
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

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}
