package com.leibulei;

interface contuits {// �ӿ�

}

public class LocalClass {// �ֲ��ಿ��

	public contuits name() {
		class outsur implements contuits {
			private String name;

			public outsur(String name) {
				System.out.println(name);
				this.name = name;
				System.out.println(this.name);
			}

		}
		return new outsur("zandsan");
	}

	public static void main(String[] args) {
		LocalClass x = new LocalClass();
		x.name();//�������µĺ��������ಿ�ࡣ
	}
}
