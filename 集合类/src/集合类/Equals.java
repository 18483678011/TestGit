package 集合类;

public class Equals implements Comparable<Object>  {
	public int compareTo(String anotherString) {
		return name.compareTo(anotherString);
	}

	private String name;
	private String mmm;
	private int age;

	public Equals(String name, int age) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((mmm == null) ? 0 : mmm.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public int compareTo(Object o) {// 用于TreeSet 排序     ArrayList排序等
		Equals jd = (Equals) o;
		if (this.age > jd.age) {
			return 1;
		}
		if (this.age == jd.age) {
			return 0;
		} else
			return -1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equals other = (Equals) obj;
		if (age != other.age)
			return false;
		if (mmm == null) {
			if (other.mmm != null)
				return false;
		} else if (!mmm.equals(other.mmm))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	

}