package java���;
//final ������ǳ�����
//final���εķ������ܱ���д��
//final��������ǲ��ܱ��̳еġ�

public class Final {
	 final int AUTO=100;
	 private final void miae() {
		 System.out.println("123...");
	 }
	 
	
public static void main(String[] args) {
	Final s=new sxt();
	sxt c=(sxt)s;
	c.name();
	sxt x=new sxt();
	Final uio=x;
	uio.miae();
}


}
    class sxt extends Final{
    	public final void miae() {
   		 System.out.println("456...");
   	 }
    	public void name() {
    		miae();
		}
    }                  