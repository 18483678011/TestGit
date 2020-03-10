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

public class 图像翻转 extends JFrame {
	int getwidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的宽
	int getheight=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高

	private static final long serialVersionUID = 1L;
	JPanel jPanel1 = new JPanel();
	JPanel jPanel2 = new JPanel();
	JPanel jPanel3 = new JPanel();
	JScrollPane pane = null;
	Image image = new ImageIcon("C:\\Users\\BUG\\Desktop\\QQ图片20190923213316.jpg ").getImage();
	private int sx1, sy1, sx2, sy2;// 原矩形左上角和右下角(图片本身显示的大小)(左上角和右下角)
	private int dx1, dy1, dx2, dy2;// 目标矩形对应角坐标(在界面中的位置大小);(左上角和右下角)相当于容器装图片
	private final int dxs, dys, width, hight;// dxs记录原点sx1的起始X坐标，dys记录原点sx1的起始Y坐标 ,图片宽高

	JButton jButton1 = new JButton("水平旋转");
	JButton jButton2 = new JButton("垂直旋转");
	JButton jButton3 = new JButton("还原");
	private MCanvar yCanvar = new MCanvar();

	public 图像翻转() {
		System.out.println(getwidth+"\t"+getheight);
		Container container = getContentPane();
		dxs = 100;// 图片显示位置x
		dys = 100;// 图片显示y坐标
		width = image.getWidth(this);// 图片宽
		hight = image.getHeight(this);// 图片高
		sx1 = 0;
		sy1 = 0;
		dx1 = dxs;// 初始化，目标矩形和原矩形左上角坐标在原点
		dy1 = dys;
		sx2 = width;// 等于图片宽
		sy2 = hight;// 等于图片高
		dx2 = width + dxs;
		dy2 = hight + dys;

		setTitle("图片缩放");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(getwidth/2-(650/2), ((getheight/2-(550+dys)/2)), 650, 550 + dys);
		container.add(jPanel1);
		jPanel1.setLayout(new BorderLayout());
		jPanel1.add(yCanvar, BorderLayout.CENTER);
		jPanel2.add(jButton1);
		jPanel2.add(jButton2);
		jPanel2.add(jButton3);
		jPanel1.add(jPanel2, BorderLayout.SOUTH);
		jButton1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dx1 = Math.abs(dx1 - (width + dxs)) + dxs;
				dx2 = Math.abs(dx2 - (width + dxs)) + dxs;
				yCanvar.repaint();// 重画
			}
		});

		jButton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dy1 = Math.abs(dy1 - (hight + dys)) + dys;
				dy2 = Math.abs(dy2 - (hight + dys)) + dys;
				yCanvar.repaint();// 重画
			}
		});

		jButton3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dx1 = dxs;// 初始化，目标矩形和原矩形左上角坐标在原点
				dy1 = dys;
				dx2 = width + dxs;
				dy2 = hight + dys;
				yCanvar.repaint();// 重画
			}
		});
	}

	public static void main(String[] args) {
		new 图像翻转().setVisible(true);
	}

	class MCanvar extends Canvas {

		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;

			g2.drawImage(image, dx1, dy1, dx2, dy2, // 原矩形
					sx1, sy1, sx2, sy2, // 目标矩形
					this);

		}
	}
}
