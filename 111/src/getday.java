import java.util.Arrays;

public class getday {
	String name;

	public void mat(String name) {
		System.out.println(name);
	}

	public static void huanxiang(int arr[]) {// ���鵹�ú���

		System.out.println("ԭʼ���ݣ�");
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
		System.out.println("��ת�����ݣ�");
		for (int s : arr)
			System.out.print(s + "\t");
		System.out.println();
	}

	public static void jiaohuan() {// �����к���

		int a[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("ԭʼ�����");
		int v = a.length;
		for (int t = 0; t < v; t++) {
			for (int c = 0; c < a[t].length; c++)
				System.out.print(a[t][c] + "\0");
			System.out.println();
		}
		System.out.println("������������");
		for (int t = 0; t < v; t++) {
			for (int c = 0; c < a[t].length; c++)
				System.out.print(a[c][t] + "\0");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int day[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Arrays.fill(day, 2, 3, 88);// �滻day�еĵڶ�������Ԫ��Ϊ88
		for (int i : day)// ���day�и�Ԫ��
			System.out.print(i + "\t");
		System.out.println();// ����

		int a[] = new int[10];
		System.out.println("a������b�����Ԫ�غͣ�" + (day.length + a.length));// ��������day a �ĳ��Ⱥ�

		int b[] = new int[] { 4, 81, 99, 6, 46, 165, 65, 87, 21, 35 };
		for (int s : b)
			System.out.print(s + "\t");
		System.out.println();

		Arrays.sort(b);// ��b����

		for (int s : b)// ���b
			System.out.print(s + "\t");
		System.out.println();

		int f = Arrays.binarySearch(b, 87);// ����b�����е�6Ԫ��λ��
		System.out.println("6��Ԫ�ص�λ�ã�" + (f + 1));

		getday.huanxiang(b);
		getday.jiaohuan();
		getday ds = new getday();
		ds.mat("jianjia");
	}
}
