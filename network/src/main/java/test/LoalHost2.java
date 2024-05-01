package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LoalHost2 {

	public static void main(String[] args) {
		try {
			// 객체 생성
			InetAddress inetAddress = InetAddress.getLocalHost();
			System.out.println(inetAddress);  // BIT/192.168.0.81
			
			String hostName = inetAddress.getHostName();  			// PC Name: BIT
			String hostIpAddress = inetAddress.getHostAddress();  	// IP Address: 192.168.0.81
			System.out.println("Host Name: "+ hostName);
			System.out.println("Host IP Address: "+ hostIpAddress);
			
			// Byte 단위로 저장해서 출력
			byte[] IpAddresses = inetAddress.getAddress();
			for(byte IpAddress:IpAddresses) {
				System.out.println(IpAddress);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
