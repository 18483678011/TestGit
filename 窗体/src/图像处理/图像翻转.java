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

public class ͼ��ת extends JFrame {
	int getwidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;//��ȡ��Ļ�Ŀ�
	int getheight=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;//��ȡ��Ļ�ĸ�

	private static final long serialVersionUID = 1L;
	JPanel jPanel1 = new JPanel();
	JPanel jPanel2 = new JPanel();
	JPanel jPanel3 = new JPanel();
	JScrollPane pane = null;
	Image image = new ImageIcon("C:\\Users\\BUG\\Desktop\\QQͼƬ20190923213316.jpg ").getImage();
	private int sx1, sy1, sx2, sy2;// ԭ�������ϽǺ����½�(ͼƬ������ʾ�Ĵ�С)(���ϽǺ����½�)
	private int dx1, dy1, dx2, dy2;// Ŀ����ζ�Ӧ������(�ڽ����е�λ�ô�С);(���ϽǺ����½�)�൱������װͼƬ
	private final int dxs, dys, width, hight;// dxs��¼ԭ��sx1����ʼX���꣬dys��¼ԭ��sx1����ʼY���� ,ͼƬ���

	JButton jButton1 = new JButton("ˮƽ��ת");
	JButton jButton2 = new JButton("��ֱ��ת");
	JButton jButton3 = new JButton("��ԭ");
	private MCanvar yCanvar = new MCanvar();

	public ͼ��ת() {
		System.out.println(getwidth+"\t"+getheight);
		Container container = getContentPane();
		dxs = 100;// ͼƬ��ʾλ��x
		dys = 100;// ͼƬ��ʾy����
		width = image.getWidth(this);// ͼƬ��
		hight = image.getHeight(this);// ͼƬ��
		sx1 = 0;
		sy1 = 0;
		dx1 = dxs;// ��ʼ����Ŀ����κ�ԭ�������Ͻ�������ԭ��
		dy1 = dys;
		sx2 = width;// ����ͼƬ��
		sy2 = hight;// ����ͼƬ��
		dx2 = width + dxs;
		dy2 = hight + dys;

		setTitle("ͼƬ����");
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
				yCanvar.repaint();// �ػ�
			}
		});

		jButton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dy1 = Math.abs(dy1 - (hight + dys)) + dys;
				dy2 = Math.abs(dy2 - (hight + dys)) + dys;
				yCanvar.repaint();// �ػ�
			}
		});

		jButton3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dx1 = dxs;// ��ʼ����Ŀ����κ�ԭ�������Ͻ�������ԭ��
				dy1 = dys;
				dx2 = width + dxs;
				dy2 = hight + dys;
				yCanvar.repaint();// �ػ�
			}
		});
	}

	public static void main(String[] args) {
		new ͼ��ת().setVisible(true);
	}

	class MCanvar extends Canvas {

		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;

			g2.drawImage(image, dx1, dy1, dx2, dy2, // ԭ����
					sx1, sy1, sx2, sy2, // Ŀ�����
					this);

		}
	}
}
