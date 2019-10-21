package udpTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Receive extends JFrame implements Runnable, ActionListener {

	private static final long serialVersionUID = 1L;
	int port = 9898;
	ScrollPane pane = null;//滚动条面板
	ScrollPane pane1 = null;
	InetAddress group = null;//IP类
	MulticastSocket socket = null;//多点广播套接字
	JButton ince = new JButton("开始接收");
	JButton empty = new JButton("清空");
	JButton stop = new JButton("停止接收");
	JTextArea inArea = new JTextArea(10, 20);//文本框  10行，每行10个。
	JTextArea inced = new JTextArea(10, 20);
	Thread thread;
	boolean b = false;

	public Receive() {
		super("广播接收");
		setBounds(400, 350, 500, 250);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		thread = new Thread(this);
		ince.addActionListener(this);
		stop.addActionListener(this);
		empty.addActionListener(this);

		inArea.setForeground(Color.blue);
		JPanel jPanel = new JPanel();
		jPanel.add(ince);
		jPanel.add(stop);
		jPanel.add(empty);
		add(jPanel, BorderLayout.NORTH);
		pane = new ScrollPane();
		pane1 = new ScrollPane();
		pane.add(inced);
		pane1.add(inArea);
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new GridLayout(1, 2));
		jPanel2.add(pane1);
		jPanel2.add(pane);
		add(jPanel2, BorderLayout.CENTER);
		validate();
		inArea.setEditable(false);//不可以添加文本
		inced.setEditable(false);
		setVisible(true);
		try {
			group = InetAddress.getByName("224.255.10.2");
			socket = new MulticastSocket(port);
			socket.joinGroup(group);//加入广播组
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Receive();
	}

	public void actionPerformed(ActionEvent e) {//动作监听
		if (e.getSource() == ince) {
			ince.setBackground(Color.red);
			stop.setBackground(Color.yellow);
			if (!thread.isAlive()) {
				thread = new Thread(this);
			}
			thread.start();
			b = false;
		}
		if (e.getSource() == stop) {
			ince.setBackground(Color.yellow);
			stop.setBackground(Color.red);
			b = true;
		}
		if (e.getSource() == empty) {
			inced.setText("");
		}
	}

	public void run() {
		while (true) {
			byte data[] = new byte[100];
			DatagramPacket dPacket = null;//数据包类
			dPacket = new DatagramPacket(data, data.length, group, port);//内存空间，内存大小，
			//数据包的目标地址以及端口。
			try {
				socket.receive(dPacket);
				String string = new String(dPacket.getData(), 0, dPacket.getLength());
				inArea.setText("正在接收的内容：\n" + string);
				inced.append(string + '\n');
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (b == true) {
				break;
			}
		}
	}
}
