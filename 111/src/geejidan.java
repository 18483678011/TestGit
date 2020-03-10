
public class geejidan {
	int k;
	int b;
	static int some = 0;
static {
  name1();
  System.out.println("11123");
}
	
	public static void name1() {
		some += 2;

	}

	public void name2() {
		some -= 2;
	}

	public geejidan() {
		// TODO 自动生成的构造函数存根}() {
		this(1);
	}

	public geejidan(int k) {
		this.k = k;
		this.b = k + 3;
		System.out.println("lai:" + k + "个鸡蛋" + "\0" + b);
	}

	public static void main(String[] args) {
		geejidan t1 = new geejidan(5);
		System.out.println(t1.b);
		geejidan t2 = new geejidan();
		System.out.println(t2.k);
		geejidan t3 = new geejidan();
		geejidan t4 = new geejidan();
		geejidan.name1();
		name1();
		name1();
		System.out.println("此时some：" + geejidan.some);
		t4.name2();
		System.out.println("此时some：" + geejidan.some);
		System.out.println(t1.b);
	}
}