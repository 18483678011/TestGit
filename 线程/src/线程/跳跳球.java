package �߳�;

import java.awt.Color;
import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ������ extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jL = new JLabel();
	private static Thread t; 
	private Container container = getContentPane();
	static int a = 5, b = 7;// a��С�������ƶ����ٶ�,b��С�������ƶ����ٶ�
	static int x = 0, y = 0;// С��ĳ�ʼ����
	
	private JLabel getJLabel() {
		Icon icon = new ImageIcon("E:\\my_java\\�߳�\\src\\�߳�\\cut.png");
		jL.setIcon(icon);
		jL.setHorizontalAlignment(SwingConstants.LEFT);// ����ͼƬ�ڱ�ǩ�����
		jL.setBounds(10, 10, 40, 40);
		jL.setBackground(Color.YELLOW);
		//jL.setOpaque(true);//���ñ����Ƿ�͸����
		return jL;
	}

	public ������() {
		setTitle("������");
		setBounds(300, 200, 400, 430);
		container.setLayout(null);
		container.setBackground(Color.YELLOW);
		//setResizable(false);//���岻���Ըı��С
		t = new Thread(new Runnable() {
			public void run() {
				while (true) {
					if (x < 0 || x >= container.getWidth()-40)//��ȡ������� ����ʱ�����Ա�
						b = -b;
					if (y < 0 || y >= container.getHeight()-40)//��ȡ�������� ����ʱ�����Ա�
						a = -a;
					x = x + b;
					y = y + a;
					jL.setBounds(x, y, 50, 50);
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
					}
				}
			}
				
		});
		t.start();
		container.add(getJLabel());setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ������();
	}
}
