package ���ģʽ;

public class ����ģʽ1 {
	public static void main(String[] args) {

		����ģʽ ddd = ����ģʽ.get����ģʽ(10);
		����ģʽ dd1 = ����ģʽ.get����ģʽ(13);
		ddd.jiaage();
		dd1.jiaage();
		dd1.jiaage1();
	}
}

class ����ģʽ {
	private int age;
	private static ����ģʽ danli = null;

	private ����ģʽ(int age) {
		this.age = age;
	}

	public static ����ģʽ get����ģʽ(int age) {
		if (danli == null) {
			synchronized (����ģʽ1.class) {
				if (danli == null) {
					danli = new ����ģʽ(age);
				}
			}
		}
		return danli;
	}

	public void jiaage() {
		System.out.println(age);
	}

	public void jiaage1() {
		age++;
		System.out.println(age);
	}
}