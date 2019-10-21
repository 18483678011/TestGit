package 数据结构;

public class 顺序二叉树 {
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
//前序遍历
	public void preOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("树为空,不能遍历");
		}
		System.out.print(arr[index] + "\t");
		if ((index * 2 + 1) < arr.length) {// 左
			preOrder((index * 2 + 1));
		}
		if ((index * 2 + 2) < arr.length) {// 右
			preOrder((index * 2 + 2));
		}
	}
}