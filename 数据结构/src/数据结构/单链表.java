package ���ݽṹ;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;//ջ

public class ������ {
	private String name;
	private int age;
	public ������ nest;

	public void setAge(int age) {
		this.age = age;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		������ other = (������) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public ������() {
		super();
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ������(String name, int age) {

		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "linked [name=" + name + ", age=" + age + "]";
	}

	public static void main(String[] args) {
		������ linked0 = new ������("������", 12);
		������ linked4 = new ������("����", 17);
		������ linked1 = new ������("��ʫ��", 92);
		������ linked2 = new ������("�޽���", 45);
		������ linked7 = new ������("�޽���", 45);
		������ linked3 = new ������("��˹��", 77);
		������ linked5 = new ������("��˹1��", 75);
		������ linked6 = new ������("��˹��", 75);
		������ linked8 = new ������("��˹��", 100);
		������ linked9 = new ������("��˹��", 101);
		������ linked10 = new ������("��sad˹��", 187);
		������ linked11 = new ������("��˹65��", 872);
		fangfa hast = new fangfa();
		hast.add1(linked1);
		hast.add1(linked0);
		hast.add1(linked3);
		hast.add1(linked4);
		hast.add1(linked2);
		hast.add1(linked5);
		hast.add1(linked8);
		hast.add1(linked9);
		hast.add1(linked7);
		hast.add1(linked6);
		hast.fileget();// �������е����ݴ����ļ�
		System.out.println("������Ч������" + hast.length(hast.getHead()));// ��ȡ��ǰ������Ԫ�ظ���
		hast.list();
		System.out.println();
		hast.insert(linked5, linked11);// ��l1Ԫ�غ����Ԫ��l2
		System.out.println("������Ч������" + hast.length(hast.getHead()));// ��ȡ��ǰ������Ԫ�ظ���
		hast.list();
		System.out.println();
		hast.insert(linked1, linked10);// ��l1Ԫ�غ����Ԫ��l2
		System.out.println("������Ч������" + hast.length(hast.getHead()));// ��ȡ��ǰ������Ԫ�ظ���
		hast.list();
		// hast.add(linked9);
		System.out.println();
		hast.seek("��˹��");// ����Ԫ�ص�λ��
		hast.delete("������");// ����� ɾ������Ϊname������
		System.out.println("������Ч������" + hast.length(hast.getHead()));// ��ȡ��ǰ������Ԫ�ظ���
		hast.list();
		hast.delete("��ʫ��");// ����� ɾ������Ϊname������
		hast.fileget1();// �����ݴ����ļ����򻯰棩
		System.out.println();
		System.out.println("���ҵ���Ԫ��Ϊ��" + hast.ForwardSearch(hast.getHead(), 5));// �����Number��������
		System.out.println("�������~~~~~");
		System.out.println("������Ч������" + hast.length(hast.getHead()));// ��ȡ��ǰ������Ԫ�ظ���
		hast.list();
		System.out.println("����˳���ı������~~~~~");
		hast.linkedlistturn(hast.getHead());// ����������Ԫ�ط�ת��������ṹ��
		System.out.println("������Ч������" + hast.length(hast.getHead()));// ��ȡ��ǰ������Ԫ�ظ���
		hast.list();// ��������
		System.out.println("�����ӡ���ݣ�");
		hast.reversePrint(hast.getHead());// �����ӡ���ݣ���ջ�ṹ����û�б�����ṹ��
		hast.list();
	}
}

class fangfa {
	private ������ head = new ������("", 0);

	public void add(������ linke) {// ��˳�����Ԫ��
		������ temp = head;
		while (true) {
			if (temp.nest == null) {
				break;
			}
			temp = temp.nest;
		}
		temp.nest = linke;
	}

	public ������ getHead() {
		return head;
	}

	public void linkedlistturn(������ linke) {// ����������Ԫ�ط�ת��������ṹ��
		if (linke.nest == null || linke.nest.nest == null) {
			return;
		}
		������ cadLinked = linke.nest;
		������ next = null;// cadLinked����һ���ڵ�
		������ newlinked = new ������();// �½���һ������������ʱ��ת����
		while (cadLinked != null) {
			next = cadLinked.nest;// װ��ǰԪ�ص���һ��Ԫ��
			cadLinked.nest = newlinked.nest;
			newlinked.nest = cadLinked;
			cadLinked = next;// ����һ��Ԫ��
		}
		linke.nest = newlinked.nest;// ���������Ԫ�ػ�ԭ��ԭ�����ͷ����Ԫ��

	}

	public int length(������ head) {// ��ȡ��ǰ������Ԫ�ظ���
		if (head.nest == null) {
			System.out.println("����Ϊ��");
			return 0;
		}
		int d = 0;
		������ he = head;
		while (he.nest != null) {
			d++;
			he = he.nest;
		}
		return d;
	}

	public ������ ForwardSearch(������ head, int Number) {// �����Number��������
		if (head.nest == null) {
			System.out.println("����Ϊ��");
			return null;
		}
		int d = 0;
		������ he = head;
		while (he.nest != null) {
			d++;
			he = he.nest;
		}
		if (Number <= 0 || Number > d) {
			;
			return null;
		}
		he = head;
		for (int i = 0; i < Number; i++) {
			he = he.nest;
		}
		return he;
	}

	public void fileget() {
		File file = new File("C:\\Users\\Administrator\\Desktop\\��������.txt");// �������е����ݴ����ļ�
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			������ temp = head.nest;
			while (true) {
				if (temp == null) {
					break;
				}
				fileWriter.write(temp.toString() + "\r\n");
				temp = temp.nest;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void fileget1() {
		File file = new File("C:\\Users\\Administrator\\Desktop\\��������1.txt");// �����ݴ����ļ����򻯰棩
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			������ temp = head.nest;
			while (true) {
				if (temp == null) {
					break;
				}
				fileWriter.write(temp.getName() + "\t" + temp.getAge() + "\r\n");
				temp = temp.nest;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ����˳�����
	public void add1(������ linke) {// ���������������
		������ temp = head;
		boolean flag = false;
		while (true) {
			if (temp.nest == null) {
				break;
			}
			if (temp.nest.getAge() > linke.getAge()) {
				break;
			}
			if (temp.nest.getAge() == linke.getAge() && temp.nest.getName() == linke.getName()) {
				flag = true;// ��Ŵ���
				break;
			}
			temp = temp.nest;
		}
		if (flag) {
			System.out.println(temp.nest.toString() + " �������,���˴��ڣ� ");
		} else {
			linke.nest = temp.nest;
			temp.nest = linke;
		}
	}

	public void list() {// �������Ԫ��
		if (head.nest == null) {
			System.out.println("����Ϊ��");
			return;
		}
		������ temp = head.nest;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.nest;
		}
	}

	public void seek(String name) {// ����Ԫ�ص�λ��
		if (head.nest == null) {
			System.out.println("����Ϊ�գ�����");
			return;
		}
		int s = 1;
		int d = 0;
		������ temp = head.nest;
		while (true) {
			if (temp.getName().equals(name)) {
				System.out.println("���ҵ���Ԫ�������ݿ��еĵ�" + s + "��Ԫ�أ�" + temp);
				d++;
			}
			if (temp.nest == null) {
				if (d == 0) {
					System.out.println("���ݿ�û�и�Ԫ��:" + name);
				}
				break;
			}
			s++;
			temp = temp.nest;
		}
	}

	public void delete(String name) {// ����� ɾ������Ϊname������
		if (head.nest == null) {
			System.out.println("����Ϊ�գ�����");
			return;
		}
		int s = 0;
		������ tempLinked = head;
		boolean l = false;
		while (true) {
			if (tempLinked.nest.getName().equals(name)) {
				l = true;
				break;
			}
			if (tempLinked.nest == null) {
				break;
			}
			tempLinked = tempLinked.nest;
		}
		if (l) {
			tempLinked.nest = tempLinked.nest.nest;
			return;
		} else {
			if (s == 0) {
				System.out.println("û�и�Ԫ�أ�");
				return;
			}
		}
	}

	public void update(������ linke) {// �޸�����
		if (head.nest == null) {
			System.out.println("����Ϊ�գ�����");
			return;
		}
		������ tempLinked = head.nest;
		boolean bool = false;
		while (true) {
			if (tempLinked.nest == null) {
				break;
			}
			if (tempLinked.nest.getAge() == linke.getAge() && tempLinked.nest.getName() == linke.getName()) {
				bool = true;
				break;
			}
			tempLinked = tempLinked.nest;
		}
		if (bool) {
			tempLinked.setAge(linke.getAge());
		} else {
			System.out.println("û�и�����Ϣ��");
		}

	}

	public void insert(������ l1, ������ l2) {// ��l1Ԫ�غ����Ԫ��l2
		if (head.nest == null) {
			System.out.println("����Ϊ�գ�����");
			return;
		}
		������ temp = head.nest;
		boolean tenp = false;
		while (true) {
			if (l1.getName() == (temp.getName())) {
				tenp = true;
				break;
			}
			if (temp.nest == null) {
				return;
			}
			temp = temp.nest;
		}
		if (tenp) {
			l2.nest = temp.nest;
			temp.nest = l2;
		} else {
			System.out.println("���ݿ�û�иü�¼��");
		}
	}

	public void reversePrint(������ head) {// �����ӡ���ݣ���ջ�ṹ��û�иı�����ṹ
		if (head.nest == null) {
			return;
		}
		Stack<������> stack = new Stack<������>();// ����ջ
		������ sLinked = head.nest;
		while (sLinked != null) {
			stack.add(sLinked);// ջѹ������
			sLinked = sLinked.nest;
		}
		while (stack.size() > 0) {
			������ nLinked = stack.pop();// ջ��������
			System.out.println(nLinked);
		}
	}
}
