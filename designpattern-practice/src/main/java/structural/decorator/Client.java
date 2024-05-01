package structural.decorator;

public class Client {

	public static void main(String[] args) {
		System.out.println(new ConcretComponent("Hello World").operation());
		System.out.println(new BracesDecorator(new ConcretComponent("Hello World")).operation());
		System.out.println(new ParenthesesDecorator(new BracesDecorator(new ConcretComponent("Hello World"))).operation());

		System.out.println(new ParenthesesDecorator(new ConcretComponent("Hello World")).operation());
		System.out.println(new BracesDecorator(new ParenthesesDecorator(new ConcretComponent("Hello World"))).operation());
	}

}


// 주스트림이 "hello world"를 보내줌
// 괄호, 대괄호를 추가해주는 데코레이터 작업을 할 것.