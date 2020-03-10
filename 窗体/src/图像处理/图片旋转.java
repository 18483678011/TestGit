package ͼ����;

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

public class ͼƬ��ת extends JFrame {
	private Image image = new ImageIcon("C:\\Users\\BUG\\Desktop\\QQͼƬ20190923213316.jpg").getImage();
	private canvasTest catsTest = new canvasTest();
	private JPanel jPanel1, jPanel2;
	private JButton jb1 = new JButton("˳ʱ����ת"), jb2 = new JButton("��ʱ����ת");
	private int width = 500, height = 600;
	double s = 0, rotationAngle = 90;// ����Ŀ����
	private int getwidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2 - width / 2;// ��ȡ����Ŀ�������λ��
	private int getheigt = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2 - height / 2;// ��ȡ����ĸ�
	private static final long serialVersionUID = 1L;

	public ͼƬ��ת() {
		setTitle("ͼƬ��ת");
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(getwidth, getheigt, width, height);
		setContentPane(jPanel1);
		jPanel1.setLayout(new BorderLayout());
		jPanel1.add(catsTest, BorderLayout.CENTER);
		jPanel1.add(jPanel2, BorderLayout.SOUTH);
		jPanel2.setLayout(new FlowLayout(1, 20, 5));// Ϊ0��ʾ����룬Ϊ1��ʾ���ж��룬Ϊ2��ʾ�Ҷ��롣
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
		new ͼƬ��ת();
	}

	class canvasTest extends Canvas {

		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.rotate(Math.toRadians(s), image.getWidth(this) / 2 + 100, image.getHeight(this) / 2 + 80);//��ת
			// Math.toRadians(s),���Ƕ�ֵsת�������ơ���1�� -��ת���ȵĽǣ���2�� x -��ת��ԭ������ ����3��y -��ת��ԭ������ ��

			g2.drawImage(image, 100, 80, this);// ���Ͻ�����
		}

	}
}