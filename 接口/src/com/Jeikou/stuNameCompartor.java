package com.Jeikou;

import 接口.jast;

public class stuNameCompartor implements Compator1 {

	@Override
	public int Compart(Object obj1, Object obj2) {
		jast stu1 = (jast) obj1;
		jast stu2 = (jast) obj2;
		return stu1.getName().compareTo(stu2.getName());// 这个compareTo是string自带的
	}

}
