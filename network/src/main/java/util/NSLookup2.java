package util;

import java.util.Scanner;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup2 {

	public static void main(String[] args) {
		// java version
		// 유틸리티 함수
		
		 try {
			 // 이름으로 inetAddress 찾겠다.
			 // 하나의 이름에 여러 개의 IP를 할당할 수 있음
			 // IP에 여러 이름을 할당하는 것도 가능
			 // 여러 개 일 경우, 배열로 나온다 ?? 
			 while(true) {
				 	System.out.print("> ");
					Scanner scan = new Scanner(System.in);
					String domain = scan.nextLine();
					// System.out.println(domain);
				 	InetAddress[] inetAddresses = InetAddress.getAllByName(domain);
	
		            for (InetAddress address : inetAddresses) {
		            	System.out.println(address.getHostName() + ": " + address.getHostAddress());
		            	}
		            
		            if(domain == "exit") {
		            	break;
		            }
			 	}
			
		 	} catch (UnknownHostException e) {
		 		e.printStackTrace();	
		 	}
	
	}

}


// to do 과제