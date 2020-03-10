package 图像处理;

import java.awt.BorderLayout;
import java.awt.Canvas;
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

public class 图片旋转 extends JFrame {
	private Image image = new ImageIcon("C:\\Users\\BUG\\Desktop\\QQ图片20190923213316.jpg").getImage();
	private canvasTest catsTest = new canvasTest();
	private JPanel jPanel1, jPanel2;
	private JButton jb1 = new JButton("顺时针旋转"), jb2 = new JButton("逆时针旋转");
	private int width = 500, height = 600;
	double s = 0, rotationAngle = 90;// 窗体的宽与高
	private int getwidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2 - width / 2;// 获取界面的宽在中心位置
	private int getheigt = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2 - height / 2;// 获取界面的高
	private static final long serialVersionUID = 1L;

	public 图片旋转() {
		setTitle("图片旋转");
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(getwidth, getheigt, width, height);
		setContentPane(jPanel1);
		jPanel1.setLayout(new BorderLayout());
		jPanel1.add(catsTest, BorderLayout.CENTER);
		jPanel1.add(jPanel2, BorderLayout.SOUTH);
		jPanel2.setLayout(new FlowLayout(1, 20, 5));// 为0表示左对齐，为1表示居中对齐，为2表示右对齐。
		jPanel2.add(jb1);
		jPanel2.add(jb2);
		jb1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				s += rotationAngle;
				catsTest.repaint();
			}
		});
		jb2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				s -= rotationAngle;
				catsTest.repaint();
			}
		});
		setVisible(true);
	}

	public static void main(String[] args) {
		new 图片旋转();
	}

	class canvasTest extends Canvas {

		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.rotate(Math.toRadians(s), image.getWidth(this) / 2 + 100, image.getHeight(this) / 2 + 80);//旋转
			// Math.toRadians(s),将角度值s转化弧度制。（1） -旋转弧度的角，（2） x -旋转的原点坐标 ，（3）y -旋转的原点坐标 ；

			g2.drawImage(image, 100, 80, this);// 右上角坐标
		}

	}
}