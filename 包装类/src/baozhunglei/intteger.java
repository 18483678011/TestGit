package baozhunglei;

public class intteger {



	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Integer iny1 = new Integer(9);
		System.out.println(Integer.toString(iny1, 2) + " " + Integer.MAX_VALUE);// 2���Ʊ�ʾ
		Character str = new Character('S');
		System.out.println(Character.toLowerCase(str));// ��дת��ΪСд��
		System.out.println(Character.isLowerCase(str));// �ж��ǲ���Сд
		System.out.println(Character.isLetter(str));// �ж��ǲ�����ĸ
		Integer int2 = new Integer(10);
		int d = int2;
		String s = Integer.toBinaryString(int2);
		System.out.println(s + "   " + d);
		Character s1 = new Character('d');
		Character s3 = Character.toUpperCase(s1);
		Character s2 = new Character('D');
		char s4 = Character.toUpperCase(s2);
		System.out.println(s2.equals(s3));//�ж��������Ƿ���ȣ�
		System.out.println(s3.equals(s4));//�ж��������Ƿ���ȣ�

	}

}
