import java.util.Random;
import java.util.Scanner;

public class WeiXin_HongBao {//抢红包函数

	public static void main(String[] args) {
		System.out.println("-------------微信抢红包--------------");
		System.out.println("总金额（元）：");
		Scanner ransd = new Scanner(System.in);
		double TotalAmount = ransd.nextDouble();
		System.out.println("红包个数（个）：");
		int NumberOfRedPackets = ransd.nextInt();
		
		double Minimum=0.01;
		Random Intermediary=new Random();
		for (int i = 1; i <NumberOfRedPackets; i++) 
		{
			double max=TotalAmount-(NumberOfRedPackets-i)*Minimum;
			double bound=max-Minimum;
			
			double safe=(double)Intermediary.nextInt((int)(bound*100))/100;
			double money=safe+Minimum;
			TotalAmount=TotalAmount-money;
			System.out.println("第"+i+"个红包:"+String.format("%.2f",money)+"元");
		}
		System.out.println("第"+NumberOfRedPackets+"个红包:"+String.format("%.2f",TotalAmount)+"元"+Math.exp(2));
	}

}
