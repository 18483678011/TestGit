package �����ͻ���;

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
							 * �������Ҫ���������ֺ������Message��Ҳ����������˵����Ϣ�����ͣ� ���������趨���������ͣ�һ���ǵ�¼��Ϣ��һ���Ƿ�����Ϣ��
							 * �������˿���ͨ�����������������Ϣ�����͡�
							 */
	public static final int TYPE_LOGIN = 0X1;
	public static final int TYPE_SEND = 0X2;
}

class Message implements Serializable {// �����������ǵķ�����Ҳ������Ϣ��ҪЯ�����������ԣ�����ȥ����Ϣ���ݣ���Ϣ���ͣ��پ���һЩgetset������

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
						 * ������õ����̳߳��������̣߳�����5���̣߳���������������˿��Խ��ܵĿͻ�����5����Ȼ�����һ��accept�����ȴ����ӣ�ֱ�Ӹ��̳߳��ύ����
						 */
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Vector<UserThread> userThreads = new Vector<>(5);// Vector ��ʵ���Զ������Ķ������顣 nextElement() ����ȡ��һ��Ԫ��
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(6666);
			System.out.println("�����������ɹ�");
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("�ͻ��ˣ�" + socket.getRemoteSocketAddress()+ "���ӳɹ�");//�˿ں�
				executorService.execute(new UserThread(socket, userThreads));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class UserThread implements Runnable {/*
										 * �����������ʵ���߼��ĵط���˵һ�´���˼·�����ǲ��ϵĶ���Ϣ�������������Ϣ���ͣ�MessageType���ǵ�¼��Ϣ����ô��֤����һ�����ӽ�����
										 * ����������Ƿ�����Ϣ����ô�͸�����Ϣ��ȥ��to�������̼߳��ϣ�Vector����ȥ�Ҷ�Ӧ���̣߳�Ȼ��Messageת������Ӧ���̡߳�
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
				Message message1 = new Message("������", this.message.getFrom(), "��¼�ɹ�", MessageType.TYPE_LOGIN);
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
