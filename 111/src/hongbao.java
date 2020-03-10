import java.math.BigDecimal;
import java.util.Scanner;

public class hongbao {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入总金额（元）：");
		double totalMoney = sc.nextDouble();
		System.out.println("请输入获取红包人数（元）：");
		int personNum = sc.nextInt();
		double[] allocationMoney = new double[personNum];
		for (int i = personNum; i > 1; i--) {
			// double surplusMoney = totalMoney - ( i - 1 ) * 0.01;
			// 安全线
			double surplusMoney = (totalMoney - (i - 1) * 0.01) / (i / 2);
			// 设surplusMoney为15，1、获取[0,1500)随机数，2、获取
			// [1,1500]随机数，3、获取[0.01,15.00]随机数
			double randomlyAssignedMoney = ((int) (Math.random() * surplusMoney * 100) + 1) * 0.01;
			// 截取小数点后两位输出
			BigDecimal aBigDecimal = new BigDecimal(randomlyAssignedMoney);
			double moneyOfOnePerson = aBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out.println("第"+(personNum-i+1)+"个红包: "+moneyOfOnePerson+"元");
			totalMoney -= randomlyAssignedMoney;
			allocationMoney[i - 1] = randomlyAssignedMoney;
		}
		BigDecimal bg = new BigDecimal(totalMoney);
		double remainingMoney = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println("第"+personNum+"个红包: "+remainingMoney+"元");
		allocationMoney[0] = remainingMoney;
		double checkTotalMoney = 0;
		for (int i = 0; i < personNum; i++) {
			checkTotalMoney += allocationMoney[i];
		}
		//System.out.println(checkTotalMoney);
	}
}
