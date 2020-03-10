package 数据结构;

public class 双向链表 {

	private String name;
	private int age;
	public 双向链表 nest;
	public 双向链表 prt;

	public 双向链表(String name, int age) {
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
		双向链表 other = (双向链表) obj;
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
		return "双向链表 [name=" + name + ", age=" + age + "]";
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
		双向链表 linked0 = new 双向链表("阿萨达", 12);
		双向链表 linked4 = new 双向链表("阿萨", 17);
		双向链表 linked1 = new 双向链表("阿诗丹", 92);
		双向链表 linked2 = new 双向链表("罗建家", 45);
		双向链表 linked7 = new 双向链表("罗建家", 65);
		双向链表 linked8 = new 双向链表("罗建家", 45);
		Data temp = new Data();
		temp.add(linked0);
		temp.add(linked1);
		temp.add(linked4);
		temp.add(linked2);
		temp.add(linked7);
		temp.add(linked8);
		temp.list();
		temp.seek("罗建家");
		temp.seek("阿萨");
		temp.update(linked7);
		temp.list();
		temp.del("阿诗丹 ");
		System.out.println();
		temp.list();
	}
}

class Data {
	private 双向链表 head = new 双向链表(null, 0); // 链表头

	public void add(双向链表 DoubleLinke) {
		双向链表 temp = head;
		while (true) {
			if (temp.nest == null) {
				break;
			}
			if (DoubleLinke.getName().equals(temp.nest.getName())) {
				System.out.println(DoubleLinke + ":" + "添加信息重复，拒绝添加！");
				return;
			}
			temp = temp.nest;
		}
		temp.nest = DoubleLinke;
		DoubleLinke.prt = temp;

	}

	public void list() {// 遍历
		if (head.nest == null) {
			System.out.println("双向链表为空！");
			return;
		}
		双向链表 temp = head.nest;
		while (temp != null) {
			System.out.println(temp);
			temp = temp.nest;
		}
	}

	public void seek(String name) {// 按名字查找

		if (head.nest == null) {
			System.out.println("链表为空！");
			return;
		}
		双向链表 temp = head.nest;
		int s = 1;
		int d = 0;
		while (true) {
			if (temp.getName().equals(name)) {
				System.out.println(temp + " 是链表中的第：" + s + "个元素");
				d++;
			}
			if (temp.nest == null) {
				if (d == 0) {
					System.out.println("没有查找到该元素！");
				}
				break;
			}
			s++;
			temp = temp.nest;
		}

	}

	public void update(双向链表 linke) {// 修改链表
		if (head.nest == null) {
			System.out.println("链表为空！");
			return;
		}
		双向链表 temp = head.nest;
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
			System.out.println("已找到! ");
		} else {
			System.out.println("数据库没有该元素，无法修改！");
		}
	}

	public void del(String name) {// 删除
		if (head.nest == null) {
			System.out.println("链表为空！");
			return;
		}
		双向链表 temp = head.nest;
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
			System.out.println("已经找到该节点，可以删除！" + "\n" + "(" + temp + ")删除中...");
			temp.prt.nest = temp.nest;
			if (temp.nest != null) {
				temp.nest.prt = temp.prt;
			}
			System.out.println("已删除该节点！");
		} else {
			System.out.println("没有找到该节点,无法完成删除！");
		}
	}
}
