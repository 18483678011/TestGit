package com.java.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Executortest {

	// public static int s = 100;

	/**
	 * newCachedThreadPool
	 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
	 * 创建方式： Executors.newCachedThreadPool()； newFixedThreadPool
	 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。定长线程池的大小最好根据系统资源进行设置，如Runtime.getRuntime().availableProcessors()。
	 * 创建方式： Executors.newFixedThreadPool()； newScheduledThreadPool
	 * 创建一个定长线程池，支持定时及周期性任务执行。 创建方式： Executors.newScheduledThreadPool ()；
	 * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO,LIFO,
	 * 优先级)执行。 创建方式： Executors.newSingleThreadExecutor ()；
	 * 
	 */
	public static void main(String[] args) {
		// ExecutorService excu = Executors.newFixedThreadPool(5);//创建一个定长线程池.
		// ExecutorService excu =Executors.newSingleThreadExecutor();//单线程创建线程池
		// ExecutorService excu = Executors.newCachedThreadPool();// 创建一个可缓存线程池
		ExecutorService excu = Executors.newScheduledThreadPool(10);
		ThreadPoolExecutor sExecutor = (ThreadPoolExecutor) excu;// 强转可以设置线程了

		sExecutor.setCorePoolSize(2);// 设置核心线程数；
		sExecutor.setMaximumPoolSize(3);// 最大线程数

		// sExecutor.setKeepAliveTime(100, null);

		for (int i = 0; i < 10; i++) {
			excu.execute(new liftoff() {// 开始运行
			});
		}
		System.out.println(excu.isShutdown());
		excu.execute(new liftoff() {// 当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
		});
		excu.shutdown();// 释放运行
	}
}
class liftoff implements Runnable {
	private int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;

	public liftoff() {
	}

	public liftoff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + (id + 1) + "( " + (countDown > 0 ? countDown : "Liftoff!") + " ),";
	}

	public void run() {
		synchronized (Executortest.class) {
			while (true) {
				while (countDown-- > 0) {
					System.out.println(Thread.currentThread().getName() + ":" + status());
					Thread.yield();
				}
				if (countDown < 0) {
					break;
				}
			}
		}
	}
}
