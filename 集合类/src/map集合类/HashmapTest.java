package map集合类;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashmapTest {

	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("A", 10);
		m.put("B", 12);
		m.put("C", 13);
		m.put("D", 18);
		m.put("E", 17);
		m.put("F", 19);
		m.put("G", 18);
		System.out.println(m.get("F"));// 获取F所对应的数据
		// 遍历所有的key---------------------------------------------------
		java.util.Set<String> s = m.keySet();
		Iterator<String> n = s.iterator();
		while (n.hasNext()) {
			Object object = (Object) n.next();
			System.out.print(object + "  ");
		}
		System.out.println();
		for (int i = 0; i < m.size(); i++) {
			System.out.print("^  ");
		}
		System.out.println();
		// 遍历所有的value-----------------------------------------------------
		Collection<Integer> values = m.values();
		Iterator<Integer> iterator = values.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			System.out.print(integer + " ");
		}
		System.out.println();
		// 获取所有的key-->value--------------------------------------------------------------方式1
		System.out.println("获取所有的key-->value----------------------------");
		Set<Entry<String, Integer>> entrySet = m.entrySet();
		Iterator<Entry<String, Integer>> iterator2 = entrySet.iterator();
		int s1 = 0;
		while (iterator2.hasNext()) {
			s1++;
			Entry<String, Integer> entry = iterator2.next();

			System.out.println(s1 + "、 " + entry.getKey() + " --> " + entry.getValue());
		}
		// 方式2-----------------------获取所有的key-->value-------------------------------------
		Set<String> keySet = m.keySet();
		Iterator<String> iterator3 = keySet.iterator();
		while (iterator3.hasNext()) {
			Object objejct = iterator3.next();
			Object object = m.get(objejct);
			System.out.println(objejct + "-->" + object);

		}
	}
}
