
public class Doctor extends People {

	Doctor(String name, int age) {
		super(name, age);
	}

	private void sutr() {
		System.out.println("����һ��ҽ����");
	}

	public void out() {
		System.out.println("�ҵ����ֽУ�" + name() + '\n' + "�ҽ���" + age() + "�ꡣ");
		sutr();
	}
}
