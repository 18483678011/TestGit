package 数据结构;

import java.util.Scanner;



public class 队列 {
	private int maxsize;
	private static int tou;
	private int wei;
	private int[] shuzu;

	public 队列(int max) {
		maxsize = max;
		shuzu = new int[maxsize];
	}

	public boolean isFull() {// 是否最大
		return (wei + 1) % maxsize == tou;

	}

	public boolean isEmpty() {// 是否为空
		return tou == wei;
	}

	public void addshuzu(int n) {// 添加数据
		if (isFull()) {
			System.out.println("数据已满,拒绝添加。");
			return;
		}
		shuzu[wei] = n;
		wei = (wei + 1) % maxsize;

	}

	public int setshuzu() {// 读取数据
		if (isEmpty()) {
			System.out.println("数据为空,拒绝访问。");
			throw new RuntimeException("队列为空。");
		}
		int s = shuzu[tou];
		tou = (tou + 1) % maxsize;
		return s;
	}

	public int youxiaogeshu() {// 有效数据个数

		return (wei - tou + maxsize) % maxsize;

	}

	public int headshuzu() {
		if (isEmpty()) {
			System.out.println("数据为空,拒绝访问。");
			throw new RuntimeException("队列为空。");
		}
		return shuzu[tou];
	}

	public void name() {// 显示数据
		if (isEmpty()) {
			System.out.println("数据为空,拒绝访问。");
			throw new RuntimeException("队列为空。");
		}
		for (int i = tou; i < youxiaogeshu()+tou; i++) {
			System.out.printf("shuzu[%d]=%d\n", i % maxsize, shuzu[i % maxsize]);
		}
	}

	public static void main(String[] args) {
		队列 s1 = new 队列(5);
		boolean tur = true;
		Scanner suScanner = new Scanner(System.in);
		char chars = ' ';
		while (tur) {
			System.out.println("1添加,2读取,3显示当前数据,4整体显示,5退出");
			chars = suScanner.next().charAt(0);
			switch (chars) {			
			case '1':
				System.out.println("输入数据");
				int value = suScanner.nextInt();
				s1.addshuzu(value);
				s1.name();
				break;
			case '2':
				s1.setshuzu();
				break;
			case '3':
				s1.name();
				break;
			case '4':
				s1.headshuzu();
			case '5':
				tur = false;
				suScanner.close();
				break;			
			}
			
		}
	}


}
