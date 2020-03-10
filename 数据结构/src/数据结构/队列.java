package ���ݽṹ;

import java.util.Scanner;



public class ���� {
	private int maxsize;
	private static int tou;
	private int wei;
	private int[] shuzu;

	public ����(int max) {
		maxsize = max;
		shuzu = new int[maxsize];
	}

	public boolean isFull() {// �Ƿ����
		return (wei + 1) % maxsize == tou;

	}

	public boolean isEmpty() {// �Ƿ�Ϊ��
		return tou == wei;
	}

	public void addshuzu(int n) {// �������
		if (isFull()) {
			System.out.println("��������,�ܾ���ӡ�");
			return;
		}
		shuzu[wei] = n;
		wei = (wei + 1) % maxsize;

	}

	public int setshuzu() {// ��ȡ����
		if (isEmpty()) {
			System.out.println("����Ϊ��,�ܾ����ʡ�");
			throw new RuntimeException("����Ϊ�ա�");
		}
		int s = shuzu[tou];
		tou = (tou + 1) % maxsize;
		return s;
	}

	public int youxiaogeshu() {// ��Ч���ݸ���

		return (wei - tou + maxsize) % maxsize;

	}

	public int headshuzu() {
		if (isEmpty()) {
			System.out.println("����Ϊ��,�ܾ����ʡ�");
			throw new RuntimeException("����Ϊ�ա�");
		}
		return shuzu[tou];
	}

	public void name() {// ��ʾ����
		if (isEmpty()) {
			System.out.println("����Ϊ��,�ܾ����ʡ�");
			throw new RuntimeException("����Ϊ�ա�");
		}
		for (int i = tou; i < youxiaogeshu()+tou; i++) {
			System.out.printf("shuzu[%d]=%d\n", i % maxsize, shuzu[i % maxsize]);
		}
	}

	public static void main(String[] args) {
		���� s1 = new ����(5);
		boolean tur = true;
		Scanner suScanner = new Scanner(System.in);
		char chars = ' ';
		while (tur) {
			System.out.println("1���,2��ȡ,3��ʾ��ǰ����,4������ʾ,5�˳�");
			chars = suScanner.next().charAt(0);
			switch (chars) {			
			case '1':
				System.out.println("��������");
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
