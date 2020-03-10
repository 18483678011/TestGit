package 图像处理;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class 绘制图像 extends JFrame {
	private static 绘制图像 tuxiang = null;
	private MyCanvar canvar = new MyCanvar();
	private static final long serialVersionUID = 1L;
	int getwidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;// 获取屏幕的宽
	int getheight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;// 获取屏幕的高
	Image image = new ImageIcon("C:\\Users\\BUG\\Desktop\\QQ图片20190923213316.jpg").getImage();// 获取图片
	int s = image.getHeight(this);// 高
	int w = image.getWidth(this);// 宽

	public static void name() {
		tuxiang = new 绘制图像();
		tuxiang.setVisible(true);
	}

	public 绘制图像() {
		this.setBounds(getwidth / 2 - w / 2, getheight / 2 - s / 2, 700, 600);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("图片加载");
		add(canvar);
	}

	public static void main(String[] args) {
		绘制图像.name();
	}

	class MyCanvar extends Canvas {
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;

			g2.drawImage(image, 200, 50, tuxiang);// 画图
		}

	}
}
