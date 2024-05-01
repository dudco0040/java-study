package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		//next integer로 변수 받기 
		/* 코드 작성 */
		System.out.printf("숫자를 입력하시오 : ");
		int num = scanner.nextInt();
		
//		answer = 0
//		if num % 2==0:
//			for i in range(num):
//				if i%2 ==0:
//					answer+=i
//		else:
//			for i in range(num):
//				if i%2 != 0:
//					answer+=i
//		print('결과 값 :{}'.format(i))
		
		int answer = 0;
		if(num%2==0) {  //짝수
			for(int i=1;i<num+1;i++) {
				if(i%2==0) {
					answer+=i;
				}
			}
			System.out.println("결과 값 : "+ answer);
		}else {  //홀수
			for(int i=1;i<num+1;i++) {
				if(i%2!=0) {
					answer+=i;
				}
			}
			System.out.println("결과 값 : "+ answer);
		}
		scanner.close();
	}
}
