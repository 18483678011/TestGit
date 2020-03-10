package ½Ó¿Ú;

public class jast {
private String name;
private int age;
private double score1;
@Override
public String toString() {
	return "jast [name=" + name + ", age=" + age + ", score1=" + score1 + "]";
}
public double getScore1() {
	return score1;
}
public jast(String name, int age, double score1) {
	super();
	this.name = name;
	this.age = age;
	this.score1 = score1;
}
public void setScore1(double score1) {
	this.score1 = score1;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + age;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}


public jast(String name, int age) {
	super();
	this.name = name;
	this.age = age;
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

}
