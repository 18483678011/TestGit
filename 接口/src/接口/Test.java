package �ӿ�;

import com.Jeikou.cptr;
import com.Jeikou.cptrScore1Compartor;
import com.Jeikou.stuAgeCompartor;
import com.Jeikou.stuNameCompartor;

public class Test {

	public static void main(String[] args) {
//������������������������������������������������������������������������������������������������������������������������ѧ������
		student[] Strarr = new student[5];
		Strarr[0] = new student("a����", 12, 80);
		Strarr[1] = new student("c����", 13, 60);
		Strarr[2] = new student("b����", 14, 88);
		Strarr[3] = new student("f����", 17, 89);
		Strarr[4] = new student("g����", 11, 98);

		// ����ǰ
		System.out.println("����ǰ��");
		for (student b : Strarr) {
			System.out.println(b.toString());
		}
		// ����
		Arrayutil.sotr(Strarr);// �������
		// ��������
		System.out.println("��������");
		for (student b : Strarr) {
			System.out.println(b.toString());
		}

		Arrayutil.sotr1(Strarr);// ��������

		System.out.println("���������");
		for (student b : Strarr) {
			System.out.println(b.toString());
		}
		// -------------------------------------------------cptr����
		cptr[] look = new cptr[3];
		look[0] = new cptr("123", 12, 5);
		look[1] = new cptr("234", 19, 6);
		look[2] = new cptr("345", 14, 7);
		System.out.println("����ǰ��");
		for (cptr b : look) {
			System.out.println(b.toString());
		}
		Arrayutil.sotr(look);
		System.out.println("�����");
		for (cptr b : look) {
			System.out.println(b.toString());
		}
		// ______________________________________________________________________________________ȫ�־�̬������

		System.out.println(drawTest.PI);// �ӿ��е�����ȫ��Ĭ��Ϊpublic static abstract(����ؼ���)����ȫ�־�̬��������
		drawTest ts1 = new ren();// �ӿڲ���new�Լ���������Ҳ����new�Լ���
		ts1.test();
		// ____________________________________________________int����
		int[] str = { 2, 3, 5, 4, 98, 566, 6 };
		Arrayutil.sotr(str);
		System.out.println("int������������");
		for (int s = 0; s < str.length; s++) {
			System.out.print(str[s] + " ");
		}
		System.out.println();
		ts1.fulei1();
		// ______________________________________________________________________________________jast������

		jast[] bst = new jast[5];
		bst[0] = new jast("s01", 10,80.3);
		bst[1] = new jast("d02", 19,60.3);
		bst[2] = new jast("e03", 13,99.0);
		bst[3] = new jast("a04", 8,100);
		bst[4] = new jast("f05", 14,78);
		System.out.println("����ǰ��");
		for (int s = 0; s < bst.length; s++) {
			System.out.println(bst[s].toString());
		}

		stuNameCompartor ns = new stuNameCompartor();// ������������ jast���еĲſ���
		Arrayutil.sotr2(bst, ns);
		System.out.println("���������");
		for (int s = 0; s < bst.length; s++) {
			System.out.println(bst[s].toString());
		}
		// _____________________________________________________
		stuAgeCompartor nb = new stuAgeCompartor();// �����������jast���еĲſ���
		Arrayutil.sotr2(bst, nb);//
		System.out.println("��������");
		for (int s = 0; s < bst.length; s++) {
			System.out.println(bst[s].toString());
		}
		// ������������������������������������������������������������������������������������������������
		cptrScore1Compartor nbc=new cptrScore1Compartor();//ͨ���ⲿ�Ƚ�������ɼ���
		Arrayutil.sotr2(bst, nbc);//
		System.out.println("�ɼ������");
		for (int s = 0; s < bst.length; s++) {
			System.out.println(bst[s].toString());
		}
		//-----------------------------
		jast s = new jast("����", 12);
		System.out.println(s.getName());
		System.out.println(s.getAge());
		System.out.println(s.toString());

	}
}
