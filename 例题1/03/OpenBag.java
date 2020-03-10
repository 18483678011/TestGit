package 03;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OpenBag extends JFrame { // 创建OpenBag类继承JFrame
	// 声明窗体中的成员组件
	private JPanel contentPane;
	private JLabel lblBag;

	/**
	 * 主方法
	 */
	public static void main(String[] args) {
		OpenBag frame = new OpenBag(); // 创建OpenBag对象
		frame.setVisible(true); // 使frame可视
	}

	/**
	 * 创建JFrame窗体
	 */
	private int x = 10; // 初始图标的横坐标
	private int y = 10; // 初始图标的纵坐标

	public OpenBag() { // OpenBag的构造方法
		setTitle("试试看，能拆开这个红包吗？"); // 设置窗体题目
		setResizable(false); // 不可改变窗体宽高
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭的方式
		setBounds(getWidth() / 2, getHeight() / 2, 705, 420); // 设置窗体的位置和宽高
		/**
		 * 创建JPanel面板contentPane置于JFrame窗体中，并设置面板的边距和布局（边界布局）
		 */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		/**
		 * 创建面板panel置于面板contentPane中的中间
		 */
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		/**
		 * 创建标签label置于面板panel中，设置里的图标与标签的宽高
		 */
		lblBag = new JLabel("");
		lblBag.setLocation(x, y); // 设置标签在面板中的位置
		lblBag.addMouseListener(new MouseAdapter() { // 图标的鼠标监听事件
			@Override
			public void mouseEntered(MouseEvent e) { // 鼠标移入时的事件
				if (x >= 10 && x <= 144 && y >= 10 && y <= 192) { // 横坐标大于等于10、小于等于144且纵坐标大于等于10、小于等于192时
					// 横坐标不断加134、纵坐标不断加182
					x += 134;
					y += 182;
					lblBag.setLocation(x, y); // 重新设置标签在面板中的位置
				}
				if (x > 144 || y > 192) { // 横坐标大于144或纵坐标大于192
					// 横坐标不断加134、纵坐标不断加182
					x += 134;
					y -= 182;
					lblBag.setLocation(x, y); // 重新设置标签在面板中的位置
				}
				if (x == 680 && y == -172) { // 横坐标等于680或纵坐标等于-172
					x = 10;
					y = 192;
					lblBag.setLocation(x, y); // 重新设置标签在面板中的位置
				}
				if (x == 546 && y == -172) { // 横坐标等于546或纵坐标等于-172
					x = 546;
					y = 192;
					lblBag.setLocation(x, y); // 重新设置标签在面板中的位置
				}
				if (x == 680 && y == 10) { // 横坐标等于680或纵坐标等于10
					x = 10;
					y = 10;
					lblBag.setLocation(x, y); // 重新设置标签在面板中的位置
				}
			}
		});
		lblBag.setHorizontalAlignment(SwingConstants.CENTER);
		lblBag.setIcon(new ImageIcon(OpenBag.class.getResource("1.png")));
		lblBag.setSize(134, 182);
		panel.add(lblBag);
	}
}
