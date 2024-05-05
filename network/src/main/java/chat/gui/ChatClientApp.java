package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import chat.ChatServer;

public class ChatClientApp {

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null; 
		
		// socket 연결 완료 
		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty()==false) {  // 입력한 값이 없으면 
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();
		
		PrintWriter pw;
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress("", ChatServer.PORT_NO));
			
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			
			pw.println("join:" + name);  		// pw로 서버에 전송  
			String data = br.readLine();
			
			// 입장 알림을 출력 - "join:ok"일 경우 welcome 메세지 출력
			if("join:ok".equals(data)) {
				System.out.println("입장하였습니다. 즐거운 채팅 되세요.");
			}
			// pw.flush();
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException" + e);
		} catch (IOException e) {
			System.out.println("IOException");
		}
		
		new ChatWindow(name, socket).show();   // 윈도우 창이 열림 - 여기서 join 프로토콜을 해놓고 감 - name, socket 모두 넘거야함 
	}

}
