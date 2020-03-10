package map������;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import ������.����;

public class ϡ������ {
	private static int size = 0;// ��Ч���ݸ���
	private static final int ROW = 10;// ��
	private static final int LIST = 10;// ��
	private static final int TEST = 3;// ��
	private static int in[][];// ԭʼ���ݿ�
	private static int sparseArray[][];// ϡ������

	public static int[][] getin() {// ����ԭʼ��ά��������
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

	public static void Tostring(int[][] x) {// �����ӡͳһ��ʽ

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
		getin();// ��ȡ��ά����
		for (int i = 0; i < in.length; i++) {// ������ά����
			for (int j = 0; j < in[i].length; j++) {
				if (in[i][j] != 0) {
					size++;
				}
			}
		}
		Tostring(in);
		System.out.println(" ������Ч���ݸ�����" + size);
		Tostring(ϡ������.getSparseArray());
		Tostring(setins());
	}

	private static int[][] getSparseArray() {// ����ϡ������
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

	public static int[][] setins() {// ϡ�����黹ԭ��ά����
		int[][] ints = new int[sparseArray[0][0]][sparseArray[0][1]];
		for (int i = 0; i < size; i++) {
			ints[sparseArray[i + 1][0]][sparseArray[i + 1][1]] = sparseArray[i + 1][2];
		}
		return ints;
	}

	public static void HashMap() {//hashmap ����
		HashMap<Integer, ����> map = new HashMap<Integer, ����>();
		���� set1 = new ����(1, 12);
		���� set2 = new ����(3, 12);
		���� set3 = new ����(9, 18);
		���� set4 = new ����(8, 12);
		���� set5 = new ����(7, 19);
		���� set6 = new ����(5, 45);
		map.put(1, set1);
		map.put(2, set2);
		map.put(3, set3);
		map.put(4, set4);
		map.put(5, set5);
		map.put(6, set6);
		java.util.Set<Integer> mdSet = map.keySet();// ��������1
		Iterator<Integer> iterator = mdSet.iterator();
		while (iterator.hasNext()) {
			Object in = iterator.next();
			Object innObject = map.get(in);
			System.out.println(in + "-->" + innObject);
		}
		System.out.println();
		java.util.Set<Entry<Integer, ����>> entrySet = map.entrySet();// ��������2
		Iterator<Entry<Integer, ����>> iterator2 = entrySet.iterator();
		while (iterator2.hasNext()) {
			Map.Entry<java.lang.Integer, ������.����> entry = (Map.Entry<java.lang.Integer, ������.����>) iterator2.next();
			System.out.println(entry.getKey() + "--->" + entry.getValue());

		}
	}

	public static void main(String[] args) {
		name();
		HashMap();

	}
}
