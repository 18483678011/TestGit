package 设计模式;

public class 单例模式2 {
	public static void main(String[] args) {
		RUN ds = RUN.getInstance();
		RUN ds1 = RUN.getInstance();
		ds.name(51);
		ds.getage();
		ds1.name(55);
		ds1.getage();
	}
}
class RUN{
	
	private int age;

	private RUN() {
	}

	private static class SingletonInstance {
		private static final RUN INSTANCE = new RUN();
	}

	public static RUN getInstance() {
		return SingletonInstance.INSTANCE;
	}

	public void name(int s) {
		age = s;
	}

	public void getage() {
		System.out.println(age);
	}
}
