package chapture04;

public class StringTest03 {
	
	public static void main(String[] args) {
		
		// String Builder
//		String s1 = "Hello" + "World" + "java" + 17;
//		new StringBuilder("Hello")
//			.append("World")
//			.append(" java")
//			.append(17)
//			.toString();
		
		// String Buffer
		String s1 = "Hello" + "World" + "java" + 17;	//  이게 왜 되는가?
		new StringBuffer("Hello")
			.append("World")
			.append(" java")
			.append(17)
			.toString();
		
		System.out.println(s1);
		
		
		String s2 = "";
		for(int i = 0; i<1000000; i++) {
//			s2 = s2 + "h";
//			s2 = new StringBuffer(s2).append("h").toString();
			// 두 코드는 같음
			// 속도가 매우 느림
		}
		
		StringBuffer sb = new StringBuffer("");
		for(int i = 0; i<1000000; i++) {
			sb.append("h");
		}
		String s3 = sb.toString();  // 반복문의 수가 클 경우, 이 방법을 사용하는 것이 더 빠르다. 
		
		
		// String methods..
		String s4 = "aBcABCabcAbc";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));	// 2번째 문자 찾기
		System.out.println(s4.indexOf("abxc"));   // 0부터 찾기
		System.out.println(s4.indexOf("abxc", 7));  // 7부터 찾기
		System.out.println(s4.substring(3));
		System.out.println(s4.substring(3, 5));  // 3~4까지 추출
		
		String s5 = "	ab	cd	";
		String s6 = "efg,hij,klm,nop,qrs";
		
		String s7 = s5.concat(s6);  // 문자열 합치기
		System.out.println(s7);
		System.out.println(s5.trim());  // trim(): 처음과 끝의 space 없애기
		System.out.println(s5.replaceAll(" ", ""));  // space 공백으로 대체(all)  
		
		
		//tokens
		String[] tokens = s6.split(",");
		for(String s: tokens) {
				System.out.println(s);
		}
		String[] tokens2 = s6.split(",");
		for(String s: tokens2) {
				System.out.println(s);
		}
	}
	
}

// 주로 1번째처럼 사용하지만,
// 2번쨰 경우처럼 명시적으로 사용해야 할 때가 있음 (4/26)

// String Builder, String Buffer 결과가 같음 (4/29)