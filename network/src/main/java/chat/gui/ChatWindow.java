package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketException;
import chat.ChatClient;

public class ChatWindow {
	// *소켓 추가 
	Socket socket = null;
	String name = null;
	private PrintWriter pw;
	private Frame frame;	// 윈도우 창
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	

	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.name = name;
		this.socket = socket;
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"), true);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("[UnsupportedEncodingException] " + e);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[IOException] " + e);
		}
		
	}
	
	
	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {  // 옵저버
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				System.out.println("click");
				sendMessage();
			}
		});		// 

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println("!!!");
				char keyCode = e.getKeyChar();
				if(keyCode== KeyEvent.VK_ENTER){
					sendMessage();
				}
			}
			
		});  // 클래스를 따로 생성하지 않고 바로 구현 - 클래스 이름 없이 사용

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		
		// 윈도우에 반영
		frame.setVisible(true);
		frame.pack();
		new ChatClientThread().start();
	}
		// 소켓을 받아옴
		// IOStream 받아오기  - print writer - 스캐너는 필요 없음 
		

	private void sendMessage() {
//		try {
			
			String message = textField.getText();
			// System.out.println("메세지 보내는 프로토콜을 구현!: " + message);
			System.out.println("[sendMessage] " + name + ":" + message);
			
			// 메세지 보내는 프로토콜 구현 
			if("quit".equals(message)) {
				System.out.println("[Closed App]");
				finish();
			} else {
				// ChatClientThread에서 서버로 부터 받은 메세지가 있다고 가정하고, 
				pw.println("message:" + message);   // 서버에게 
			}
		
		textField.setText("");
		textField.requestFocus();
		
	}
	

	
	// ** 
	private void updateTextArea(String message) {
		if(message != null) {
			textArea.append(message);
			textArea.append("\n");
		} else {}  // pass
	}
	
	private void finish() {
		// quit protocol 구현
		pw.println("quit"); // pw - 서버에게 보내줨(알려줌) - 종료
		
		// exit java application
		System.exit(0);
	}
	
	// chatClient 스레드 생성
	// 스레드를 내부에 만들어야 함
	// br은 내가 보낼때 
	
	private class ChatClientThread extends Thread {		
		@Override
		public void run() {
//			String message = br.readLine();
			//***
			
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
				String message ;
				
				
				while(true) {
					 message = br.readLine();
			        
					 if("quit".equals(message)) {  // 끝날때 메세지를 입력하는 방식으로 똑같이?
						finish();
					 } else {
						updateTextArea(message);  // 서버에서 보내줄때 이미 형식이 있음 name + ": " + message
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
}
