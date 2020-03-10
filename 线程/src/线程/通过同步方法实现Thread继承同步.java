package 线程;

public class 通过同步方法实现Thread继承同步 {

	public static void main(String[] args) {
		set set1 = new set();
		set set2 = new set();
		set set3 = new set();
		set1.start();
		set2.start();
		set3.start();
	}
}

class set extends Thread {
	private static int shor = 100;
	private static boolean bool;

	public void run() {
		bool = true;
		while (bool) {
			show();
			if (!bool) {
				break;
			}
		}
	}

	private static synchronized void show() {// 这种要用静态方法
		if (shor > 0) {
			System.out.println(Thread.currentThread().getName() + ": " + shor);
			try {
				Thread.currentThread();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			shor--;
		} else {
			bool = false;
		}

	}

}