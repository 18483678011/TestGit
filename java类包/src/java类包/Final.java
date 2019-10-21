package java类包;

import java.util.Random;

//final 定义的是常量。

//final修饰的方法不能被重写。
//final定义的类是不能被继承的。

public class Final {
	 public void random() {
		 Random random=new Random();
		 double s=random.nextDouble()*2-1;
		 System.out.println(s);
		Integer spInteger1=new Random().nextInt(6)+1;
		Integer spInteger2=new Random().nextInt(6)+1;
		new 	sxt().name(spInteger1, spInteger2, this);
		System.out.println("123321");
	}
	 public void getint(int a,int b,int c) {
		System.out.println(a+"+"+b+"="+c);
	}
	public static void main(String[] args) {
       new Final().random();
	}

}

class sxt  {
	public void name(int a,int b,Final c) {
		int d=a+b;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		c.getint(a, b, d);
	}
	}
