package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null; 
		
		try {
			// 1. server socket 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩 - 소켓의 주소(InetSocketAddress[InetAddress(IPAdress)+port])를 binding
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 4000), 10);   // (IP, port), backlog
			
			// 3. Accept
			Socket socket = serverSocket.accept();  // blocking
			try {
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();  // 다운 캐스팅 
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress(); // inetAddress 객체
				int remotePort = inetRemoteSocketAddress.getPort();
				System.out.println("[server] connected by client [" + remoteHostAddress + remotePort);
				
				// 4. IO Stream 받아오기
				
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				// 5. 데이터 읽기  - 기본적인 소켓 통신은 바이트 - 편의를 위해 데코레이터 사용(string으로 할 필요없으면 필요 X) 
				while(true) {	// 서버는 무한 루프 
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer);  //blocking
				
					if(readByteCount == -1) {   //  명시적으로 소켓 close()를 호출 - 클라이언트가 정상적인 종료
						System.out.println("[server] closed by client");
						break; // 더 읽을 것이 없으므로 반복문 종료
					}
					
					// encoding
					String data = new String(buffer, 0, readByteCount, "UTF-8"); 
					System.out.println("[server] resived:" + data);
				
					
				// 6. 데이터 쓰기
					os.write(data.getBytes("utf-8"));
				}
				
			} catch(SocketException e) {
				System.out.println("[server] suddenly closed by client");
			} catch(IOException e) {
				System.out.println("[server] error:" + e);
			}finally {
				try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
				
				}
			}
			
		} catch (IOException e) {
			System.out.println("[server] error" + e);
		} finally {
			
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
				
			}
		
		}
	}

}
