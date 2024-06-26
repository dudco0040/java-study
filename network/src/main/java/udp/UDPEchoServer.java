package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	public static final int PORT = 6000;
	public static final int BUFFER_SIZE = 256;
	public static void main(String[] args) {
		DatagramSocket socket = null;
		
		try {
			// 1. 소켓 생성
			socket = new DatagramSocket(PORT);
			
			while(true) {
				// 2. 데이터 수신
				DatagramPacket rcvPacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);   // 패킷 생성
				socket.receive(rcvPacket);
				
				byte[] rcvData = rcvPacket.getData();
				int offset = rcvPacket.getLength();   // blocking 발생 - receive()가 데이터를 수신할 때까지 기다리며 데이터가 도착하면 blocking 이 해제됨
				
				String message = new String(rcvData, 0, offset, "UTF-8");
				System.out.println("[UDP Echo Server] received: "+ message);
				
				// 3. 데이터 송신
				byte[] sndData = message.getBytes("UTF-8");
				
				DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length, rcvPacket.getAddress(), rcvPacket.getPort());
				socket.send(sndPacket);
			}
		} catch (SocketException e) {
			System.out.println("[UDP Echo Server] error:" + e);
		} catch (IOException e) {
			System.out.println("[UDP Echo Server] error:" + e);
		} finally {
			if(socket != null && !socket.isClosed()){
				socket.close();
			}
		}

	}

}
