package 窗体;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class cBorderLayout extends JFrame {
	JPanel p = new JPanel();
	private JButton jbutton;
	
	public cBorderLayout() {

		setLayout(new BorderLayout(5, 5));
		JButton jbutton1=new JButton("South");
		setFont(new Font("Helvetica", Font.PLAIN, 14));
		jbutton=new JButton("North");
		getContentPane().add("North", jbutton);

		getContentPane().add("South",jbutton1);
		jbutton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				getColor();
			}
		});

		getContentPane().add("East", new JButton("East"));

		getContentPane().add("West", new JButton("West"));

//设置面板为流式布局居中显示，组件横、纵间距为5个像素

		p.setLayout(new FlowLayout(1, 10, 10));

//使用循环添加按钮，注意每次添加的按钮对象名称都是b

		// 但按钮每次均是用new新生成的，所有代表不同的按钮对象。

		for (int i = 1; i < 10; i++) {

//String.valueOf(i)，将数字转换为字符串

			JButton b = new JButton(String.valueOf(i));

			p.add(b); // 将按钮添加到面板中

		}
	
		
		getContentPane().add("Center", p); // 将面板添加到中间位置
		 // pack();
	}

	private void getColor() {   
		Color color=jbutton.getBackground();		
		Color newColor = JColorChooser.showDialog(this, "选择颜色", color);
		jbutton.setBackground(newColor);
	} 
	public static void main(String[] args) {
	
		cBorderLayout f = new cBorderLayout();
		f.setTitle("边界布局");
		f.pack(); // 让窗体自适应组建大小
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
	
	}
}
