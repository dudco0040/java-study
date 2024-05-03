package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	// port 번호 
	public static final int PORT_NO = 7000;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<Writer> listWriters = new ArrayList<Writer>();  // PrintWriter를 담을 list 생성 - 쓰는 친구
		//
		
		try {
			// 서버의 기능
			// 1. socket 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩(binding)
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT_NO), 10);   // server의 ip, port - client에서 요청을 위해 제공하는 주소 
			
			// 3. 요청대기(accept)
			while(true) {
				Socket socket = serverSocket.accept();  // connect 대기 - blocking
				// 소켓을 RequestHandler로 전달 
				new ChatServerThread(socket, listWriters).start();  //스레드 시작 - 
			}
			
			
		} catch (IOException e) {
			log("error message:"+ e);
		} finally {
			
			try {
				// server socket이 생성되지 않은 경우 & 닫히지 않는 경우 
				if(serverSocket == null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			}catch (IOException e) {
					e.printStackTrace();
			
			}
		}
	}
	
	
	public static void log(String message) {
		System.out.println("[Chat Server] error: " + message);
	}

}
// accept - echo server 복사애서  
// list 만들기?
// 