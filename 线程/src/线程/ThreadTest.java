package 线程;

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
		 * new Thread() {//匿名线程 public void run() { for (int i = 0; i < 100; i++) { if
		 * (i % 2 != 0) { System.out.println(getName()+":"+i); } } } }.start();
		 */

	}
}

class mthread implements Runnable {// 另外一种创建线程的方法
	private int tistse = 100;
	Object oj = new Object();
	private ReentrantLock Reen=new ReentrantLock(true);
	//用ReentrantLock同步代码块。用true的话公平同步先来先运行（排队）
	public void run() {

		while (true) {
			//synchronized (this) {   //用this也可以线程同步
			//synchronized (oj) {//同步线程锁
				
				try {
					Reen.lock();//锁定代码块
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
					Reen.unlock();//解锁同步代码块
				}
			}
		//}
	}
}