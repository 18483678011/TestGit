package 窗体;

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
		setTitle("画图");
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
			g2.setColor(new Color(123,125,255));//设置颜色
			 int  s=15;
			while (s<=500) {
			 s=s+15;
				g2.drawOval(s,15, 100, 100);//画圆
				
				g2.drawRect(s, 25, 80, 80);//矩形1.显示的长2.显示的宽3.矩形长4.矩形的宽
			}
			Stroke stroke=new BasicStroke(5);//创建画笔，画笔宽度为8像素
			g2.setStroke(stroke);//加载画笔
			int[] xPoints= {10,30,45,87,700};
			int[] yPoints= {10,30,10,51,88};
			g2.drawPolygon(xPoints, yPoints, 5);//多边形（5边形）
			g2.drawRoundRect(300, 200, 100, 100, 50, 100);
			g2.setColor( Color.red);//设置颜色
			Shape shape=new Rectangle2D.Double(200, 200, 80, 80);//创建矩形对象
			g2.draw(shape);//添加
			Shape shape2=new Ellipse2D.Double(400, 200, 100, 100);//创建一个圆对象
			g2.draw(shape2);
			g2.drawArc(100, 200, 40, 80, 0, 180);//弧线 位置（xy） 大小(长宽)   起始角度，结束角度
			g2.drawLine(100, 20, 300, 200);//画直线头两个是坐标1，后两个是坐标2
			g2.drawRoundRect(150, 200, 50, 100, 25, 25);//圆角矩形
			
		}
	}
}
