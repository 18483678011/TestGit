package 接口;

import com.Jeikou.Comparable1;
import com.Jeikou.Compator1;

public class Arrayutil {

	public static void sotr(Object[] arr) {// 用来排序年纪。
		Object temp;
		int x;
		for (x = 0; x < arr.length - 1; x++) {
			for (int y = 0; y < arr.length - 1 - x; y++) {
				Comparable1 r1 = (Comparable1) arr[y];
				Comparable1 r2 = (Comparable1) arr[y + 1];
				if (r1.compareTo(r2) > 0) // 整数
				{
					temp = arr[y];
					arr[y] = arr[y + 1];
					arr[y + 1] = temp;
				}
			}
		}
	}

	public static void sotr1(Object[] arr) {// 用来排序名字。
		Object temp;
		int x;
		for (x = 0; x < arr.length - 1; x++) {
			for (int y = 0; y < arr.length - 1 - x; y++) {
				Comparable1 r1 = (Comparable1) arr[y];
				Comparable1 r2 = (Comparable1) arr[y + 1];
				if (r1.name(r2) > 0) // 整数
				{
					temp = arr[y];
					arr[y] = arr[y + 1];
					arr[y + 1] = temp;
				}
			}
		}
	}

	public static void sotr(int[] arr) { // 用来排序整形数组。
		int temp;
		int x;
		for (x = 0; x < arr.length - 1; x++) {
			for (int y = 0; y < arr.length - 1 - x; y++) {
				if (arr[y] > arr[y + 1]) // 文字
				{
					temp = arr[y];
					arr[y] = arr[y + 1];
					arr[y + 1] = temp;
				}
			}
		}
	}

	public static void sotr2(Object[] arr, Compator1 cone) {// 用外部比较器比较名字
		Object temp;
		int x;
		for (x = 0; x < arr.length - 1; x++) {
			for (int y = 0; y < arr.length - 1 - x; y++) {
				if (cone.Compart(arr[y], arr[y + 1]) > 0) {
					temp = arr[y];
					arr[y] = arr[y + 1];
					arr[y + 1] = temp;
				}
			}
		}

	}

}
