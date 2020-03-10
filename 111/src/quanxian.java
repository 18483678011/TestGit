import java.text.*;
import java.util.Scanner;

public class quanxian {
	public static void SimgleFormat(String pattern, double value) {// 数字的显示格式
		DecimalFormat myFormat = new DecimalFormat(pattern);
		String output = myFormat.format(value);// 将数据进行格式化
		System.out.println(pattern + " " + value + " " + output);
	}

	public static void SimgleFormat1(String pattern, double value) {// 数字的显示格式
		DecimalFormat myFormat = new DecimalFormat(pattern);
		String output = myFormat.format(value);// 将数据进行格式化
		System.out.println(pattern + " " + value + " " + output);
	}

	public static void main(String[] args) {
		double si = 232.226;
		SimgleFormat("#,###.##", si);
		double s = Math.tan(Math.PI / 3);
		SimgleFormat1("#.00", s);
		DecimalFormat df = new DecimalFormat("#.00");// 用保留2位小数显示
		String stw = df.format(s);
		System.out.println(s + " " + "保留2位小数显示：" + stw);

		for (int d = 0; d < 10; d++) {
			int sy = (int) (((Math.random() - 0.5) * 2) * 10);//随机数生成  Math.random()产生的为0到1之间的随机数  此时为-10~10
			System.out.print(sy + " ");}
		for (int i = 0; i < 10; i++) {
			char m=(char)('a'+Math.random()*('z'-'a'+1));//此时是a~z;
			System.out.print(m+" ");}
		System.out.println();
			Scanner sc=new Scanner(System.in);
			double dou=sc.nextDouble();
			int sas=sc.nextInt();
			System.out.print("输出结果："+sas);
			System.out.println();
			System.out.print("输出结果："+dou);
			sc.close();
		
	}
}
