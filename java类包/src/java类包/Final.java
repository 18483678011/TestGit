package java类包;
//final 定义的是常量。
//final修饰的方法不能被重写。
//final定义的类是不能被继承的。

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