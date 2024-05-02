package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class RequestHandler extends Thread {
	private Socket socket;
	private final String DOCUMENT_ROOT = "./webapp";
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			// 브라우저가 보내는 바디 내용
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));  // 읽어오기 쉽게 - 라이브러리를 사용해서  
		

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );
			// Info 남기기 
			
			String request = null;
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				
				
				// simpleHttpServer는 HTTP header만 처리
				if("".equals(line)) {  //헤더와 바디의 경계로 line이 빈 String 일 때,
					break;
				}
				
				// request header의 첫 줄만 읽음
				if(request == null) {
					request = line;
					break;
				}
				
				// 요청처리
				consoleLog(line);
				String[] tokens = request.split(" ");
				if("GET".equals(tokens[0]) {
					responseStaticResource(outputStream, tokens[1], tokens[2]); // url, 프로토골
				} else {  // 이 경우는 C,U,D
					/* methods: POST(create), GET(read), PUT(update), DELETE(delete) - CRUD. HEAD, CONNECT, ... */
					// simpleHttpServer 에서는 무시(400 bad request)
//					response404Error(outputStream, tokens[2]);
					
					
				}
			}
			
			// 요청을 읽지도 않고 응답을 함 - 어떤 요청이든 우선 200 ok 응답을 보내준다.
			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
//			outputStream.write( "HTTP/1.1 200 OK\n".getBytes( "UTF-8" ) );
//			outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
//			outputStream.write( "\n".getBytes() );
//			// body
//			outputStream.write( "<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes( "UTF-8" ) );
			
			
			
		} catch( Exception ex ) {
			consoleLog( "error:" + ex );
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}


	
	
	private void responseStaticResource(outputStream, String url, String protocol) {
		if("/".equals(url)) {
			url = "/index,html";
			
		}
		
		File file = new File(DOCUMENT_ROOT + url);
		if(!file.exists()) {
//			response404error(outputStream, protocol);
			return; 
		}
		
		// nio
		byte[] body = File.readAllBytes(file.toPath());
		
		outputStream.write( "HTTP/1.1 200 OK\n".getBytes( "UTF-8" ) );
		outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
		outputStream.write( "\n".getBytes() );
		outputStream.write(body);
	}
	private void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );   // 스레드 id  - getId() 상속받았기 때문에 사용 가능 
	}
}
