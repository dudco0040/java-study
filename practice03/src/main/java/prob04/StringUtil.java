package prob04;

public class StringUtil {
	public static String concatenate(String[] str) {	// 배열 타입의 파라미터 받기
		// 문자열을 결합하여 리턴하는 메소드 구현
		
		// 문자열 사용(concatenate)
		String result = "";
		
		for(int i = 0; i< str.length; i++){
			result = result.concat(str[i]);
			
		}
		
		// StringBuffer 사용(append)
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < str.length; i++) {
			sb.append(str[i]);
		}
		String result2 = sb.toString();
		
		
		return result2; // result1 OR result2
	}
}

//concatenate 메소드 완성하기