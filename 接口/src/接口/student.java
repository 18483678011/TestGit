package �ӿ�;

import com.Jeikou.Comparable1;

public class student implements Comparable1 {

	@Override
	public int compareTo(Object obj) {// ���ֽӿں���Comparable1��
		student olbst = (student) obj;
		return this.age - olbst.age;
	}

	public int name(Object obj) {
		student olbst = (student) obj;
		return this.name.compareTo(olbst.name);// �����ַ�ʱ�����õ�string�е�compareTo�Ƚϴ�С��
	}

	private String name;// ����
	private int age;// ����
	private double score;// �ɼ�

	public student() {// ���췽��1
		super();
	}

	public student(String name, int age, double score) {// ���췽��2
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
	public String toString() {// ����ṹ
		return "student: [name=" + name + ", age=" + age + ", score=" + score + "]";

	}

}
