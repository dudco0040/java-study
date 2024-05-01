package prob03;

public class Prob03 {
	public static void main(String args[]) {
		char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.' };
		
		// 원래 배열 원소 출력
		printCharArray(c);

		// 공백 문자 바꾸기
		replaceSpace(c);

		// 수정된 배열 원소 출력
		printCharArray(c);

		// 배열 c를 메소드의 매개변수로 전달
	}
	// method
	public static void replaceSpace(char a[]) {		//공백 대체
		for(int i = 1; i < a.length; i++) {
			if(a[i] == ' ') {
				a[i] = ',';
			}	
		}
	}
	public static void printCharArray(char a[]) {	//수정된 배열 원소 출력
		System.out.println(a);
		
	}

}
