
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
		System.out.println("�ҵ����ֽУ�" + name + '\n' + "�ҽ���" + age + "�ꡣ");
		sutr();
	}

	private void sutr() {
		System.out.println("����һ���ˣ�");
	}
}
