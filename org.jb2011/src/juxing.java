
public class juxing {
	private float chang;
	private float kuan;

	juxing(float chang, float kuan) {
		this.chang = chang;
		this.kuan = kuan;  
	}

	public void mianji() {
		System.out.println("矩形面积为：" + (this.chang * this.kuan));
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		juxing s1 = new juxing(3.3f, 6.0f);
		s1.mianji();
		Integer int1 = new Integer(20);// 创建一个int变量
		String dome = Integer.toString(int1, 2);// 12用2进制显示
		System.out.println(dome);
		Boolean bool = new Boolean("true");
		System.out.println(bool);
		String is = new String("555");
		String is1 = is;
		String is2 = "222";
		Integer str=new Integer(20);
		int str2=20;
		System.out.println(str.equals(str2)+"是不是");
		System.out.println(is.equals(is1));
		System.out.println(is.equals(is2));
	}
}
