import java.util.Random;
import java.util.Scanner;

public class WeiXin_HongBao {//���������

	public static void main(String[] args) {
		System.out.println("-------------΢�������--------------");
		System.out.println("�ܽ�Ԫ����");
		Scanner ransd = new Scanner(System.in);
		double TotalAmount = ransd.nextDouble();
		System.out.println("���������������");
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
			System.out.println("��"+i+"�����:"+String.format("%.2f",money)+"Ԫ");
		}
		System.out.println("��"+NumberOfRedPackets+"�����:"+String.format("%.2f",TotalAmount)+"Ԫ"+Math.exp(2));
	}

}
