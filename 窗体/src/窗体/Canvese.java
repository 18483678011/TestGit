package ����;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;

public class Canvese extends JFrame {
	
	public Canvese() {
		setTitle("��ͼ");
		setBounds(700, 350, 800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		canClass class1=new canClass();
		add(class1);
	}
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Canvese();
	}
	class canClass extends Canvas{
	
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			Graphics2D g2=(Graphics2D)g;
			g2.setColor(new Color(123,125,255));//������ɫ
			 int  s=15;
			while (s<=500) {
			 s=s+15;
				g2.drawOval(s,15, 100, 100);//��Բ
				
				g2.drawRect(s, 25, 80, 80);//����1.��ʾ�ĳ�2.��ʾ�Ŀ�3.���γ�4.���εĿ�
			}
			Stroke stroke=new BasicStroke(5);//�������ʣ����ʿ��Ϊ8����
			g2.setStroke(stroke);//���ػ���
			int[] xPoints= {10,30,45,87,700};
			int[] yPoints= {10,30,10,51,88};
			g2.drawPolygon(xPoints, yPoints, 5);//����Σ�5���Σ�
			g2.drawRoundRect(300, 200, 100, 100, 50, 100);
			g2.setColor( Color.red);//������ɫ
			Shape shape=new Rectangle2D.Double(200, 200, 80, 80);//�������ζ���
			g2.draw(shape);//���
			Shape shape2=new Ellipse2D.Double(400, 200, 100, 100);//����һ��Բ����
			g2.draw(shape2);
			g2.drawArc(100, 200, 40, 80, 0, 180);//���� λ�ã�xy�� ��С(����)   ��ʼ�Ƕȣ������Ƕ�
			g2.drawLine(100, 20, 300, 200);//��ֱ��ͷ����������1��������������2
			g2.drawRoundRect(150, 200, 50, 100, 25, 25);//Բ�Ǿ���
			
		}
	}
}
