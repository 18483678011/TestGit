import java.util.Date;
import java.util.Scanner;


public class aidk {
	    
	    public static void main(String[] args) {
	    	
	    	Date on=new Date();
	    	String time=String.format("%tF", on);
	    	System.out.println("�����Ǳ���ʱ�䣺"+time);
	        Scanner scc = new Scanner(System.in);//ɨ��
	        System.out.print("���ļ��е��ַ���");
	        String str = scc.nextLine();
	        char c = str.charAt(0);
	        String x=new String("����.��.��.��");
	        int size=x.indexOf('��');
	        		System.out.println(x+size);
	        		String[] ss=x.split("\\.",1);
	        		for(String s:ss)
	        			System.out.print(s);
	        System.out.println(c + "�滻Ϊ��" + (int) c);
	    }

}

