package 数据结构;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;//栈

public class 单链表 {
	private String name;
	private int age;
	public 单链表 nest;

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
		单链表 other = (单链表) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public 单链表() {
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

	public 单链表(String name, int age) {

		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "linked [name=" + name + ", age=" + age + "]";
	}

	public static void main(String[] args) {
		单链表 linked0 = new 单链表("阿萨达", 12);
		单链表 linked4 = new 单链表("阿萨", 17);
		单链表 linked1 = new 单链表("阿诗丹", 92);
		单链表 linked2 = new 单链表("罗建家", 45);
		单链表 linked7 = new 单链表("罗建家", 45);
		单链表 linked3 = new 单链表("阿斯顿", 77);
		单链表 linked5 = new 单链表("阿斯1顿", 75);
		单链表 linked6 = new 单链表("阿斯顿", 75);
		单链表 linked8 = new 单链表("阿斯顿", 100);
		单链表 linked9 = new 单链表("阿斯顿", 101);
		单链表 linked10 = new 单链表("阿sad斯顿", 187);
		单链表 linked11 = new 单链表("阿斯65顿", 872);
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
		hast.fileget();// 将链表中的数据存入文件
		System.out.println("链表有效个数：" + hast.length(hast.getHead()));// 获取当前链表总元素个数
		hast.list();
		System.out.println();
		hast.insert(linked5, linked11);// 在l1元素后添加元素l2
		System.out.println("链表有效个数：" + hast.length(hast.getHead()));// 获取当前链表总元素个数
		hast.list();
		System.out.println();
		hast.insert(linked1, linked10);// 在l1元素后添加元素l2
		System.out.println("链表有效个数：" + hast.length(hast.getHead()));// 获取当前链表总元素个数
		hast.list();
		// hast.add(linked9);
		System.out.println();
		hast.seek("阿斯顿");// 查找元素的位置
		hast.delete("阿萨达");// 排序后 删除名字为name的数据
		System.out.println("链表有效个数：" + hast.length(hast.getHead()));// 获取当前链表总元素个数
		hast.list();
		hast.delete("阿诗丹");// 排序后 删除名字为name的数据
		hast.fileget1();// 将数据存入文件（简化版）
		System.out.println();
		System.out.println("查找到的元素为：" + hast.ForwardSearch(hast.getHead(), 5));// 正向第Number查找数据
		System.out.println("遍历结果~~~~~");
		System.out.println("链表有效个数：" + hast.length(hast.getHead()));// 获取当前链表总元素个数
		hast.list();
		System.out.println("交换顺序后的遍历结果~~~~~");
		hast.linkedlistturn(hast.getHead());// 将链表所有元素翻转（变链表结构）
		System.out.println("链表有效个数：" + hast.length(hast.getHead()));// 获取当前链表总元素个数
		hast.list();// 遍历数据
		System.out.println("逆序打印数据！");
		hast.reversePrint(hast.getHead());// 逆序打印数据（用栈结构）（没有变链表结构）
		hast.list();
	}
}

class fangfa {
	private 单链表 head = new 单链表("", 0);

	public void add(单链表 linke) {// 无顺序添加元素
		单链表 temp = head;
		while (true) {
			if (temp.nest == null) {
				break;
			}
			temp = temp.nest;
		}
		temp.nest = linke;
	}

	public 单链表 getHead() {
		return head;
	}

	public void linkedlistturn(单链表 linke) {// 将链表所有元素翻转（变链表结构）
		if (linke.nest == null || linke.nest.nest == null) {
			return;
		}
		单链表 cadLinked = linke.nest;
		单链表 next = null;// cadLinked的下一个节点
		单链表 newlinked = new 单链表();// 新建的一个链表用于临时翻转链表
		while (cadLinked != null) {
			next = cadLinked.nest;// 装当前元素的下一个元素
			cadLinked.nest = newlinked.nest;
			newlinked.nest = cadLinked;
			cadLinked = next;// 下移一个元素
		}
		linke.nest = newlinked.nest;// 将新链表的元素还原到原链表的头链表元素

	}

	public int length(单链表 head) {// 获取当前链表总元素个数
		if (head.nest == null) {
			System.out.println("数据为空");
			return 0;
		}
		int d = 0;
		单链表 he = head;
		while (he.nest != null) {
			d++;
			he = he.nest;
		}
		return d;
	}

	public 单链表 ForwardSearch(单链表 head, int Number) {// 正向第Number查找数据
		if (head.nest == null) {
			System.out.println("数据为空");
			return null;
		}
		int d = 0;
		单链表 he = head;
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
		File file = new File("C:\\Users\\Administrator\\Desktop\\链表数据.txt");// 将链表中的数据存入文件
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			单链表 temp = head.nest;
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
		File file = new File("C:\\Users\\Administrator\\Desktop\\链表数据1.txt");// 将数据存入文件（简化版）
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			单链表 temp = head.nest;
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

	// 按照顺序添加
	public void add1(单链表 linke) {// 按照年龄排序添加
		单链表 temp = head;
		boolean flag = false;
		while (true) {
			if (temp.nest == null) {
				break;
			}
			if (temp.nest.getAge() > linke.getAge()) {
				break;
			}
			if (temp.nest.getAge() == linke.getAge() && temp.nest.getName() == linke.getName()) {
				flag = true;// 编号存在
				break;
			}
			temp = temp.nest;
		}
		if (flag) {
			System.out.println(temp.nest.toString() + " 不能添加,该人存在！ ");
		} else {
			linke.nest = temp.nest;
			temp.nest = linke;
		}
	}

	public void list() {// 遍历输出元素
		if (head.nest == null) {
			System.out.println("链表为空");
			return;
		}
		单链表 temp = head.nest;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.nest;
		}
	}

	public void seek(String name) {// 查找元素的位置
		if (head.nest == null) {
			System.out.println("链表为空！！！");
			return;
		}
		int s = 1;
		int d = 0;
		单链表 temp = head.nest;
		while (true) {
			if (temp.getName().equals(name)) {
				System.out.println("查找到该元素是数据库中的第" + s + "个元素：" + temp);
				d++;
			}
			if (temp.nest == null) {
				if (d == 0) {
					System.out.println("数据库没有该元素:" + name);
				}
				break;
			}
			s++;
			temp = temp.nest;
		}
	}

	public void delete(String name) {// 排序后 删除名字为name的数据
		if (head.nest == null) {
			System.out.println("链表为空！！！");
			return;
		}
		int s = 0;
		单链表 tempLinked = head;
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
				System.out.println("没有该元素！");
				return;
			}
		}
	}

	public void update(单链表 linke) {// 修改数据
		if (head.nest == null) {
			System.out.println("链表为空！！！");
			return;
		}
		单链表 tempLinked = head.nest;
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
			System.out.println("没有该条信息！");
		}

	}

	public void insert(单链表 l1, 单链表 l2) {// 在l1元素后添加元素l2
		if (head.nest == null) {
			System.out.println("链表为空！！！");
			return;
		}
		单链表 temp = head.nest;
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
			System.out.println("数据库没有该记录！");
		}
	}

	public void reversePrint(单链表 head) {// 逆序打印数据（用栈结构）没有改变链表结构
		if (head.nest == null) {
			return;
		}
		Stack<单链表> stack = new Stack<单链表>();// 创建栈
		单链表 sLinked = head.nest;
		while (sLinked != null) {
			stack.add(sLinked);// 栈压入数据
			sLinked = sLinked.nest;
		}
		while (stack.size() > 0) {
			单链表 nLinked = stack.pop();// 栈弹出数据
			System.out.println(nLinked);
		}
	}
}
