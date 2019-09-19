
public class My_extends {
	 String name;
	 int age;
	My_extends(){
		name="hz";
		age=10;
	};
	My_extends(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	public void Printin() 
	{
		System.out.println(name+" "+age);
	}
	
	public static void main(String[] args) {
		My_extends nb=new My_extends("海贼王", 12);
		System.out.println(nb.name+nb.age);
		ipad pid=new ipad();
		ipad pid1=new ipad("海贼王", 13);
		pid.Printin();
		System.out.println(pid1.name+" "+pid1.age);
		paid bog=new paid();
		bog.name="ash";
		bog.age=200;
		bog.mad();
	}
	
}
	
	
