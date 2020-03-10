package mapºØ∫œ¿‡;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import ºØ∫œ¿‡.≈≈–Ú;

public class mapTest {

	public static List<≈≈–Ú> getHashset(ArrayList<≈≈–Ú> set) {
		HashSet<≈≈–Ú> hash = new HashSet<≈≈–Ú>();
		hash.addAll(set);
		ArrayList<≈≈–Ú> arr = new ArrayList<≈≈–Ú>(hash);
		return arr;
	}

	public static <K, V> void main(String[] args) {
		ArrayList<≈≈–Ú> set = new ArrayList<≈≈–Ú>();
		≈≈–Ú e1 = new ≈≈–Ú(30, 10);
		≈≈–Ú e2 = new ≈≈–Ú(31, 19);
		≈≈–Ú e7 = new ≈≈–Ú(31, 19);
		≈≈–Ú e3 = new ≈≈–Ú(39, 10);
		≈≈–Ú e4 = new ≈≈–Ú(38, 11);
		≈≈–Ú e5 = new ≈≈–Ú(30, 17);
		≈≈–Ú e6 = new ≈≈–Ú(30, 10);
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		set.add(e6);
		set.add(e7);
		Collections.sort(set);//≈≈–Ú
		Iterator<≈≈–Ú> it = set.iterator();// ªÒ»°
		int s = 0;
		// set.clear();//«Âø’ºØ∫œ÷–µƒ ˝æ›
		while (it.hasNext()) {
			s++;
			≈≈–Ú employee = it.next();
			System.out.println(s + ". " + employee.toString());
		}
		System.out.println();
		List<≈≈–Ú> st = getHashset(set);// …œ√Êµƒ∫Ø ˝
		Collections.sort(st);// ∏¯List∞¥’’score”≈œ»º∂∏ﬂ”⁄age≈≈–Ú
		Iterator<≈≈–Ú> it1 = st.iterator();
		s = 0;
		while (it1.hasNext()) {
			s++;
			≈≈–Ú employee = it1.next();
			System.out.println(s + ". " + employee.toString());
		}
	}
}