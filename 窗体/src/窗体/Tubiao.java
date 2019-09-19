package 窗体;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Tubiao implements Icon{		
	private int width;//图标宽
	private int height;//图标长度。
	public Tubiao (int width,int height) {
		this.height=height;
		this.width=width;
	}	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {//在指定位置画图
		// TODO 自动生成的方法存根
		g.fillOval(x, y, width, height);
	}
	@Override
	public int getIconWidth() {//获取图标宽度
		// TODO 自动生成的方法存根
		return this.width;
	}
	@Override
	public int getIconHeight() {//获取图标长度
		// TODO 自动生成的方法存根
		return this.height;
	}
	public static void main(String[] args) {
		new jf();
	
		

	}

}

class jf extends JFrame{
	 public jf() {
		JFrame a=new JFrame("这是一个窗体");
		a.setBounds(500, 400, 400, 300);
		a.setLocationByPlatform(true);
		a.setLayout(null);//使用该窗体取消布局管理器设置
		a.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		a.setBackground(Color.BLUE);
		JButton jb=new JButton();
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new dome(a);								
			}
		});
		JButton jb1=new JButton("按钮");		
		jb.setText("点击获取");
		jb.setBounds(250, 10, 90, 25);	
		jb1.setBounds(100, 50, 100, 40);
		Container con=a.getContentPane();
		con.add(jb);
		con.add(jb1);		
		// TODO 自动生成的构造函数存根
		a.setVisible(true);
	}
		
	
}
