package ͼ����;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ����ͼ�� extends JFrame {
	private static ����ͼ�� tuxiang = null;
	private MyCanvar canvar = new MyCanvar();
	private static final long serialVersionUID = 1L;
	int getwidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;// ��ȡ��Ļ�Ŀ�
	int getheight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;// ��ȡ��Ļ�ĸ�
	Image image = new ImageIcon("C:\\Users\\BUG\\Desktop\\QQͼƬ20190923213316.jpg").getImage();// ��ȡͼƬ
	int s = image.getHeight(this);// ��
	int w = image.getWidth(this);// ��

	public static void name() {
		tuxiang = new ����ͼ��();
		tuxiang.setVisible(true);
	}

	public ����ͼ��() {
		this.setBounds(getwidth / 2 - w / 2, getheight / 2 - s / 2, 700, 600);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ͼƬ����");
		add(canvar);
	}

	public static void main(String[] args) {
		����ͼ��.name();
	}

	class MyCanvar extends Canvas {
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;

			g2.drawImage(image, 200, 50, tuxiang);// ��ͼ
		}

	}
}
