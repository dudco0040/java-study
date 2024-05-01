package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {  // "Hello World"
		/* 코드를 완성합니다 */
		char[] cs = str.toCharArray();	// string의 각 char의 값을 배열로 저장
		int n = cs.length;
		n--;
		for(int i=n; i>=0; i--) {
			cs[n-i] = str.charAt(i);  // str.charAt: 저장된 위치의 문자를 반환
		}
		
//		for(char i:cs) {
//			System.out.printf("%c", i);
//		}
		
		return cs;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		
		System.out.println(array);
		
	}
}