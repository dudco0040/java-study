package prob5;

public class MainApp {

	public static void main(String[] args) {
		try {
			MyStack stack = new MyStack(3);  //
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");

			while (stack.isEmpty() == false) {  //stack에 값이 있을 경우, 반복
				String s = stack.pop();
				System.out.println(s);
			}

			System.out.println("======================================");

			stack = new MyStack(3);
			stack.push("Hello");

			System.out.println(stack.pop());  // "Hello"
			System.out.println(stack.pop());  // 더 이상 stack에 값이 없으므로 error 발생
			
		} catch ( MyStackException ex) {  // 에러 예외처리 - 우리가 정의한 에러
			System.out.println("error: " + ex );
		}

	}

}
