package map������;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import ������.����;

public class mapTest {

	public static List<����> getHashset(ArrayList<����> set) {
		HashSet<����> hash = new HashSet<����>();
		hash.addAll(set);
		ArrayList<����> arr = new ArrayList<����>(hash);
		return arr;
	}

	public static <K, V> void main(String[] args) {
		ArrayList<����> set = new ArrayList<����>();
		���� e1 = new ����(30, 10);
		���� e2 = new ����(31, 19);
		���� e7 = new ����(31, 19);
		���� e3 = new ����(39, 10);
		���� e4 = new ����(38, 11);
		���� e5 = new ����(30, 17);
		���� e6 = new ����(30, 10);
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		set.add(e6);
		set.add(e7);
		Collections.sort(set);//����
		Iterator<����> it = set.iterator();// ��ȡ
		int s = 0;
		// set.clear();//��ռ����е�����
		while (it.hasNext()) {
			s++;
			���� employee = it.next();
			System.out.println(s + ". " + employee.toString());
		}
		System.out.println();
		List<����> st = getHashset(set);// ����ĺ���
		Collections.sort(st);// ��List����score���ȼ�����age����
		Iterator<����> it1 = st.iterator();
		s = 0;
		while (it1.hasNext()) {
			s++;
			���� employee = it1.next();
			System.out.println(s + ". " + employee.toString());
		}
	}
}