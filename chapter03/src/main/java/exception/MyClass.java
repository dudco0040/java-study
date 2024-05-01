package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException, MyException{  // IOException과 MyException을 던질 수 있다고 선언
		System.out.println("some code1...");
		System.out.println("some code2...");
		
		if(2 - 2 == 0) {
			throw new MyException();
		}
		
		if(1 - 1 == 0) {
			throw new IOException();
		}
		
		System.out.println("some code3...");
		System.out.println("some code4...");
	}
}
