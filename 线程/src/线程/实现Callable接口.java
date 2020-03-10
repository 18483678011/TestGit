package �߳�;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class newthread implements Callable<Integer> {

	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % 2 != 0) {
				System.out.print(i + "\t");
				sum += i;
			} else {
				continue;
			}
		}
		return sum;
	}
}

public class ʵ��Callable�ӿ� {

	public static void main(String[] args) {
		// ����Callable�ӿ�ʵ����Ķ���
		newthread newthread = new newthread();
		// ����Callable�ӿ���Ķ�����Ϊ���ݵ�FutureTask�������У�����FutureTask�Ķ���
		FutureTask<Integer> futureTask = new FutureTask<Integer>(newthread);
		// ��FutureTask�Ķ�����Ϊ�������ݵ�Thread��Ĺ������У�����Thread���󣬵���start()���������̡߳�
		Thread thread = new Thread(futureTask);
		thread.start();
		try {
			// ��ȡCallable��call���������ķ���ֵ������get()������
			Integer object = futureTask.get();
			System.out.println();
			System.out.println(object);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
