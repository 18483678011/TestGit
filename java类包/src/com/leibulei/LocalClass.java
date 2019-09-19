package com.leibulei;

interface contuits {// 接口

}

public class LocalClass {// 局部类部类

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
		x.name();//调用类下的函数生成类部类。
	}
}
