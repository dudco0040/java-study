package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer3 {

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

			try {
				// *
				// IP 주소 & PORT 번호 받기
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();  // ip 주소, port 번호
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				System.out.println("[server] connected by client: " + remoteHostAddress + ":" + remotePort);
				
				// 4. IO 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				while(true) {
					// 5. 데이터 읽기 (input)
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer);  // inputStream read
					// 정상 종료
					if(readByteCount==-1) {
						System.out.println("[server] Success closed by client..");
						break; 
					}
					
					String data = new String(buffer, 0, readByteCount, "UTF-8");   //encoding
					System.out.println("[server] recived: " + data);
					
					// 6. 데이터 쓰기 (output)
					os.write(data.getBytes("UTF-8"));
					
				}
				// * socket, io 예외처리
			} catch(SocketException e) {
				System.out.println("[server] suddenly closed by client! ");
			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				if (socket != null && !socket.isClosed()) {   // 위에 null 로 초기값 설정을 하지 않는데 왜 여기서 이렇게 쓰지???
					socket.close();
				}
			}
			
				
		
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
