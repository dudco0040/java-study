package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		n = 10;
	}
	void f2() {
		StaticMethod.m = 10;
		
		// 같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능
		m = 20;
	}
	void f3() {
		f2();
	}
	void f4() {
		StaticMethod.s1();
		s1();
		
	}
	static void s1() {
//		n = 10; // 객체가 지정되어있지 않음 
//		error static method 에서는 instance 변수에 접근이 불가..
		
	}
	static void s2() {
//		error static method 에서는 instance 메소드에 접근이 불가..
//		f1();
	}
	static void s3() {
		StaticMethod.m = 10;
		//같은 클래스의 클래스 변수 접근에서는 클래스 이름 생략 가능
		m = 10;
		
	}
	static void s4() {
		// 같은 클래스의 클래스 메소드 접근에서는 클래스 이름 생략 가능
		s1();
	}
}
