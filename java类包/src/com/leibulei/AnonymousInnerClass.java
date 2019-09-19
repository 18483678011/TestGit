package com.leibulei;

public class AnonymousInnerClass {

	public cotintfas tus(int age) {//匿名内部类1
		return new cotintfas() {
			private int age;
			public void name() {
				System.out.println(age + "岁。");
			}
		};
	}

	public static void main(String[] args) {

		AnonymousInnerClass d = new AnonymousInnerClass();
		cotintfas f = new cotintfas() {// 匿名内部类2       方法1调用name。
			public int age = 10;

			public void name() {
				System.out.println(age + "岁。");
			}
		};

		f.name();

		new cotintfas() {//匿名内部类3    方法2调用name
			public int age = 10;

			public void name() {
				System.out.println(age + "岁。");
			}
		}.name();
	};

}

interface cotintfas {// 接口

	void name();
}