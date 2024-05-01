package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null; 
		
		try {
			scanner = new Scanner(System.in);
			socket = new Socket();
			
			socket.connect(new InetSocketAddress("", EchoServer.PORT));
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf=8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf=8"));
			// 확인 
			
			while(true) {
				System.out.println(">>");			
				String line = scanner.nextLine();
				if("exit".equals(line)) {
					break;
				}
				
				pw.println(line);
				String data = br.readLine();
				if(data == null) {
					log("suddenly closed by server");
					break;  // 연결이 끊어짐 
				}
				System.out.println("<<"+ data);
			}
		} catch(IOException e) {
			log("error:"+e);
		} finally {
			try {
				if(socket!=null && socket.isClosed()) {
				socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
		
	private static void log(String message) {
		
	}
	
}
