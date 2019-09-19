package 设计模式;

public class 单例模式1 {
	public static void main(String[] args) {

		单例模式 ddd = 单例模式.get单例模式(10);
		单例模式 dd1 = 单例模式.get单例模式(13);
		ddd.jiaage();
		dd1.jiaage();
		dd1.jiaage1();
	}
}

class 单例模式 {
	private int age;
	private static 单例模式 danli = null;

	private 单例模式(int age) {
		this.age = age;
	}

	public static 单例模式 get单例模式(int age) {
		if (danli == null) {
			synchronized (单例模式1.class) {
				if (danli == null) {
					danli = new 单例模式(age);
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