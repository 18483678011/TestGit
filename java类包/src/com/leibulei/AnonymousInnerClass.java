package com.leibulei;

public class AnonymousInnerClass {

	public cotintfas tus(int age) {//�����ڲ���1
		return new cotintfas() {
			private int age;
			public void name() {
				System.out.println(age + "�ꡣ");
			}
		};
	}

	public static void main(String[] args) {

		AnonymousInnerClass d = new AnonymousInnerClass();
		cotintfas f = new cotintfas() {// �����ڲ���2       ����1����name��
			public int age = 10;

			public void name() {
				System.out.println(age + "�ꡣ");
			}
		};

		f.name();

		new cotintfas() {//�����ڲ���3    ����2����name
			public int age = 10;

			public void name() {
				System.out.println(age + "�ꡣ");
			}
		}.name();
	};

}

interface cotintfas {// �ӿ�

	void name();
}