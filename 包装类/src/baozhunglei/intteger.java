package baozhunglei;

public class intteger {



	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Integer iny1 = new Integer(9);
		System.out.println(Integer.toString(iny1, 2) + " " + Integer.MAX_VALUE);// 2进制表示
		Character str = new Character('S');
		System.out.println(Character.toLowerCase(str));// 大写转换为小写；
		System.out.println(Character.isLowerCase(str));// 判断是不是小写
		System.out.println(Character.isLetter(str));// 判断是不是字母
		Integer int2 = new Integer(10);
		int d = int2;
		String s = Integer.toBinaryString(int2);
		System.out.println(s + "   " + d);
		Character s1 = new Character('d');
		Character s3 = Character.toUpperCase(s1);
		Character s2 = new Character('D');
		char s4 = Character.toUpperCase(s2);
		System.out.println(s2.equals(s3));//判断两个数是否相等；
		System.out.println(s3.equals(s4));//判断两个数是否相等；

	}

}
