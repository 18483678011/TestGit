package com.Jeikou;

import �ӿ�.jast;

public class stuNameCompartor implements Compator1 {

	@Override
	public int Compart(Object obj1, Object obj2) {
		jast stu1 = (jast) obj1;
		jast stu2 = (jast) obj2;
		return stu1.getName().compareTo(stu2.getName());// ���compareTo��string�Դ���
	}

}
