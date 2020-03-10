
public class People {

	private String name;
	private int age;

	People(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String name() {
		return name;
	}

	public int age() {
		return age;
	}

	public void out() {
		System.out.println("我的名字叫：" + name + '\n' + "我今年" + age + "岁。");
		sutr();
	}

	private void sutr() {
		System.out.println("我是一个人！");
	}
}
