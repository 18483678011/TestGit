package ������;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {
	public static void main(String[] args) {
		ArrayList<Object> coll = new ArrayList<Object>();// ����������
		Integer[] s = { 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int a = 0; a < s.length; a++) {
			coll.add(s[a]);
		}
		String s2 = "nb";
		coll.add(s2);// ���������Ԫ��
		coll.add(2, 999);// ����������ݣ���3��λ
		coll.add(true);
		Equals but = new Equals("tomo", 10);
		coll.add(but);
		coll.add(but);
		coll.add(s2);
		coll.add(new Equals("tomo", 10));
		coll.remove(0);// �ӵ�ǰ����ɾ��0��Ԫ�أ�
		coll.set(6, new Equals("����", 20));// �滻10�ŵ�Ԫ��
		coll.remove("nb");
		coll.remove(s[2]);
		coll.remove(but);
		coll.remove(but);
		coll.remove(but);

		List<Integer> nums = new ArrayList<Integer>(); // ����
		nums.add(3);
		nums.add(5);
		nums.add(1);
		nums.add(0);
		System.out.println(nums);
		Collections.sort(nums);
		System.out.println(nums);
		
		
		
		
		// **********************************************************��ArrayList����
		List<Equals> num = new ArrayList<Equals>();
		Equals eq1 = new Equals("С��", 10);
		Equals eq2 = new Equals("С��", 14);
		Equals eq3 = new Equals("С��", 15);
		Equals eq4 = new Equals("С��", 90);
		Equals eq5 = new Equals("С��", 12);
		num.add(eq1);
		num.add(eq2);
		num.add(eq3);
		num.add(eq4);
		num.add(eq5);
		System.out.println("����ǰ:");
		Iterator<Equals> d = num.iterator();
		while (d.hasNext()) {
			Equals equals = (Equals) d.next();
			System.out.println(equals.getName() + ":" + equals.getAge());
		}
		System.out.println("�����:");
		Collections.sort(num);//����
		Iterator<Equals> i = num.iterator();
		while (i.hasNext()) {
			Equals equals = (Equals) i.next();
			System.out.println(equals.getName() + ":" + equals.getAge());
		}
		// ***********************************************************************

		
		Collection<Object> coll1 = new ArrayList<Object>();
		coll1.add(but);
		coll1.add(s2);
		System.out.println("��ϣ��" + coll.get(10).hashCode() + coll.get(10));
		System.out.println(coll.get(2));// ��ȡ3��λ������

		// coll.removeAll(coll1);// ɾ���������Ϲ�ͬ�Ĳ���
		// coll.retainAll(coll1);// �����������Ϲ�ͬ�Ĳ���

		Iterator<Object> iter = coll.iterator();// ����������

		while (iter.hasNext()) {
			System.out.print(iter.next() + ", ");

		}
		System.out.println();
		boolean b = coll.contains(33);// �Ҽ���coll��û��33�������, �з���true û�з���false
		boolean bool = but.equals(new Equals("tomo", 10));// �ж����������Ƿ����
		System.out.println("coll����Ԫ�ظ���:" + coll.size());// Ԫ�ظ���
		System.out.println(coll.get(10) + "  asdasdasdasdad");
		System.out.println("�ж�coll�����Ƿ�Ϊ��:" + coll.isEmpty());// �жϼ����Ƿ���Ԫ�� ��Ϊtrue ����Ϊfalse
		System.out.println(bool);// true
		System.out.println(b);// false
		System.out.println(coll);// ==coll.toString()
		System.out.println(coll.hashCode());// ����Ĺ�ϣֵ
	}
}
