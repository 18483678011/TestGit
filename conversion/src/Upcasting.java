
public class Upcasting {

	public static void main(String[] args) {
		People l1 = new People("张三", 12);
		l1.out();
		People l2 = new Doctor("李四", 30);
		l2.out();
		Doctor l3 = (Doctor) l2;
		l3.out();
		boolean bool=l1 instanceof People;
		System.out.println(bool);	
		}
	}


