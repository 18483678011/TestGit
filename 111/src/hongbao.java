import java.math.BigDecimal;
import java.util.Scanner;

public class hongbao {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������ܽ�Ԫ����");
		double totalMoney = sc.nextDouble();
		System.out.println("�������ȡ���������Ԫ����");
		int personNum = sc.nextInt();
		double[] allocationMoney = new double[personNum];
		for (int i = personNum; i > 1; i--) {
			// double surplusMoney = totalMoney - ( i - 1 ) * 0.01;
			// ��ȫ��
			double surplusMoney = (totalMoney - (i - 1) * 0.01) / (i / 2);
			// ��surplusMoneyΪ15��1����ȡ[0,1500)�������2����ȡ
			// [1,1500]�������3����ȡ[0.01,15.00]�����
			double randomlyAssignedMoney = ((int) (Math.random() * surplusMoney * 100) + 1) * 0.01;
			// ��ȡС�������λ���
			BigDecimal aBigDecimal = new BigDecimal(randomlyAssignedMoney);
			double moneyOfOnePerson = aBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out.println("��"+(personNum-i+1)+"�����: "+moneyOfOnePerson+"Ԫ");
			totalMoney -= randomlyAssignedMoney;
			allocationMoney[i - 1] = randomlyAssignedMoney;
		}
		BigDecimal bg = new BigDecimal(totalMoney);
		double remainingMoney = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println("��"+personNum+"�����: "+remainingMoney+"Ԫ");
		allocationMoney[0] = remainingMoney;
		double checkTotalMoney = 0;
		for (int i = 0; i < personNum; i++) {
			checkTotalMoney += allocationMoney[i];
		}
		//System.out.println(checkTotalMoney);
	}
}
