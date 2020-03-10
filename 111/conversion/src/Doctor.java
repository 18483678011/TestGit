
public class Doctor extends People {

	Doctor(String name, int age) {
		super(name, age);
	}

	private void sutr() {
		System.out.println("我是一个医生！");
	}

	public void out() {
		System.out.println("我的名字叫：" + name() + '\n' + "我今年" + age() + "岁。");
		sutr();
	}
}
