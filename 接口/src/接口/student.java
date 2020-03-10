package 接口;

import com.Jeikou.Comparable1;

public class student implements Comparable1 {

	@Override
	public int compareTo(Object obj) {// 数字接口函数Comparable1。
		student olbst = (student) obj;
		return this.age - olbst.age;
	}

	public int name(Object obj) {
		student olbst = (student) obj;
		return this.name.compareTo(olbst.name);// 调用字符时，调用的string中的compareTo比较大小。
	}

	private String name;// 名字
	private int age;// 年龄
	private double score;// 成绩

	public student() {// 构造方法1
		super();
	}

	public student(String name, int age, double score) {// 构造方法2
		super();
		this.name = name;
		this.age = age;
		this.score = score;
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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {// 输出结构
		return "student: [name=" + name + ", age=" + age + ", score=" + score + "]";

	}

}
