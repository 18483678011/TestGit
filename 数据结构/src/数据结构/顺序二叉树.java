package ���ݽṹ;

public class ˳������� {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 10, 5, 100, 7, 8, 9 };
		Arrtree arrtree = new Arrtree(arr);
		arrtree.preOrder();
	}
}

class Arrtree {
	private int[] arr;

	public Arrtree(int[] arr) {
		super();
		this.arr = arr;
	}

	public void preOrder() {
		this.preOrder(0);
	}
//ǰ�����
	public void preOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("��Ϊ��,���ܱ���");
		}
		System.out.print(arr[index] + "\t");
		if ((index * 2 + 1) < arr.length) {// ��
			preOrder((index * 2 + 1));
		}
		if ((index * 2 + 2) < arr.length) {// ��
			preOrder((index * 2 + 2));
		}
	}
}