import java.text.*;
import java.util.Scanner;

public class quanxian {
	public static void SimgleFormat(String pattern, double value) {// ���ֵ���ʾ��ʽ
		DecimalFormat myFormat = new DecimalFormat(pattern);
		String output = myFormat.format(value);// �����ݽ��и�ʽ��
		System.out.println(pattern + " " + value + " " + output);
	}

	public static void SimgleFormat1(String pattern, double value) {// ���ֵ���ʾ��ʽ
		DecimalFormat myFormat = new DecimalFormat(pattern);
		String output = myFormat.format(value);// �����ݽ��и�ʽ��
		System.out.println(pattern + " " + value + " " + output);
	}

	public static void main(String[] args) {
		double si = 232.226;
		SimgleFormat("#,###.##", si);
		double s = Math.tan(Math.PI / 3);
		SimgleFormat1("#.00", s);
		DecimalFormat df = new DecimalFormat("#.00");// �ñ���2λС����ʾ
		String stw = df.format(s);
		System.out.println(s + " " + "����2λС����ʾ��" + stw);

		for (int d = 0; d < 10; d++) {
			int sy = (int) (((Math.random() - 0.5) * 2) * 10);//���������  Math.random()������Ϊ0��1֮��������  ��ʱΪ-10~10
			System.out.print(sy + " ");}
		for (int i = 0; i < 10; i++) {
			char m=(char)('a'+Math.random()*('z'-'a'+1));//��ʱ��a~z;
			System.out.print(m+" ");}
		System.out.println();
			Scanner sc=new Scanner(System.in);
			double dou=sc.nextDouble();
			int sas=sc.nextInt();
			System.out.print("��������"+sas);
			System.out.println();
			System.out.print("��������"+dou);
			sc.close();
		
	}
}
