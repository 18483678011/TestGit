package 线程;

public class 通过同步方法实现Runnable1同步 {

	public static void main(String[] args) {
		runnab runnab = new runnab();
		Thread tesThread0 = new Thread(runnab);
		Thread tesThread1 = new Thread(runnab);
		tesThread0.start();
		tesThread1.start();
	}
}

class runnab implements Runnable {
	private int shor = 100;
	private boolean bool;

	public void run() {
		bool = true;
		while (bool) {
			show();
			if (!bool) {
				break;
			}
		}
	}

	@SuppressWarnings("static-access")
	private synchronized void show() {
		if (shor > 0) {
			System.out.println(Thread.currentThread().getName() + ": " + shor);
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			shor--;
		} else {
			bool = false;
		}
	}

}