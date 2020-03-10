package �ļ����洦��;

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

public class ͼ�λ����洦���ļ� extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea jTextArea = null;
	private String dString = "C:\\Users\\Administrator\\Desktop\\java�ļ���ȡ.txt";
	private JPanel jPanel = null;
	private JPanel jPane2 = null;
	private JScrollPane pane = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;

	public static void main(String[] args) {
		//new ͼ�λ����洦���ļ�();
	}

	public ͼ�λ����洦���ļ�() {
		setTitle("�ļ��������");
		setBounds(500, 400, 500, 300);
		Container container = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.add(getjPanel());
		setVisible(true);
	}

	public JPanel getJPanel() {// ��ȡ����İ�ť���
		if (jPane2 == null) {
			jPane2 = new JPanel();
			jPane2.setLayout(new FlowLayout(1, 40, 10));
			jPane2.setBackground(Color.GREEN);
			jPane2.add(getjButton1());
			jPane2.add(getButton2());
		}
		return jPane2;
	}

	public JPanel getjPanel() {// ��ȡ������
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
			jTextArea.setFont(new Font("����", Font.PLAIN, 20));
			jTextArea.setForeground(Color.BLUE);
		}
		return jTextArea;
	}

	public JScrollPane getJScrollPane() {// ��ȡ���������
		if (pane == null) {
			pane = new JScrollPane(getJTextArea());// ���ı�����ӵ��������
		}
		return pane;
	}

	public JButton getButton2() {// д���ļ�
		if (jButton2 == null) {
			jButton2 = new JButton("д���ļ�");
			jButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					File file = new File(dString);
					FileWriter writer = null;
					try {
						writer = new FileWriter(file);
						String string = new String(getJTextArea().getText());// ��ȡ�����ϵ����ݵ�����
						writer.write(string);// �������е�������ӵ��ļ���
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
			jButton1 = new JButton("��ȡ�ļ�");
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
						getJTextArea().append("\n" + "�ļ����ԣ�" + dString + "\n" + "\n");
						int s;
						while ((s = reader.read(c)) != -1) {
							String string = new String(c, 0, s);
							getJTextArea().append(string);// �������ĵ���������������
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
