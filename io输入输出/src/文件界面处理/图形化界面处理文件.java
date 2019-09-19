package 文件界面处理;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class 图形化界面处理文件 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea jTextArea = null;
	private String dString = "C:\\Users\\Administrator\\Desktop\\java文件读取.txt";
	private JPanel jPanel = null;
	private JPanel jPane2 = null;
	private JScrollPane pane = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;

	public static void main(String[] args) {
		//new 图形化界面处理文件();
	}

	public 图形化界面处理文件() {
		setTitle("文件输入输出");
		setBounds(500, 400, 500, 300);
		Container container = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.add(getjPanel());
		setVisible(true);
	}

	public JPanel getJPanel() {// 获取下面的按钮面板
		if (jPane2 == null) {
			jPane2 = new JPanel();
			jPane2.setLayout(new FlowLayout(1, 40, 10));
			jPane2.setBackground(Color.GREEN);
			jPane2.add(getjButton1());
			jPane2.add(getButton2());
		}
		return jPane2;
	}

	public JPanel getjPanel() {// 获取外容器
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new BorderLayout());
			jPanel.add(getJScrollPane(), BorderLayout.CENTER);
			jPanel.add(getJPanel(), BorderLayout.SOUTH);
		}
		return jPanel;
	}

	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setFont(new Font("楷体", Font.PLAIN, 20));
			jTextArea.setForeground(Color.BLUE);
		}
		return jTextArea;
	}

	public JScrollPane getJScrollPane() {// 获取滚动条面板
		if (pane == null) {
			pane = new JScrollPane(getJTextArea());// 将文本域添加到滚动面板
		}
		return pane;
	}

	public JButton getButton2() {// 写入文件
		if (jButton2 == null) {
			jButton2 = new JButton("写入文件");
			jButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					File file = new File(dString);
					FileWriter writer = null;
					try {
						writer = new FileWriter(file);
						String string = new String(getJTextArea().getText());// 获取界面上的内容到数组
						writer.write(string);// 将数组中的内容添加到文件中
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						try {
							writer.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return jButton2;
	}

	public JButton getjButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton("读取文件");
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getJTextArea().getText() != null) {
						getJTextArea().setText("");
					}
					File file = new File(dString);
					FileReader reader = null;
					try {
						reader = new FileReader(file);
						char[] c = new char[10];
						String dString = file.getAbsolutePath();
						getJTextArea().append("\n" + "文件来自：" + dString + "\n" + "\n");
						int s;
						while ((s = reader.read(c)) != -1) {
							String string = new String(c, 0, s);
							getJTextArea().append(string);// 可以在文档后面继续添加内容
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						if (reader != null) {
							try {
								reader.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			});
		}
		return jButton1;
	}
}
