
public class cout extends Thread{
	public static void main(String[] args) {
		laoying l1=new laoying("��ӥ");
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		l1.tsee();//������ӥ����tsee������������
		
	}
}
