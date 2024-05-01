package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer2 {
	public static final int PORT = 6000;   // port 번호 바꿀 때 변경
	
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null; 
		
		try {
			// 1. 소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 소켓 바인딩(binding)
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT), 10);
			
			// 3. Accept - 연결 대기
			Socket socket = serverSocket.accept();  // blocking
			
			try {
				// 연결 완료 후, 서버 정보 출력
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();  // 다운 캐스팅 
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress(); // inetAddress 객체
				int remotePort = inetRemoteSocketAddress.getPort();
				log("[server] connected by client [" + remoteHostAddress + remotePort + "]");
				
				// 4. IO 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				// **
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf=8"), true);  //버퍼가 꽉 차야 output으로 나감
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf=8"));
				
				while(true) {
					String data = br.readLine();   //blocking - Client 에서 개행 문자까지 보내야 blocking이 풀릴 것 
					if(data == null) {   // String  - null
						System.out.println("[server] closed by client");
						break; // 더 읽을 것이 없으므로 반복문 종료
					}
					log("recived: "+ data);  // 서버에 로그 남기기
					pw.println(data);
				}
				// ** 
			} catch(SocketException e) {
				log("suddenly closed by client");
			} catch(IOException e) {
				log(" error:" + e);
			}finally {
				try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
				
				}
			}
			
		} catch (IOException e) {
			log("error" + e);
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
	private static void log(String message) {
		System.out.println("[EchoServer] "+ message);
		
	}
}
