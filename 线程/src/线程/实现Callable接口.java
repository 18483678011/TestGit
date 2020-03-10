package 线程;

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

public class 实现Callable接口 {

	public static void main(String[] args) {
		// 创建Callable接口实现类的对象。
		newthread newthread = new newthread();
		// 将此Callable接口类的对象作为传递到FutureTask构造器中，创建FutureTask的对象。
		FutureTask<Integer> futureTask = new FutureTask<Integer>(newthread);
		// 将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，调用start()方法启动线程。
		Thread thread = new Thread(futureTask);
		thread.start();
		try {
			// 获取Callable中call（）方法的返回值。调用get()方法。
			Integer object = futureTask.get();
			System.out.println();
			System.out.println(object);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
