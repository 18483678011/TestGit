package 窗体;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class 插入图片 extends JFrame {

	public 插入图片() {
		JFrame jf = new JFrame();
		jf.setBounds(750, 350, 400, 300);
		jf.setVisible(true);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(new FlowLayout());
		Container co = jf.getContentPane();
		
		//JTextArea v=new JTextArea(20,50);
		//co.add(v);
		//JScrollPane D=new JScrollPane(v);
		//co.add(co);
		JButton jb = new JButton();

		JLabel s = new JLabel();
		Icon icon = new ImageIcon("src/java.png");// 获取图片
		s.setIcon(icon);// 把图片放入s标签中。
		co.add(s);

		jb.setText("sssssss");
		co.add(jb);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dome de = new dome(jf);
				de.setVisible(true);
			}
		});
		jf.setVisible(true);
	}

	public static void main(String[] args) {
		new 插入图片();
	}
}
