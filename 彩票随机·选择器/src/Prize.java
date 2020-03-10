import java.util.Random;

public class Prize {

	public static void sotr(int[] arr) {
		int temp,x;
		for (x = 0; x < arr.length - 1; x++) {
			for (int y = 0; y < arr.length - 1 - x; y++) {
				if (arr[y] > arr[y + 1]) {
					temp = arr[y];
					arr[y] = arr[y + 1];
					arr[y + 1] = temp;
				}
			}
		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Random prize = new Random();
		int[] s = new int[6];
		int obt = 0;
		while (obt < s.length) {
			boolean flag = true;
			int r = prize.nextInt(33) + 1;
			for (int i = 0; i < s.length; i++) {
				if (r == s[i]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				s[obt] = r;
				obt++;
			}
		}
		int outs = 0;
		obt = 0;
		while (obt < 1) {
			boolean flag = true;
			int r = prize.nextInt(16) + 1;
			for (int i = 0; i < s.length; i++) {
				if (r == s[i]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				outs = r;
				obt++;
			}
		}
		sotr(s);
		System.out.print("ºìÇò£º");
		for (int st : s) {
			System.out.print(st + "    ");
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		
		System.out.print("À¶Çò£º" );
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(outs);
		
	}
}
