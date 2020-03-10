package ������;



import java.util.HashSet;

public class ���� implements Comparable<����>{  
    
    private int score;  
      
    private int age;  
      
    public ����(int score, int age){  
        super();  
        this.score = score;  
        this.age = age;  
    }  
  
    public int getScore() {  
 
        return  score;  
    }  
  
    public void setScore(int score) { 
    	
        this.score = score;  
    }  
  
    public int getAge() {  
   
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
  
    @Override  
    public int compareTo(���� o) {  
        int i = this.getScore() - o.getScore();//�Ȱ�����������  
        if(i == 0){  
            return this.score - o.getAge();//���������������÷�����������  
        }  
        return i;  
    }  
      

  
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + score;
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
		���� other = (����) obj;
		if (age != other.age)
			return false;
		if (score != other.score)
			return false;
		return true;
	}

	
@Override
	public String toString() {
		return "[score=" + score + ", age=" + age + "]";
	}

public static void main(String[] args) {  
        HashSet<����> users = new HashSet<����>();  
        users.add(new ����(78, 26));  
        users.add(new ����(78, 26));  
        users.add(new ����(67, 23));  
        users.add(new ����(34, 56));  
        users.add(new ����(55, 23));  
       // Collections.sort(users);  
        for(���� user : users){  
            System.out.println(user.getScore() + "," + user.getAge());  
        }  
}


}