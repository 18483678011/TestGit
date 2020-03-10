package 图像处理;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class 图片拉伸 extends JFrame {
	private JButton jButton1, jButton2, jButton3, jButton4;
	private JPanel jp1, jp2;
	int Width = 0, Height = 0,sw=200,wh=100;
	private static 图片拉伸 tuxiang = null;
	private MyCanvar canvar1 = new MyCanvar();
	private static final long serialVersionUID = 1L;
	int getwidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;// 获取屏幕的宽
	int getheight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;// 获取屏幕的高
	Image image = new ImageIcon("C:\\Users\\BUG\\Desktop\\QQ图片20190923213316.jpg").getImage();// 获取图片
	int s = image.getHeight(this);// 高
	int w = image.getWidth(this);// 宽

	public static void name() {
		tuxiang = new 图片拉伸();
		tuxiang.setVisible(true);
	}

	public 图片拉伸() {
		this.setBounds(getwidth / 2 - 350, getheight / 2 - 350, 700, 700);
		Container contentPane = getContentPane();
		jp1 = new JPanel();
		contentPane.add(jp1);
		jp1.setLayout(new BorderLayout());
		jp1.add(canvar1, BorderLayout.CENTER);
		jp2 = new JPanel();
		jp1.add(jp2, BorderLayout.SOUTH);
		jp2.setLayout(new FlowLayout(1, 50, 20));
		jButton1 = new JButton("右拉");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sw-=9;
				Width += 5;
				canvar1.repaint();
			}
		});
		jButton2 = new JButton("左拉");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sw+=9;
				Width -= 5;
				canvar1.repaint();
			}
		});
		jButton3 = new JButton("上拉");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wh+=18;
				Height -= 5;
				canvar1.repaint();
			}
		});
		jButton4 = new JButton("下拉");
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wh-=18;
				Height += 5;
				canvar1.repaint();
			}
		});
		jp2.add(jButton1);
		jp2.add(jButton2);
		jp2.add(jButton3);
		jp2.add(jButton4);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("图片拉伸");

	}

	public static void main(String[] args) {
		图片拉伸.name();
	}

	class MyCanvar extends Canvas {
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.shear(Math.toRadians(Width), Math.toRadians(Height));
			g2.drawImage(image, sw, wh,w,s,tuxiang);// 画图
		}
	}

}
