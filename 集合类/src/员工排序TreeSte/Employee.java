package Ա������TreeSte;

import java.util.Date;

public class Employee implements Comparable<Employee> {
	private String name;
	private Integer age;
	private MyDate birthday;
	private Date data;

	public int getages(MyDate birthday) {
		data = new Date();
		Integer ag1 = Integer.parseInt(String.format("%tY", data));// ��stringת��ΪInteger���ͣ���ȡ�������
		Integer ag2 = birthday.getYear();// ��ȡ�������
		return ag1 - ag2;// ��ȡ����
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Employee(String name, MyDate birthday) {
		super();
		this.name = name;
		this.age = getages(birthday);// ������ getages();
		this.birthday = birthday;
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

	public MyDate getBirthday() {
		return birthday;
	}

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return " [name= " + name + ",  age= " + age + ", birthday= " + birthday.toString() + "]";
	}

	public Employee() {
		super();
	}

	@Override
	public int compareTo(Employee o) {
		Integer result = 0;
		if (o instanceof Employee) {
			Employee new_name = (Employee) o;// ��������ʱ�併��
			result = this.age.compareTo(new_name.age);
			if (0 == result) {// �������ʱ����ͬ �Ͱ�����������������
				result = this.birthday.getMonth() - new_name.birthday.getMonth();
				if (0 == result) {// �����������ͬ �������ֽ�������
					result = this.birthday.getDay().compareTo(new_name.birthday.getDay());
				}
			}
		}
		return result;
	}

}
