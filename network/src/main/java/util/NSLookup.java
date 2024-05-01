package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

	public static void main(String[] args) {
		// java version
		// 유틸리티 함수
		
		try {
			InetAddress[] inetAddresses = InetAddress.getAllByName("www.naver.com");  // 받는걸 짜라? - 스캐너 이용해서?
			
			
			
			// 이름으로 inetAddress 찾겠다.
			// 하나의 이름에 여러 개의 IP를 할당할 수 있음
			// IP에 여러 이름을 할당하는 것도 가능
			// 여러 개 일 경우, 배열로 나온다 ?? 
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

	}

}


// to do 과제