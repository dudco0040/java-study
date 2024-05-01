package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];		// Goods 클래스의 배열 - COUNT_GOOS의 크기만큼 공간을 미련
		// 상품 입력 
		for(int i = 0; i< COUNT_GOODS; i++) {
			String input = scanner.nextLine();  	// 형식: 제품명 가격 수량
			
			String[] inputArr = input.split(" ");	// 각 값을 배열에 저장
			String name = inputArr[0];
			int price = Integer.parseInt(inputArr[1]);
			int count = Integer.parseInt(inputArr[2]);
			
			Goods g = new Goods(); 		//실제로 객체를 선언을 해줌
			// 메소드 호출해서 set 값을 업데이트
			g.setName(name);
			g.setPrice(price);
			g.setCount(count);
			
			goods[i] = g;		// 배열에 각 클래스 결과를 대입
			// System.out.println(goods);
		}

		// 상품 출력
		for (Goods g:goods) {
			
			System.out.println(g.getName() + "(가격:" + g.getPrice() + ")이 " + g.getCount() + "개 입고 되었습니다.");
		}
		
		// 자원정리
		scanner.close();
	}
}

//Goods를 구현하는 문제 
//reference array