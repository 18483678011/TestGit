package ���ݽṹ;

public class ˫������ {

	private String name;
	private int age;
	public ˫������ nest;
	public ˫������ prt;

	public ˫������(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		this.nest = null;
		this.prt = null;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nest == null) ? 0 : nest.hashCode());
		result = prime * result + ((prt == null) ? 0 : prt.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		˫������ other = (˫������) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nest == null) {
			if (other.nest != null)
				return false;
		} else if (!nest.equals(other.nest))
			return false;
		if (prt == null) {
			if (other.prt != null)
				return false;
		} else if (!prt.equals(other.prt))
			return false;
		return true;
	}

	public String toString() {
		return "˫������ [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) {
		˫������ linked0 = new ˫������("������", 12);
		˫������ linked4 = new ˫������("����", 17);
		˫������ linked1 = new ˫������("��ʫ��", 92);
		˫������ linked2 = new ˫������("�޽���", 45);
		˫������ linked7 = new ˫������("�޽���", 65);
		˫������ linked8 = new ˫������("�޽���", 45);
		Data temp = new Data();
		temp.add(linked0);
		temp.add(linked1);
		temp.add(linked4);
		temp.add(linked2);
		temp.add(linked7);
		temp.add(linked8);
		temp.list();
		temp.seek("�޽���");
		temp.seek("����");
		temp.update(linked7);
		temp.list();
		temp.del("��ʫ�� ");
		System.out.println();
		temp.list();
	}
}

class Data {
	private ˫������ head = new ˫������(null, 0); // ����ͷ

	public void add(˫������ DoubleLinke) {
		˫������ temp = head;
		while (true) {
			if (temp.nest == null) {
				break;
			}
			if (DoubleLinke.getName().equals(temp.nest.getName())) {
				System.out.println(DoubleLinke + ":" + "�����Ϣ�ظ����ܾ���ӣ�");
				return;
			}
			temp = temp.nest;
		}
		temp.nest = DoubleLinke;
		DoubleLinke.prt = temp;

	}

	public void list() {// ����
		if (head.nest == null) {
			System.out.println("˫������Ϊ�գ�");
			return;
		}
		˫������ temp = head.nest;
		while (temp != null) {
			System.out.println(temp);
			temp = temp.nest;
		}
	}

	public void seek(String name) {// �����ֲ���

		if (head.nest == null) {
			System.out.println("����Ϊ�գ�");
			return;
		}
		˫������ temp = head.nest;
		int s = 1;
		int d = 0;
		while (true) {
			if (temp.getName().equals(name)) {
				System.out.println(temp + " �������еĵڣ�" + s + "��Ԫ��");
				d++;
			}
			if (temp.nest == null) {
				if (d == 0) {
					System.out.println("û�в��ҵ���Ԫ�أ�");
				}
				break;
			}
			s++;
			temp = temp.nest;
		}

	}

	public void update(˫������ linke) {// �޸�����
		if (head.nest == null) {
			System.out.println("����Ϊ�գ�");
			return;
		}
		˫������ temp = head.nest;
		boolean b = false;
		while (true) {
			if (temp.getName().equals(linke.getName())) {
				temp.setAge(linke.getAge());
				b = true;
			}
			if (temp.nest == null) {
				break;
			}
			temp = temp.nest;
		}
		if (b) {
			System.out.println("���ҵ�! ");
		} else {
			System.out.println("���ݿ�û�и�Ԫ�أ��޷��޸ģ�");
		}
	}

	public void del(String name) {// ɾ��
		if (head.nest == null) {
			System.out.println("����Ϊ�գ�");
			return;
		}
		˫������ temp = head.nest;
		boolean bool = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.getName().equals(name)) {
				bool = true;
				break;
			}
			temp = temp.nest;
		}
		if (bool) {
			System.out.println("�Ѿ��ҵ��ýڵ㣬����ɾ����" + "\n" + "(" + temp + ")ɾ����...");
			temp.prt.nest = temp.nest;
			if (temp.nest != null) {
				temp.nest.prt = temp.prt;
			}
			System.out.println("��ɾ���ýڵ㣡");
		} else {
			System.out.println("û���ҵ��ýڵ�,�޷����ɾ����");
		}
	}
}
