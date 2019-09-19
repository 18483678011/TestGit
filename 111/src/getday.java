import java.util.Arrays;

public class getday {
	String name;

	public void mat(String name) {
		System.out.println(name);
	}

	public static void huanxiang(int arr[]) {// 数组倒置函数

		System.out.println("原始数据：");
		for (int s : arr)
			System.out.print(s + "\t");
		System.out.println();
		int temp;
		int len = arr.length;
		for (int i = 0; i < len / 2; i++) {
			temp = arr[i];
			arr[i] = arr[len - 1 - i];
			arr[len - 1 - i] = temp;
		}
		System.out.println("翻转后数据：");
		for (int s : arr)
			System.out.print(s + "\t");
		System.out.println();
	}

	public static void jiaohuan() {// 交换行和列

		int a[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("原始情况：");
		int v = a.length;
		for (int t = 0; t < v; t++) {
			for (int c = 0; c < a[t].length; c++)
				System.out.print(a[t][c] + "\0");
			System.out.println();
		}
		System.out.println("互调后的情况：");
		for (int t = 0; t < v; t++) {
			for (int c = 0; c < a[t].length; c++)
				System.out.print(a[c][t] + "\0");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int day[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Arrays.fill(day, 2, 3, 88);// 替换day中的第二，三个元素为88
		for (int i : day)// 输出day中各元素
			System.out.print(i + "\t");
		System.out.println();// 换行

		int a[] = new int[10];
		System.out.println("a数组与b数组的元素和：" + (day.length + a.length));// 两个数组day a 的长度和

		int b[] = new int[] { 4, 81, 99, 6, 46, 165, 65, 87, 21, 35 };
		for (int s : b)
			System.out.print(s + "\t");
		System.out.println();

		Arrays.sort(b);// 对b排序

		for (int s : b)// 输出b
			System.out.print(s + "\t");
		System.out.println();

		int f = Arrays.binarySearch(b, 87);// 查找b数组中的6元素位置
		System.out.println("6号元素的位置：" + (f + 1));

		getday.huanxiang(b);
		getday.jiaohuan();
		getday ds = new getday();
		ds.mat("jianjia");
	}
}
