package chapture04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		String s = "123456";
		int i = Integer.parseInt(s);
		
		
		//cf1. 반대로
		String s1 = String.valueOf(i);
		
		//cf2. 반대로
		String s2 = "" + i;
		
		System.out.println(s+ ":" + s1 + ":" +s2);
		
		int a = Character.getNumericValue('A');
		System.out.println(a);
		
		//cf: ASCII 코드 값
		char c = 'A';
		System.out.println((int)c);
		
		//2진수
		String s4 = Integer.toBinaryString(-15); // 2진수는 String으로 만들어야함
		System.out.println(s4);
		// 정수가 메모리와 디스크에 어떻게 저장되는가? 
		
		//16진수
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
		
	}

}
