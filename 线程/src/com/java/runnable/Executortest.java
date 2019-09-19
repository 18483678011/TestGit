package com.java.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Executortest {

	// public static int s = 100;

	/**
	 * newCachedThreadPool
	 * ����һ���ɻ����̳߳أ�����̳߳س��ȳ���������Ҫ���������տ����̣߳����޿ɻ��գ����½��̡߳��̳߳�Ϊ���޴󣬵�ִ�еڶ�������ʱ��һ�������Ѿ���ɣ��Ḵ��ִ�е�һ��������̣߳�������ÿ���½��̡߳�
	 * ������ʽ�� Executors.newCachedThreadPool()�� newFixedThreadPool
	 * ����һ�������̳߳أ��ɿ����߳���󲢷������������̻߳��ڶ����еȴ��������̳߳صĴ�С��ø���ϵͳ��Դ�������ã���Runtime.getRuntime().availableProcessors()��
	 * ������ʽ�� Executors.newFixedThreadPool()�� newScheduledThreadPool
	 * ����һ�������̳߳أ�֧�ֶ�ʱ������������ִ�С� ������ʽ�� Executors.newScheduledThreadPool ()��
	 * newSingleThreadExecutor ����һ�����̻߳����̳߳أ���ֻ����Ψһ�Ĺ����߳���ִ�����񣬱�֤����������ָ��˳��(FIFO,LIFO,
	 * ���ȼ�)ִ�С� ������ʽ�� Executors.newSingleThreadExecutor ()��
	 * 
	 */
	public static void main(String[] args) {
		// ExecutorService excu = Executors.newFixedThreadPool(5);//����һ�������̳߳�.
		// ExecutorService excu =Executors.newSingleThreadExecutor();//���̴߳����̳߳�
		// ExecutorService excu = Executors.newCachedThreadPool();// ����һ���ɻ����̳߳�
		ExecutorService excu = Executors.newScheduledThreadPool(10);
		ThreadPoolExecutor sExecutor = (ThreadPoolExecutor) excu;// ǿת���������߳���

		sExecutor.setCorePoolSize(2);// ���ú����߳�����
		sExecutor.setMaximumPoolSize(3);// ����߳���

		// sExecutor.setKeepAliveTime(100, null);

		for (int i = 0; i < 10; i++) {
			excu.execute(new liftoff() {// ��ʼ����
			});
		}
		System.out.println(excu.isShutdown());
		excu.execute(new liftoff() {// ��ִ�еڶ�������ʱ��һ�������Ѿ���ɣ��Ḵ��ִ�е�һ��������̣߳�������ÿ���½��̡߳�
		});
		excu.shutdown();// �ͷ�����
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
