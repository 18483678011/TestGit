
public class hall {

	public static void main(String[] args) {

		// TODO �Զ����ɵķ������
String string=new String("66");
Integer integer=Integer.parseInt(string);
System.out.println(6+integer);
		getday ds = new getday();
		ds.mat("jinajia");
		int arr[][] = new int[3][3]; // ȷ�����֡�1����λ��
		int a = 2;// ��3�е��±�
		int b = 3 / 2;// ��2�е��±�
		for (int i = 1; i <= 9; i++) {// �����鸳ֵ
			arr[a++][b++] = i;// ���������±�Խ��
			if (i % 3 == 0) {// ���i��3�ı���
				a = a - 2;
				b = b - 1;
			} else {// ���i����3�ı���
				a = a % 3;
				b = b % 3;
			}
		}
		System.out.println("�Ź���"); // ��������
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");// ��������е����� }
				System.out.println();// ����
			}

		}
	}
}