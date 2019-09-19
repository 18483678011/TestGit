
public class cout extends Thread{
	public static void main(String[] args) {
		laoying l1=new laoying("老鹰");
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		l1.tsee();//调用老鹰函数tsee集成输出结果。
		
	}
}
