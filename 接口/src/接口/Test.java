package 接口;

import com.Jeikou.cptr;
import com.Jeikou.cptrScore1Compartor;
import com.Jeikou.stuAgeCompartor;
import com.Jeikou.stuNameCompartor;

public class Test {

	public static void main(String[] args) {
//————————————————————————————————————————————————————————————学生排序
		student[] Strarr = new student[5];
		Strarr[0] = new student("a张三", 12, 80);
		Strarr[1] = new student("c李四", 13, 60);
		Strarr[2] = new student("b王五", 14, 88);
		Strarr[3] = new student("f赵六", 17, 89);
		Strarr[4] = new student("g罗七", 11, 98);

		// 排序前
		System.out.println("排序前：");
		for (student b : Strarr) {
			System.out.println(b.toString());
		}
		// 排序
		Arrayutil.sotr(Strarr);// 年纪排序
		// 排序后输出
		System.out.println("年纪排序后：");
		for (student b : Strarr) {
			System.out.println(b.toString());
		}

		Arrayutil.sotr1(Strarr);// 名字排序

		System.out.println("名字排序后：");
		for (student b : Strarr) {
			System.out.println(b.toString());
		}
		// -------------------------------------------------cptr排序。
		cptr[] look = new cptr[3];
		look[0] = new cptr("123", 12, 5);
		look[1] = new cptr("234", 19, 6);
		look[2] = new cptr("345", 14, 7);
		System.out.println("排序前：");
		for (cptr b : look) {
			System.out.println(b.toString());
		}
		Arrayutil.sotr(look);
		System.out.println("排序后：");
		for (cptr b : look) {
			System.out.println(b.toString());
		}
		// ______________________________________________________________________________________全局静态抽象常量

		System.out.println(drawTest.PI);// 接口中的数据全部默认为public static abstract(抽象关键字)即：全局静态抽象常量。
		drawTest ts1 = new ren();// 接口不能new自己，抽象类也不能new自己。
		ts1.test();
		// ____________________________________________________int排序
		int[] str = { 2, 3, 5, 4, 98, 566, 6 };
		Arrayutil.sotr(str);
		System.out.println("int类型数组排序：");
		for (int s = 0; s < str.length; s++) {
			System.out.print(str[s] + " ");
		}
		System.out.println();
		ts1.fulei1();
		// ______________________________________________________________________________________jast的排序

		jast[] bst = new jast[5];
		bst[0] = new jast("s01", 10,80.3);
		bst[1] = new jast("d02", 19,60.3);
		bst[2] = new jast("e03", 13,99.0);
		bst[3] = new jast("a04", 8,100);
		bst[4] = new jast("f05", 14,78);
		System.out.println("排序前：");
		for (int s = 0; s < bst.length; s++) {
			System.out.println(bst[s].toString());
		}

		stuNameCompartor ns = new stuNameCompartor();// 按照姓名排序 jast类中的才可以
		Arrayutil.sotr2(bst, ns);
		System.out.println("名字排序后：");
		for (int s = 0; s < bst.length; s++) {
			System.out.println(bst[s].toString());
		}
		// _____________________________________________________
		stuAgeCompartor nb = new stuAgeCompartor();// 按照年纪排序jast类中的才可以
		Arrayutil.sotr2(bst, nb);//
		System.out.println("年纪排序后：");
		for (int s = 0; s < bst.length; s++) {
			System.out.println(bst[s].toString());
		}
		// ————————————————————————————————————————————————
		cptrScore1Compartor nbc=new cptrScore1Compartor();//通过外部比较器排序成绩。
		Arrayutil.sotr2(bst, nbc);//
		System.out.println("成绩排序后：");
		for (int s = 0; s < bst.length; s++) {
			System.out.println(bst[s].toString());
		}
		//-----------------------------
		jast s = new jast("张三", 12);
		System.out.println(s.getName());
		System.out.println(s.getAge());
		System.out.println(s.toString());

	}
}
