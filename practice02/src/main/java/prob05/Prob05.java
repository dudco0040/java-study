package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		
			
		while( true ) {
			int min = 0;
			int max = 100;
			/* 게임 작성 */
			
			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			//System.out.println("정답" + correctNumber);
			System.out.println("수를 결정하였습니다. 맞춰보세요!");
			
			// 1-100
			System.out.println(min + "-" + max);
			System.out.print(">>");
			
			int number = scanner.nextInt();
			
			//무한루프
			while(true) {
				// 1~100 범위를 알려주고, private 
				if(number < correctNumber) {
					System.out.println("더 높게! ");
					min = number;
					System.out.println(min + "-" + max);
					System.out.print(">>");
					number = scanner.nextInt();
					
				} else if (number > correctNumber) {	
					System.out.println("더 낮게! ");
					max = number;
					System.out.println(min + "-" + max);
					System.out.print(">>");
					number = scanner.nextInt();
					
				} else {
					System.out.println("정답입니다!");
					break;
				}
			}

			
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( answer.equals("n")) {
				break;
//			} else if( (answer.equals("n") && answer.equals("y")) == false) {
//				System.out.println("다시 입력해주세요. (y/n)");
//				answer = scanner.next();
//				
			}
		}
		
		scanner.close();
	}

}