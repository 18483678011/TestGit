package ͼ����;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ͼƬ���� extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel jPanel1 = new JPanel();
	JPanel jPanel2 = new JPanel();
	JPanel jPanel3 = new JPanel();
	JScrollPane pane = null;
	int getwidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;// ��ȡ��Ļ�Ŀ�
	int getheight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;// ��ȡ��Ļ�ĸ�

	JButton jButton1 = new JButton("�Ŵ�");
	JButton jButton2 = new JButton("��С");
	JButton jButton3 = new JButton("��ԭ");
	private MCanvar yCanvar = new MCanvar();
	int[] sz = { getwidth / 2 - 175, getheight / 2 - 250 };
	int Scale = 20;
	int s = 0;

	public ͼƬ����() {
		setTitle("ͼƬ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(sz[0], sz[1], 350, 500);

		// Container contentPane = getContentPane();
		// contentPane.add(pane);
		this.setContentPane(jPanel1);
		jPanel1.setLayout(new BorderLayout());
		jPanel1.add(yCanvar, BorderLayout.CENTER);
		jPanel2.add(jButton1);
		jPanel2.add(jButton2);
		jPanel2.add(jButton3);
		jPanel1.add(jPanel2, BorderLayout.SOUTH);
		jButton1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {// �Ŵ�
				Scale();
				yCanvar.repaint();// ���»��ƻ���
				int imagh = yCanvar.geteight();// ��ȡ����
				int imget = yCanvar.getidth();// ��ȡ���
				int geth = imagh + s;
				int getw = imget * s / imagh + imget;// ����������
				setBounds(sz[0] - (imget * s / imagh) / 2, sz[1] - s / 2, getw + 55, geth + 100);
			}
		});

		jButton3.addActionListener(new ActionListener() {// ��ԭ

			public void actionPerformed(ActionEvent e) {
				s = 0;
				yCanvar.repaint();// ���»��ƻ���

				setBounds(sz[0], sz[1], yCanvar.getidth() + 55, yCanvar.geteight() + 100);
			}
		});

		jButton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {// ��С
				narrow();
				yCanvar.repaint();// ���»��ƻ���
				int imagh = yCanvar.geteight();// ��ȡ����
				int imget = yCanvar.getidth();// ��ȡ���
				int geth = imagh + s;
				int getw = imget * s / imagh + imget;// ����������
				setBounds(sz[0] - (imget * s / imagh) / 2, sz[1] - s / 2, getw + 55, geth + 100);
			}
		});
	}

	public int Scale() {
		return s += Scale;
	}

	public int narrow() {
		return s -= Scale;
	}

	public static void main(String[] args) {
		new ͼƬ����().setVisible(true);
	}

	class MCanvar extends Canvas {
		private static final long serialVersionUID = 1L;
		Image image;

		public void name() {
			image = new ImageIcon("C:\\Users\\BUG\\Desktop\\QQͼƬ20190923213316.jpg").getImage();// ��ȡͼƬ
		}

		public int geteight() {
			return image.getHeight(this);
		}

		public int getidth() {
			return image.getWidth(this);
		}

		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			name();
			int imagh = image.getHeight(this);// ��ȡ����
			int imget = image.getWidth(this);// ��ȡ���
			int geth = imagh + s;
			int getw = imget * s / imagh + imget;// ����������
			g2.drawImage(image, 20, 20, getw, geth, this);// ��ͼ this ֪ͨҪ��ʾ�Ľ���
		}
	}
}
