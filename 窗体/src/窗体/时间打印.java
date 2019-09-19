package 窗体;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class 时间打印 extends JFrame {
	private boolean sss = true;

	public void name(JLabel sJLabel) {

		while (sss) {
			SimpleDateFormat sitDateFormat = new SimpleDateFormat("北京时间：" + "yyyy/MM/dd  HH:mm:ss");// 日期格式
			sJLabel.setText(sitDateFormat.format(new Date()));
			try {
				Thread.sleep(1000);// 延时一秒
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	public 时间打印() {
		setTitle("时间");
		setBounds(500, 400, 400, 300);
		setLayout(new GridLayout(2, 1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		JLabel sJLabel = new JLabel();
		sJLabel.setForeground(Color.BLUE);
		sJLabel.setHorizontalAlignment(SwingConstants.CENTER);// 居中显示
		sJLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		container.add(sJLabel);
		setVisible(true);
		name(sJLabel);

	}

	public static void main(String[] args) {
		new 时间打印();
	}
}
