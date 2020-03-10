package 集合类;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {
	public static void main(String[] args) {
		ArrayList<Object> coll = new ArrayList<Object>();// 创建集合类
		Integer[] s = { 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int a = 0; a < s.length; a++) {
			coll.add(s[a]);
		}
		String s2 = "nb";
		coll.add(s2);// 向容器添加元素
		coll.add(2, 999);// 添加容器内容，在3号位
		coll.add(true);
		Equals but = new Equals("tomo", 10);
		coll.add(but);
		coll.add(but);
		coll.add(s2);
		coll.add(new Equals("tomo", 10));
		coll.remove(0);// 从当前集合删除0号元素；
		coll.set(6, new Equals("张三", 20));// 替换10号的元素
		coll.remove("nb");
		coll.remove(s[2]);
		coll.remove(but);
		coll.remove(but);
		coll.remove(but);

		List<Integer> nums = new ArrayList<Integer>(); // 排序
		nums.add(3);
		nums.add(5);
		nums.add(1);
		nums.add(0);
		System.out.println(nums);
		Collections.sort(nums);
		System.out.println(nums);
		
		
		
		
		// **********************************************************对ArrayList排序
		List<Equals> num = new ArrayList<Equals>();
		Equals eq1 = new Equals("小王", 10);
		Equals eq2 = new Equals("小张", 14);
		Equals eq3 = new Equals("小罗", 15);
		Equals eq4 = new Equals("小章", 90);
		Equals eq5 = new Equals("小罗", 12);
		num.add(eq1);
		num.add(eq2);
		num.add(eq3);
		num.add(eq4);
		num.add(eq5);
		System.out.println("排序前:");
		Iterator<Equals> d = num.iterator();
		while (d.hasNext()) {
			Equals equals = (Equals) d.next();
			System.out.println(equals.getName() + ":" + equals.getAge());
		}
		System.out.println("排序后:");
		Collections.sort(num);//排序
		Iterator<Equals> i = num.iterator();
		while (i.hasNext()) {
			Equals equals = (Equals) i.next();
			System.out.println(equals.getName() + ":" + equals.getAge());
		}
		// ***********************************************************************

		
		Collection<Object> coll1 = new ArrayList<Object>();
		coll1.add(but);
		coll1.add(s2);
		System.out.println("哈希：" + coll.get(10).hashCode() + coll.get(10));
		System.out.println(coll.get(2));// 读取3号位置数据

		// coll.removeAll(coll1);// 删除两个集合共同的部分
		// coll.retainAll(coll1);// 保留两个集合共同的部分

		Iterator<Object> iter = coll.iterator();// 迭代器遍历

		while (iter.hasNext()) {
			System.out.print(iter.next() + ", ");

		}
		System.out.println();
		boolean b = coll.contains(33);// 找集合coll有没有33这个内容, 有返回true 没有返回false
		boolean bool = but.equals(new Equals("tomo", 10));// 判断两个对象是否相等
		System.out.println("coll集合元素个数:" + coll.size());// 元素个数
		System.out.println(coll.get(10) + "  asdasdasdasdad");
		System.out.println("判断coll集合是否为空:" + coll.isEmpty());// 判断集合是否有元素 空为true 否则为false
		System.out.println(bool);// true
		System.out.println(b);// false
		System.out.println(coll);// ==coll.toString()
		System.out.println(coll.hashCode());// 对象的哈希值
	}
}
