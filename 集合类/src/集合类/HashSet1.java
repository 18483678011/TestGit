package ������;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HashSet1 {

	public static void settest() {
		@SuppressWarnings("rawtypes")
		HashSet<Comparable> now = new HashSet<Comparable>();// �����ԣ�����������ԣ����Դ洢��Ԫ�أ��������ݵĹ�ϣֵ�洢�ģ�
		now.add(123);                                       // ��ӵ�Ԫ�ذ���equals�����жϲ��ܷ���true ��ͬ��Ԫ�ز����ظ�
		now.add(123);
		now.add(456);	
		now.add(789);
		
		now.add("jjsmd");
		now.add(new Equals("����", 20));
		now.add(new Equals("����", 20));
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
