import java.util.concurrent.locks.ReentrantLock;

public class 用线程堵塞交替打印100 {

	public static void main(String[] args) {
		test te1 = new test();
		// test te2=new test();
		Thread thread = new Thread(te1);
		Thread thread2 = new Thread(te1);
		thread2.setName("线程二");
		thread2.start();
		thread.setName("线程一");
		thread.start();//两个线程同时访问一个对象。
		
	}
}

class test implements Runnable {

	private static int boup = 100;
	@SuppressWarnings("unused")
	private ReentrantLock Lock = new ReentrantLock();

	public void run() {
		while (true) {
			synchronized (this) {
			
				notify();//释放一个线程，notifyAll()释放多个线程;
				if (boup >= 0) {
					System.out.println(Thread.currentThread().getName() + ":" + boup);
					boup--;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					try {
						wait();//锁住当前线程，同时释放同步代码块，即允许其他线程进入同步代码块。
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