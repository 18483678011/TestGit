package �߳�;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

	public static void main(String[] args) {
		mthread mthread = new mthread();
		Thread thread = new Thread(mthread);
		Thread thread1 = new Thread(mthread);
		Thread thread2 = new Thread(mthread);
		thread.start();
		thread2.start();
		thread1.start();
		/*
		 * new Thread() {//�����߳� public void run() { for (int i = 0; i < 100; i++) { if
		 * (i % 2 != 0) { System.out.println(getName()+":"+i); } } } }.start();
		 */

	}
}

class mthread implements Runnable {// ����һ�ִ����̵߳ķ���
	private int tistse = 100;
	Object oj = new Object();
	private ReentrantLock Reen=new ReentrantLock(true);
	//��ReentrantLockͬ������顣��true�Ļ���ƽͬ�����������У��Ŷӣ�
	public void run() {

		while (true) {
			//synchronized (this) {   //��thisҲ�����߳�ͬ��
			//synchronized (oj) {//ͬ���߳���
				
				try {
					Reen.lock();//���������
					if (tistse > 0) {
						System.out.println(Thread.currentThread().getName() + ":" + tistse);
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						tistse--;
					} else {
						break;
					} 
				} finally {
					Reen.unlock();//����ͬ�������
				}
			}
		//}
	}
}