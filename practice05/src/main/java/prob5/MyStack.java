package prob5;

public class MyStack {
	private int top; 	//인덱스
	private String[] buffer;	//스택
	
	public MyStack(int capacity) {  // 스택의 크기: 3
		top = -1;  // 현재 배열의 크기(마지막 인덱스)
		buffer = new String[capacity];  // 크기가 3인 배열을 생성
	}
	// push
	public void push(String string) {
		if (top == buffer.length-1) {
			// push를 할 때, 스택의 자리가 없으면 늘려줘야 한다. - resize 호출
			resize();
		} else if(top < buffer.length-1) {
			top++;
			buffer[top] = string;
		}
	}
	//pop
	public String pop() throws MyStackException {
		if(isEmpty()) {
			throw new MyStackException();
		}
		
		String result = buffer[top];
		buffer[top--] = null;
		
		return result;
	}
	
	public boolean isEmpty() {
		// top == -1 인 경우, 배열이 빈 경우를 의미(return true)
		return top == -1;
	}
	
 	public void resize() {
		String[] temp = new String[buffer.length*2];
		for(int i = 0; i<=top; i++) {
			temp[i] = buffer[i];
		}
		
		buffer = temp;
	}
}