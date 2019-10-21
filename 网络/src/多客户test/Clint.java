package 多客户test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Clint extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static User user = new User();
	private Container con;
	private JTextArea jt;
	private JTextField jField;
	private JButton button;
	private JLabel sJLabel;
	private boolean sss = true;
	private String[] string;

	public Clint(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 800, 500);
		con = getContentPane();// 容器
		con.setLayout(new BorderLayout());
		ScrollPane pane = new ScrollPane();
		jt = new JTextArea();
		jt.append("输入ID,名字登录");
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

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jField) {
			jt.append("我：" + jField.getText() + "\n");
			jt.setSelectionEnd(jt.getText().length());
			jField.setText("");
		}
		if (e.getSource() == button) {
			if (user.getID() != 0) {
				return;
			}
			if (user.getName() == null) {
				String text = jField.getText();
				string = text.split(",");
				for (int i = 0; i < string.length; i++) {
					if (i == 0) {
						user.setID(Integer.parseInt(string[i]));
					}
					if (i == 1) {
						user.setName(string[i]);
					}

				}

			}
			jField.setText("");
			button.setEnabled(false);
			getclint();
			/*
			 * s = (s + 1) % 7; switch (s) { case 0: jt.setBackground(Color.WHITE); break;
			 * case 1: jt.setBackground(Color.YELLOW); break; case 2:
			 * jt.setBackground(Color.BLACK); jt.setForeground(Color.WHITE); break; case 3:
			 * jt.setForeground(Color.BLACK); jt.setBackground(Color.BLUE); break; case 4:
			 * jt.setBackground(Color.CYAN); break; case 5: jt.setBackground(Color.GRAY);
			 * break; case 6: jt.setBackground(Color.GREEN); break; default: break; }
			 */
		}
	}

	public void run() {
		new Thread(new Runnable() {

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
		}).start();
	}

	public void qumingz() {

	}

	public void getclint() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();// 单线程化线程池(newSingleThreadExecutor)
		Socket socket = null;
		int ID = 0;
		ObjectOutputStream objectOutputStream = null;// 输出
		try {
			socket = new Socket("127.0.0.1", 8998);
			jt.append("与服务器连接成功" + "\n");
			jt.append("登录人Name:" + user.getName() + "\n");
			jt.append("登录人ID:" + user.getID() + "\n");
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			executorService.execute(new ReadThread(socket, ID,jt));
			user.setID(ID);
			user.setInfo("我要登陆");
			user.setUser(MessageType.TYPE_LOGIN);
			user.setInfo(null);
			objectOutputStream.writeObject(user);
			objectOutputStream.flush();
			while (true) {
				User MessageSend = new User();
				MessageSend.setID(ID);
				MessageSend.setUser(MessageType.TYPE_SEND);
				jt.append("请输入目标名称" + "\n");			
				MessageSend.setID(Integer.parseInt(jField.getText()));
				jt.append("请输入消息：" + "\n");
				MessageSend.setInfo(jField.getText());
				objectOutputStream.writeObject(MessageSend);
				objectOutputStream.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
				socket.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Clint clint = new Clint("客戶端");
		clint.run();
		// clint.getclint();
	}
}

class ReadThread implements Runnable {// 新建线程用来专门读信息
	Socket socket;
	int ID;
	JTextArea jt;
	public ReadThread(Socket socket, int id ,JTextArea jt) {
		this.socket = socket;
		this.ID = id;
		this.jt=jt;
	}

	@Override
	public void run() {
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			while (true) {
				try {
					User message = (User) objectInputStream.readObject();
					if (message.getID() != ID && message.getInfo() != null) {
						String string=("[" + message.getID() + "] : " + "[" + message.getInfo() + "]");
						jt.append(string);
					} else {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
