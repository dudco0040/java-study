package prob1;

import java.util.Arrays;

public class Sort {
	static int num1 = 0;
	static int num2 = 0;
	
	public static void main(String[] arg) {
	
		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int count =  array.length;

		
		System.out.println( "Before sort." );
		System.out.println(Arrays.toString(array));

		
		// 정렬 알고리즘이 적용된 코드를 여기에 작성합니다.
		for(int i = 0; i < count-1; i ++) {
			for(int j = 0; j < count-1; j ++) {
				if(array[i] < array[j]) {
					change(array[i],array[j]);
				}
			}
		}
		System.out.println(num1);
		// 결과 출력
		System.out.println("\nAfter Sort." );
		System.out.println(Arrays.toString(array));
	}
	
	public static void change(int a, int b) {
		int temp = a;
		num1 = b;
		num2 = temp;
	}
}