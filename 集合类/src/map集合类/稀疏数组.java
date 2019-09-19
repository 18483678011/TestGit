package map集合类;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import 集合类.排序;

public class 稀疏数组 {
	private static int size = 0;// 有效数据个数
	private static final int ROW = 10;// 行
	private static final int LIST = 10;// 列
	private static final int TEST = 3;// 列
	private static int in[][];// 原始数据库
	private static int sparseArray[][];// 稀疏数组

	public static int[][] getin() {// 创建原始二维数组数据
		in = new int[ROW][LIST];
		in[0][5] = 2;
		in[1][2] = 1;
		in[8][7] = 2;
		in[2][3] = 2;
		in[3][4] = 1;
		in[3][5] = 1;
		in[5][4] = 2;
		in[4][4] = 1;
		in[7][4] = 1;
		in[9][7] = 2;
		return in;
	}

	public static void Tostring(int[][] x) {// 输出打印统一格式

		for (int i = 0; i < x.length; i++) {
			System.out.print((i + 1) + "." + "[");
			for (int j = 0; j < x[i].length; j++) {
				System.out.print(x[i][j] + " ");
			}
			System.out.print("]");
			System.out.println();
		}
	}

	public static void name() {//
		getin();// 获取二维数组
		for (int i = 0; i < in.length; i++) {// 遍历二维数组
			for (int j = 0; j < in[i].length; j++) {
				if (in[i][j] != 0) {
					size++;
				}
			}
		}
		Tostring(in);
		System.out.println(" 数组有效数据个数：" + size);
		Tostring(稀疏数组.getSparseArray());
		Tostring(setins());
	}

	private static int[][] getSparseArray() {// 创建稀疏数组
		sparseArray = new int[size + 1][TEST];
		sparseArray[0][0] = ROW;
		sparseArray[0][1] = LIST;
		sparseArray[0][2] = size;
		int das = 0;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < LIST; j++) {
				if (in[i][j] != 0) {
					das++;
					sparseArray[das][0] = i;
					sparseArray[das][1] = j;
					sparseArray[das][2] = in[i][j];
				}

			}
		}

		return sparseArray;
	}

	public static int[][] setins() {// 稀疏数组还原二维数组
		int[][] ints = new int[sparseArray[0][0]][sparseArray[0][1]];
		for (int i = 0; i < size; i++) {
			ints[sparseArray[i + 1][0]][sparseArray[i + 1][1]] = sparseArray[i + 1][2];
		}
		return ints;
	}

	public static void HashMap() {//hashmap 遍历
		HashMap<Integer, 排序> map = new HashMap<Integer, 排序>();
		排序 set1 = new 排序(1, 12);
		排序 set2 = new 排序(3, 12);
		排序 set3 = new 排序(9, 18);
		排序 set4 = new 排序(8, 12);
		排序 set5 = new 排序(7, 19);
		排序 set6 = new 排序(5, 45);
		map.put(1, set1);
		map.put(2, set2);
		map.put(3, set3);
		map.put(4, set4);
		map.put(5, set5);
		map.put(6, set6);
		java.util.Set<Integer> mdSet = map.keySet();// 遍历方法1
		Iterator<Integer> iterator = mdSet.iterator();
		while (iterator.hasNext()) {
			Object in = iterator.next();
			Object innObject = map.get(in);
			System.out.println(in + "-->" + innObject);
		}
		System.out.println();
		java.util.Set<Entry<Integer, 排序>> entrySet = map.entrySet();// 遍历方法2
		Iterator<Entry<Integer, 排序>> iterator2 = entrySet.iterator();
		while (iterator2.hasNext()) {
			Map.Entry<java.lang.Integer, 集合类.排序> entry = (Map.Entry<java.lang.Integer, 集合类.排序>) iterator2.next();
			System.out.println(entry.getKey() + "--->" + entry.getValue());

		}
	}

	public static void main(String[] args) {
		name();
		HashMap();

	}
}
