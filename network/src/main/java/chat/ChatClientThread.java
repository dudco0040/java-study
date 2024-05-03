package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatClientThread extends Thread implements Runnable{
	private BufferedReader br;
	// 소켓생성
	Socket socket = null;
	
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}	
	
	
	@Override
	public void run() {
		// *** reader를 통해 읽은 데이터 콘솔에 출력하기 - message 처리
		// 내 메세지가 client 콘솔에 출력 됨
		// 메세지를 받으면 
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));  	// pw가 입력한 것을 br로 받음
			String message = br.readLine();
			
			while(message!= null) {  // 버퍼에 있는 값이 null이 될 때까지 - 출력 
				
				System.out.println(message);
				
			}
		} catch (SocketException e ) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(socket == null && !socket.isClosed()) {
					socket.close();
				}
			}catch (IOException e) {
					e.printStackTrace();
			
			}
		}
		
	}
	
}
