
public class laoying extends huangs {
	public laoying(String minzi) {// ���캯��
		this.minzi = "��ӥ";
		yanse = "��ɫ";
	}

	String yanse;
	String minzi;

	public void tsee() {// �������������
		yumao();
		chifan();
		fanzi();
		yidong();
	}

	public void yumao() {// ��ӥ��ë��ɫ
		// TODO �Զ����ɵķ������
		
		System.out.println(minzi + yanse + "����ë");

	}

	public void chifan() {// ��ӥ��ʳʳ��
		// TODO �Զ����ɵķ������
		System.out.println(minzi + "����");
	}
	/*
	 * public void fanzi() { System.out.println(minzi+"��ֳ���µ���"); }
	 */

	public void yidong() {// �ƶ�����ʵ�ַ���
		// TODO �Զ����ɵķ������
		System.out.println(minzi + "�ƶ������衣");
	}

	@Override
	public void yumao(String mao) {
		// TODO �Զ����ɵķ������

	}

}
