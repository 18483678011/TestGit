package 员工排序TreeSte;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;



public class TesstSet {
    private static int a=1;
	public static void test() {
		TreeSet<Employee> set = new TreeSet<Employee>();
		Employee e1 = new Employee("张三", new MyDate(1998, 5, 18));
		Employee e2 = new Employee("李四", new MyDate(1996, 5, 12));
		Employee e3 = new Employee("王五", new MyDate(1996, 2, 14));
		Employee e4 = new Employee("赵丽", new MyDate(1994, 11, 21));	
		Employee e5 = new Employee("小七", new MyDate(1990, 2, 8));
		Employee e6 = new Employee("赵丽", new MyDate(1994, 11, 22));
		Employee e7 = new Employee("赵丽", new MyDate(1994, 11, 22));

		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		set.add(e6);
		set.add(e7);
		Iterator<Employee> it= set.iterator();
		System.out.println();
		System.out.println("***********************员工年龄表***********************");
	
		while (it.hasNext()) {				
			Employee employee = (Employee) it.next();
			System.out.println(a+"."+employee.toString()+ "\t"+new Date());
			a++;
		}
	}

	public static void main(String[] args) {
		TesstSet.test();
	}

}
