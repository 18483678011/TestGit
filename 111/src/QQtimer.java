
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.util.Timer;

import java.util.TimerTask;

public class QQtimer {
	public static void main(String[] args) {
		Timer timer = new Timer();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		timer.schedule(new TimerTask() {

			public void run() {
				String sentence = "importjava,awt,datatransfer,Transferable,";// ����Ҫ���͵Ļ�
				Robot robot = null;
				try {
					robot = new Robot();
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // ����Robot����
				//robot.delay(300);// �ӳ����룬��Ҫ��Ϊ��Ԥ�����򿪴��ڵ�ʱ�䣬������importjava.awt.datatransfer.Transferable

				Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
				String[] authors = sentence.split(",");// �ַ�������,�ָ�
				for (int j = 0; j < 1; j++) {// ѭ������
					for (int i = 0; i < authors.length; i++) {
						String sentencet = authors[i];
						Transferable tText = new StringSelection(sentencet);
						clip.setContents(tText, null);
						// for (int j1 = 0; j1 <= 1; j1++) {
						// �������а�����ctrl+v�����ճ������
						robot.keyPress(KeyEvent.VK_CONTROL);
						robot.keyPress(KeyEvent.VK_V);
						robot.keyRelease(KeyEvent.VK_CONTROL);// �ͷ�ctrl��������ctrl���˸����ɾ���������Ĺ����԰������ڰ��º�һ��Ҫ�ͷţ���Ȼ������⡣crtl�����סû���ͷţ��ڰ�������ĸ�����ǣ��ó����Ļ���ctrl�Ŀ�ݼ���
						robot.delay(300);// �ӳ�һ���ٷ��ͣ���Ȼ��һ����ȫ������ȥ����Ϊ���ԵĴ����ٶȺܿ죬ÿ��ճ�����͵��ٶȼ�����һ˲�䣬���Ը��˵ĸо�����һ���Է�����ȫ�������ʱ������Լ��ģ��뼸�뷢��һ��������
						robot.keyPress(KeyEvent.VK_ENTER);// �س�
					}
					// }

				}
			}
		}, 10, 50);// 10000��ʾ�ӳ�ʮ��ִ�У�86400000��ʾ24*60*60���Ҳ����ÿ��ѭ��ִ��һ��
	}
}
