import java.util.concurrent.locks.ReentrantLock;

public class LiftOff implements Runnable {
	private int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	private ReentrantLock lock = new ReentrantLock();

	public LiftOff() {
	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "( " + (countDown > 0 ? countDown : "Liftoff!") + " ),";

	}

	public static void main(String[] args) {
		LiftOff iLiftOff = new LiftOff();
		//LiftOff iLiftOf = new LiftOff();

		new Thread(iLiftOff).start();
		new Thread(iLiftOff).start();
	}

	public void run() {
		while (true) {
			try {
				lock.lock();
				while (countDown-- > 0) {
					System.out.println(Thread.currentThread().getName() + ":" + status());
				}
				if (countDown < 0) {
					break;
				}
			} finally {
				lock.unlock();
			}
		}
	}
}
