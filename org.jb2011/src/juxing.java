
public class juxing {
	private float chang;
	private float kuan;

	juxing(float chang, float kuan) {
		this.chang = chang;
		this.kuan = kuan;  
	}

	public void mianji() {
		System.out.println("�������Ϊ��" + (this.chang * this.kuan));
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		juxing s1 = new juxing(3.3f, 6.0f);
		s1.mianji();
		Integer int1 = new Integer(20);// ����һ��int����
		String dome = Integer.toString(int1, 2);// 12��2������ʾ
		System.out.println(dome);
		Boolean bool = new Boolean("true");
		System.out.println(bool);
		String is = new String("555");
		String is1 = is;
		String is2 = "222";
		Integer str=new Integer(20);
		int str2=20;
		System.out.println(str.equals(str2)+"�ǲ���");
		System.out.println(is.equals(is1));
		System.out.println(is.equals(is2));
	}
}
