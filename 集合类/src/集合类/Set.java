package 集合类;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Set {
	
	public int test1() {
		return 0;
		
	}
	
	public static void naturalTest() {
		TreeSet<String> set = new TreeSet<String>();
		set.add("a");
		set.add("aaaa");
		set.add("aa");
		set.add("aaaaa");
		set.add("a");
		set.add("12345");
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
	}

	public static void naturalTest1() {
		TreeSet<Integer> set = new TreeSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(6);
		Iterator<Integer> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
	}

	public static void main(String[] args) {
		Collection<Equals> col = new TreeSet<>();//不可重复 地址
		Equals eq1 = new Equals("小王", 10);
		Equals eq2 = new Equals("小张", 14);
		Equals eq3 = new Equals("小罗", 15);
		Equals eq4 = new Equals("小章", 90);
		Equals eq5 = new Equals("小罗", 12);

		col.add(eq1);
		col.add(eq2);
		col.add(eq3);
		col.add(eq4);
		col.add(eq5);
		col.add(new Equals("小罗", 16));
		// col.remove(eq5);//移除操作
	
		 
		
		
		Iterator<Equals> iter = col.iterator();//
		while (iter.hasNext()) {
			Equals c = (Equals) iter.next();
			System.out.println(c.getName() + " " + c.getAge()+" "+col.size());
		}
		System.out.println("*****************************");

		iter = ((TreeSet<Equals>) col).headSet(eq3).iterator();// 之前的新集合
		while (iter.hasNext()) {
			Equals b = (Equals) iter.next();
			System.out.println(b.getName() + " " + b.getAge());
		}
		System.out.println("**************************");		
		Collection<Equals> coll = ((TreeSet<Equals>) col).subSet(eq5,eq4);//创建一个		
		Iterator<Equals> jbs=coll.iterator();	
		while (jbs.hasNext()) {
			Equals k=jbs.next();
			System.out.println(k.getName()+"**** "+coll.size());
		}
		Set.naturalTest1();
		Set.naturalTest();
	}
}
