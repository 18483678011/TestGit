package 图像处理;

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

public class 图片缩放 extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel jPanel1 = new JPanel();
	JPanel jPanel2 = new JPanel();
	JPanel jPanel3 = new JPanel();
	JScrollPane pane = null;
	int getwidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;// 获取屏幕的宽
	int getheight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;// 获取屏幕的高

	JButton jButton1 = new JButton("放大");
	JButton jButton2 = new JButton("缩小");
	JButton jButton3 = new JButton("还原");
	private MCanvar yCanvar = new MCanvar();
	int[] sz = { getwidth / 2 - 175, getheight / 2 - 250 };
	int Scale = 20;
	int s = 0;

	public 图片缩放() {
		setTitle("图片缩放");
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

			public void actionPerformed(ActionEvent e) {// 放大
				Scale();
				yCanvar.repaint();// 重新绘制画布
				int imagh = yCanvar.geteight();// 获取长度
				int imget = yCanvar.getidth();// 获取宽度
				int geth = imagh + s;
				int getw = imget * s / imagh + imget;// 按比例缩放
				setBounds(sz[0] - (imget * s / imagh) / 2, sz[1] - s / 2, getw + 55, geth + 100);
			}
		});

		jButton3.addActionListener(new ActionListener() {// 还原

			public void actionPerformed(ActionEvent e) {
				s = 0;
				yCanvar.repaint();// 重新绘制画布

				setBounds(sz[0], sz[1], yCanvar.getidth() + 55, yCanvar.geteight() + 100);
			}
		});

		jButton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {// 缩小
				narrow();
				yCanvar.repaint();// 重新绘制画布
				int imagh = yCanvar.geteight();// 获取长度
				int imget = yCanvar.getidth();// 获取宽度
				int geth = imagh + s;
				int getw = imget * s / imagh + imget;// 按比例缩放
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
		new 图片缩放().setVisible(true);
	}

	class MCanvar extends Canvas {
		private static final long serialVersionUID = 1L;
		Image image;

		public void name() {
			image = new ImageIcon("C:\\Users\\BUG\\Desktop\\QQ图片20190923213316.jpg").getImage();// 获取图片
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
			int imagh = image.getHeight(this);// 获取长度
			int imget = image.getWidth(this);// 获取宽度
			int geth = imagh + s;
			int getw = imget * s / imagh + imget;// 按比例缩放
			g2.drawImage(image, 20, 20, getw, geth, this);// 画图 this 通知要显示的界面
		}
	}
}
