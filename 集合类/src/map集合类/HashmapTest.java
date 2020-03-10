package map������;

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
		System.out.println(m.get("F"));// ��ȡF����Ӧ������
		// �������е�key---------------------------------------------------
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
		// �������е�value-----------------------------------------------------
		Collection<Integer> values = m.values();
		Iterator<Integer> iterator = values.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			System.out.print(integer + " ");
		}
		System.out.println();
		// ��ȡ���е�key-->value--------------------------------------------------------------��ʽ1
		System.out.println("��ȡ���е�key-->value----------------------------");
		Set<Entry<String, Integer>> entrySet = m.entrySet();
		Iterator<Entry<String, Integer>> iterator2 = entrySet.iterator();
		int s1 = 0;
		while (iterator2.hasNext()) {
			s1++;
			Entry<String, Integer> entry = iterator2.next();

			System.out.println(s1 + "�� " + entry.getKey() + " --> " + entry.getValue());
		}
		// ��ʽ2-----------------------��ȡ���е�key-->value-------------------------------------
		Set<String> keySet = m.keySet();
		Iterator<String> iterator3 = keySet.iterator();
		while (iterator3.hasNext()) {
			Object objejct = iterator3.next();
			Object object = m.get(objejct);
			System.out.println(objejct + "-->" + object);

		}
	}
}
