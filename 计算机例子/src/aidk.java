import java.util.Date;
import java.util.Scanner;


public class aidk {
	    
	    public static void main(String[] args) {
	    	
	    	Date on=new Date();
	    	String time=String.format("%tF", on);
	    	System.out.println("现在是北京时间："+time);
	        Scanner scc = new Scanner(System.in);//扫描
	        System.out.print("输文件中的字符：");
	        String str = scc.nextLine();
	        char c = str.charAt(0);
	        String x=new String("锄禾.日.当.午");
	        int size=x.indexOf('日');
	        		System.out.println(x+size);
	        		String[] ss=x.split("\\.",1);
	        		for(String s:ss)
	        			System.out.print(s);
	        System.out.println(c + "替换为：" + (int) c);
	    }

}

