import java.util.concurrent.locks.ReentrantLock;

public class ���̶߳��������ӡ100 {

	public static void main(String[] args) {
		test te1 = new test();
		// test te2=new test();
		Thread thread = new Thread(te1);
		Thread thread2 = new Thread(te1);
		thread2.setName("�̶߳�");
		thread2.start();
		thread.setName("�߳�һ");
		thread.start();//�����߳�ͬʱ����һ������
		
	}
}

class test implements Runnable {

	private static int boup = 100;
	@SuppressWarnings("unused")
	private ReentrantLock Lock = new ReentrantLock();

	public void run() {
		while (true) {
			synchronized (this) {
			
				notify();//�ͷ�һ���̣߳�notifyAll()�ͷŶ���߳�;
				if (boup >= 0) {
					System.out.println(Thread.currentThread().getName() + ":" + boup);
					boup--;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					try {
						wait();//��ס��ǰ�̣߳�ͬʱ�ͷ�ͬ������飬�����������߳̽���ͬ������顣
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					break;
				}

			}
		}

	}
}