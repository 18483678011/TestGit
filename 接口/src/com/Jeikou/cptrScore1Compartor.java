package com.Jeikou;

import ½Ó¿Ú.jast;

public class cptrScore1Compartor implements Compator1 {

	@Override
	public int Compart(Object obj1, Object obj2) {
		jast stu1 = (jast) obj1;
		jast stu2 = (jast) obj2;
		if (stu1.getScore1() - stu2.getScore1() > 0)
			return 1;
		else if (stu1.getScore1() - stu2.getScore1() < 0)
			return -1;
		else
			return 0;
	}
}
