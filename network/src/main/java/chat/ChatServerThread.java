package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	List<Writer> listWriters;
	
	BufferedReader br = null;
	PrintWriter pw = null;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}	
	
	@Override
	public void run() {
		// 실행할 내용
		try {
			// 1. Remote Host Information
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			System.out.println("[server] connected by client [" + remoteHostAddress + remotePort + "]");
			
			
			// 2. Stream 얻기
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));  	// pw가 입력한 것을 br로 받음
 			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true); 	// Client -> Server (socket 입력)
			
			// 3. 요청 처리
			while(true) {
				String request = br.readLine();  // socket에서 입력 pw 입력한걸 br로 받음 
				
				if(request == null) {
					ChatServer.log("Closed by Clent...");  // ctrl+c
					doQuit(pw);
					break;
				}
				
				// 4. 프로토콜 분석
				// consoleLog(request)  // request = "join:nickname\r\n"
				String[] tokens = request.split(":");
				
				if ("join".equals(tokens[0])) {  // quals
					// 입장
					doJoin(tokens[1], pw);  // br 개행 포함 문제 
					
				} else if ("message".equals(tokens[0])) {
					// 메세지 보내기
					doMessage(tokens[1]); // 메세지 내용 보내기
					// 발신자를 포함하여 본인, 다른 채팅방에 발송
					
				} else if ("quit".equals(tokens[0])) {
					// 퇴장
					 doQuit(pw);
					 ChatServer.log("Closed by Clent...");
					 break;
					// 상대방에게 퇴장 알림 
					// Socket Exception 활용 - 비정상 종료 => 여기 말고 else 에 위치??
					
				} else {
					// 그 이외의 요청
					ChatServer.log("Error: 알 수 없는 요청 (" + tokens[0] + ")");
				}
				
			}
			
			
		} catch(SocketException e) {
			// 그냥 나갔을 때 
			// 상대방 client thread에 나감 메세지 전송
			doQuit(pw);
//			ChatServer.log("(Server Thread Socket Exception) " + e);
			ChatServer.log("시스템이 비정상 종료되었습니다. (" + e + ")");

			
		} catch(IOException e) {
			ChatServer.log("(Server Thread IOException 1) " + e);
			
		} finally {
			
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			}catch (IOException e) {
				ChatServer.log("(Server Thread IOException 2) " + e);
				
			}
			
		}
		
	}
	
	
	// 입장 
	private void doJoin(String nickname , Writer writer) {  // nickname, pw
		// nickname 입력
		// welcome 메세지 & 다른 채팅방에 입장 알림
		this.nickname = nickname;
		
		String data = nickname + "님이 참여하였습니다.";
		broadcast(data);  	// 알림!
		
		/* write pool에 저장하기*/
		addWriter(writer);  // pw의 모음 리스트 저장
		
		// ack - 입장이 된 경우, 채팅 가능을 알린다.
		pw.println("join:ok");		// pw -> writer
		pw.flush();
	}
	
	private void addWriter(Writer writer) {
		synchronized(listWriters) {   // 여러 스레드가 하나의 공유 객체에 접근할 때, 동기화를 보장해준다. 
			listWriters.add(writer);
		}
	}
	
	// 알림
	private void broadcast(String data) { 
		synchronized(listWriters) {
			
			for(Writer writer:listWriters) {   // 실제 출력이 아니야
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);  // 보내?
				printWriter.flush();
			}
		}
	}
	
	// 메세지
	private void doMessage(String message) {  //tokens[1]
		// *** 메세지 보내기
		String data = nickname + ":" + message;
		// ** 브로드케스팅으로 모두 알 수 있게 - 형식 발신자 포함
		broadcast(data);
	
			
	}
	
	// 퇴장
	private void doQuit(Writer writer) {
		removeWriter(writer);
		
		String data = nickname + "님이 퇴장하셨습니다.";
		broadcast(data);
	}
	
	private void removeWriter(Writer writer) {
		//* 리스트에서 제거
		//synchronized(listWriters) {
			listWriters.remove(writer);
		//}
	}
	

}

// run() 만들기
