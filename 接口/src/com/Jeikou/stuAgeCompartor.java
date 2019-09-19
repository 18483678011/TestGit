package com.Jeikou;

import ½Ó¿Ú.jast;

public class stuAgeCompartor implements Compator1 {

	@Override
	public int Compart(Object obj1, Object obj2) {
		jast stu1 = (jast) obj1;
		jast stu2 = (jast) obj2;
		return stu1.getAge() - stu2.getAge();
	}

}
