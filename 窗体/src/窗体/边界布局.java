
package 窗体;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class 边界布局 extends JFrame {
	JPanel p = new JPanel();
	// JPanel 是 Java图形用户界面(GUI)工具包swing中的面板容器类，包含在javax.swing
	// 包中，是一种轻量级容器，可以加入到JFrame窗体中。JPanel默认的布局管理器是FlowLayout，
	// 其自身可以嵌套组合，在不同子容器中可包含其他组件(component),如JButton、JTextArea、JTextField
	// 等
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	public 边界布局() {
		setTitle("边距布局视图");//标题名字。
		setBounds(470, 250, 600, 400);//大小位置 
		//setResizable(false);//大小不可以改变。
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭方式。
		Container c = getContentPane();// 获取容器
		c.setLayout(new BorderLayout());// 布局为边界布局
		
		JButton b = new JButton("上");// 按钮
		JButton d1 = new JButton("345");
		JButton d2 = new JButton("111");
	
		p.setLayout(new FlowLayout(0, 10, 10));//左对齐
		for (int x = 1; x <= 10; x++) {
			JButton f = new JButton(String.valueOf(x));
			p.add(f); // 将按钮添加到面板中
		}
		p1.setLayout(new FlowLayout(1, 10, 10));// 用流布局 居中布局   生成4个按钮
		for (int x = 1; x <= 4; x++) {
			JButton f = new JButton(String.valueOf(x));// 获取相对应的x值
			p1.add(f); // 将按钮添加到面板中
		}
		
		/*插入时每个控件只能用一次
		例如
		JButton d1 = new JButton("345");
		不能这样
		c.add(d1,BorderLayout.EAST);//右边
		c.add(d1,BorderLayout.WEST);//左边
		右边用了，下面就不能再用了。*/
		
		
		p2.setLayout(new FlowLayout(1, 10, 10));// 用流布局 居中布局   生成4个按钮
		for (int x = 1; x <= 10; x++) {
			JButton f = new JButton(String.valueOf(x));// 获取相对应的x值
			p2.add(f); // 将按钮添加到面板中
		}
		setTitle("边距布局视图");
//-----------------------------------------------------
		//p.setLayout(null);                  插入方法一
		//JButton d = new JButton("345");
		// d.setBounds(100, 50, 100, 30);
		// p.add(d);
		//c.add(p,BorderLayout.CENTER);
//-------------------------------------------------------	
		//插入方式2.
		// getContentPane().add("South", new JButton("South"));
		// getContentPane().add("East", new JButton("East"));
		// getContentPane().add("West", new JButton("West"));
//--------------------------------------------------------------
		//插入方法3.
		/*getContentPane().add("East", d1);
		getContentPane().add("West", d2);
		getContentPane().add("South", p1);
		getContentPane().add("Center", p);*/
//----------------------------------------------------------------	
		//插入方法4.
		c.add(b, BorderLayout.NORTH);// 将上按钮设置在上边
		c.add(d1,BorderLayout.EAST);//右边
		c.add(d2,BorderLayout.WEST);//左边
		c.add(p,BorderLayout.CENTER);//中间
		c.add(p1,BorderLayout.SOUTH);//下面
//----------------------------------------------------------------
		setVisible(true);
	}
	public static void main(String[] args) {
		new 边界布局();
	}

}
