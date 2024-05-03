package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread implements Runnable{
	private BufferedReader br;
	// 소켓생성
	Socket socket = null;
	
	public ChatClientThread(Socket socket) {
		this.socket = socket;
//		this.br = br;
	}	
	
	
	@Override
	public void run() {
		// *** reader를 통해 읽은 데이터 콘솔에 출력하기 - message 처리
		// 내 메세지가 client 콘솔에 출력 됨
		// 메세지를 받으면 
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			
			String message ;
			while(true) {  // 버퍼에 있는 값이 null이 될 때까지 - 출력 (message = br.readLine()) != null
				 message = br.readLine();
				if("quit".equals(message)) {
					break;
				}else {
					System.out.println(message);
				}
			}
		} catch (SocketException e ) {
			ChatClient.log("SocketException" + e);
			
		} catch (IOException e) {
			ChatClient.log("IOException" + e);
			
		} finally {
			
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			}catch (IOException e) {
					e.printStackTrace();
			
			}
		}
		
	}
	
}
