package com.Jeikou;

public class cptr implements Comparable1 {
	private String name1;// Ãû×Ö
	private int age1;// ÄêÁä
	private double score1;// ³É¼¨

	public cptr(String name1, int age1, double score1) {
		super();
		this.name1 = name1;
		this.age1 = age1;
		this.score1 = score1;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public int getAge1() {
		return age1;
	}

	public void setAge1(int age1) {
		this.age1 = age1;
	}

	public double getScore1() {
		return score1;
	}

	public void setScore1(double score1) {
		this.score1 = score1;
	}

	@Override
	public int name(Object obj) {
		cptr ilst = (cptr) obj;
		return this.age1 - ilst.age1;
	}

	@Override
	public String toString() {
		return "cptr [name1=" + name1 + ", age1=" + age1 + ", score1=" + score1 + "]";
	}

	@Override
	public int compareTo(Object obj) {

		return 0;
	}

}
