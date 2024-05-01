package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhost {
	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();  // getLocalhost를 사용하여 객체를 얻음 - ip address가 들어있음
			String hostName = inetAddress.getHostName();   // 컴퓨터의 이름 
			String hostIPAddress = inetAddress.getHostAddress();  // IP Address 뽑기 - String으로 저장
			
			System.out.println(hostName);
			System.out.println(hostIPAddress); 
			
			byte[] IpAddresses = inetAddress.getAddress();   // 바이트 단위로 저장
			for(byte IpAddress: IpAddresses) {
				System.out.println(IpAddress);  // -88
				System.out.println(IpAddress & 0x000000ff);  // 168
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
