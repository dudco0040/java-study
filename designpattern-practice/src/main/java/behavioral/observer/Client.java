package behavioral.observer;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Subject<Integer> intSubject = new Subject<>();
		
		intSubject.registerObserver(new Observer<Integer> () {
			@Override
			public void update(Integer val) {
				System.out.println("Observer01: "+val);	
			}
		});
		
		intSubject.registerObserver((val) -> System.out.println("Observer02: "+val));
		// lambda 함수 y = f(x), x = Integer
		// 함수가 객체로 들어간 것은 아님 - 컴파일러가 추론해서 문법상으로 이렇게 사용한 것
		// 이런 코드가 필요한 경우가 있음
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println(">> ");
			int val = scanner.nextInt();
			intSubject.changeSubject(val);
		}
	}

}
