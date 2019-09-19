package Jduibuju;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Jueduibuju extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame jframe;
	@SuppressWarnings("unused")
	private JButton jbutton;
	@SuppressWarnings("unused")
	private JLabel jlabel;
	private JDialog jdialog;
	
	/*public void Jueduibuju1() {
		jdialog=new JDialog();
		jdialog.setTitle("窗体");
		jdialog.setBounds(40, 40, 300, 200);
		jdialog.setVisible(true);
		jdialog.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
	}*/
	
	public  void setjdialog() {
		getJjdialog(jdialog);
	}
	public static void getJjdialog(JDialog jdialog) {
	
		jdialog=new JDialog();
		jdialog.setTitle("窗体");
		jdialog.setBounds(40, 40, 300, 
				
				200);
		Container b=jdialog.getContentPane();//获取容器	
		jdialog.setLayout(null);
		JButton n=new JButton("点击进入1");
		JLabel dt=new JLabel("123321");		
		jdialog.setVisible(true);	
		b.add(dt);
		b.add(n);
		dt.setLocation(160,20);//位置
		dt.setSize(100, 30);//长宽
		n.setSize(100, 30);
		n.setLocation(50, 20);
		jdialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*n.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("123");
				
			}
		});*/
	}
	
	public  void setjframe() {
		getJframe(jframe);
	}
	public static void getJframe(JFrame jframe) {
		jframe=new JFrame();
		jframe.setTitle("绝对布局");
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.setBounds(500, 500, 400, 300);
		Container c=jframe.getContentPane();
		c.setLayout(null);
		JButton n=new JButton("点击进入");
		c.add(n);
		n.setSize(100, 30);
		n.setLocation(10, 20);
		n.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Jueduibuju s=new Jueduibuju();
					s.setjdialog();			
			}
		});
		
		
	}
public static void main(String[] args) {
	Jueduibuju n=new Jueduibuju();
	n.setjframe();
}
}
