package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;


public class ChatClient {

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null; 
		
		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);
			
			// 2. socket 생성
			socket = new Socket();
			
			// 3. 연결
			socket.connect(new InetSocketAddress("", ChatServer.PORT_NO));
			
			// 4. reader/writer 생성
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			
			// 5. join 프로토콜 
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();   // 닉네임 입력
			pw.println("join:" + nickname);  		// pw로 서버에 전송  
			// printWriter.flush(); // 보내준다. 
			// br 읽으세요
			String data = br.readLine();
			
			// 입장 알림을 출력 - "join:ok"일 경우 welcome 메세지 출력
			if("join:ok".equals(data)) {
				System.out.println("입장하였습니다. 즐거운 채팅 되세요.");
			}
			pw.flush();
			
			// 6. ChatClientThread 시작
			new ChatClientThread(socket).start(); // 스레드를 시작 
//			new ChatClientThread(socket, br).start(); // 스레드를 시작 
			// 7. 키보드 입력 처리 
			while(true) {
				String input = scanner.nextLine();  // 채팅 입력
				// 퇴장 
				if("quit".equals(input) == true) {
					// 8. 프로토콜 처리 - 우리가 정한 규칙!
					pw.println("quit:");
					break;
				} else {
					// 9. 메세지 처리
					pw.println("message:" + input);
				}
			}
		
		// socket exception
		} catch(IOException ex) {
			log("(Client IO Exception 1) " + ex);
			
		} finally {
			// 10. 자원정리
			try {
				
				if(socket!=null && !socket.isClosed()) {
					socket.close();
					scanner.close();
				}
			} catch (IOException e) {
				log("(Client IO Exception 2) " + e);
			}
		}
	}
	
	public static void log(String message) {
		System.out.println("[Client] " + message);
	}
}

// 닉네임 입력 받고 연결해서 join 하고 성공하면 파이프라인 해서 버퍼로 스레드에 넘겨주고 read만 함