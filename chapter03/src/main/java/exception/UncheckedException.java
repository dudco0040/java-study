package exception;

public class UncheckedException {

	public static void main(String[] args) {
		int [] a = {1,2,3,4,5};
		
		for(int i = 0; i<=a.length; i++) {	// out of range error -> 이런 경우는 logic error에는 예외처리를 쓰지 않는다.
			System.out.println(a[i]);
		}
	}

}
