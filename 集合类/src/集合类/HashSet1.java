package 集合类;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HashSet1 {

	public static void settest() {
		@SuppressWarnings("rawtypes")
		HashSet<Comparable> now = new HashSet<Comparable>();// 无序性，（不是随机性）可以存储空元素（按照数据的哈希值存储的）
		now.add(123);                                       // 添加的元素按照equals（）判断不能返回true 相同的元素不能重复
		now.add(123);
		now.add(456);	
		now.add(789);
		
		now.add("jjsmd");
		now.add(new Equals("张三", 20));
		now.add(new Equals("张三", 20));
        System.out.println("********************************");
		now.add(6);
		String d="aa";
		Character s='l';
		System.out.println((int)s);
		System.out.println(s.hashCode());
		System.out.println(d.hashCode());
		@SuppressWarnings("rawtypes")
		Iterator iter = now.iterator();
		while (iter.hasNext()) {
			Object object = (Object) iter.next();
			System.out.println(object);
		}
	}

	public static void main(String[] args) {

		settest();

	}

}
