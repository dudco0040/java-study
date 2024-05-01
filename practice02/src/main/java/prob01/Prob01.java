package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		/* 코드 작성 */
		System.out.print("금액: ");
        int amount = scanner.nextInt();

        System.out.println("입력한 금액: " + amount);

        for (int money : MONEYS) {
            if (amount >= money) {
                int count = amount / money;
                System.out.println(money + "원: " + count + "개");
                amount %= money; // 나머지 금액 계산
            }
        }
        
//		int price = scanner.nextInt();
//		int change = 0;
//		
//		while(change == 1) {
//			
//		}
		
		scanner.close();
 	}
}