package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer2 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;  // 초기값 null 입력
		
		try {
			// 1. server socket 생성
			serverSocket = new ServerSocket();  // 소켓 생성
			System.out.println("Success Create Socket...");
			
			// 2. 바인딩(binding)
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5010), 10);
			System.out.println("Success Binding...");
			
			// 3. Accept
			Socket socket = serverSocket.accept();  // blocking - port 열고 대기 상태 (연결 전까지 다음 코드가 실행되지 않음)
			System.out.println("Success Connection...");

			
		} catch (IOException e) {
			System.out.println("[server] error: " + e);
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {  // 소켓 생성 완료 && 소켓이 닫히지 않은 경우
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
