
public class hall {

	public static void main(String[] args) {

		// TODO 自动生成的方法存根
String string=new String("66");
Integer integer=Integer.parseInt(string);
System.out.println(6+integer);
		getday ds = new getday();
		ds.mat("jinajia");
		int arr[][] = new int[3][3]; // 确定数字“1”的位置
		int a = 2;// 第3行的下标
		int b = 3 / 2;// 第2列的下标
		for (int i = 1; i <= 9; i++) {// 给数组赋值
			arr[a++][b++] = i;// 避免数组下标越界
			if (i % 3 == 0) {// 如果i是3的倍数
				a = a - 2;
				b = b - 1;
			} else {// 如果i不是3的倍数
				a = a % 3;
				b = b % 3;
			}
		}
		System.out.println("九宫格："); // 遍历数组
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");// 输出数组中的数据 }
				System.out.println();// 换行
			}

		}
	}
}