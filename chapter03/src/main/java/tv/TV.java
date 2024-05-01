package tv;

public class TV {
	// field
	private int volume;	 	// 0~100
	private int channel;	// 1~255
	private boolean power;  // on/off
	
	// getter setter를 사용하지 않고 채널과 음량을 높이고 내리고 하는 방법으로
	// true면 올리고, false면 내리고, 범위 설정
	// 코드 중복을 줄이기 - 기존 메소드를 사용하기
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	// 9) void status() 메소드 구현( TV 정보 출력) 
	public void status() {	// TV 정보 출력
		// System.out.println("TV [power = off, channel=10, volume=100]");
		System.out.println("TV [power = " + (power?"on":"off") + ", channel = "+ channel + ", volume = "+ volume + "]");
		// 현재 전역 변수에 저장된 값을 출력
	}
	
	// 4) void power( boolean on ) 메소드 구현
	public void power(boolean on) {
		
//		if(on) {
//			String tv_power = "on";		//true
//		}else {
//			String tv_power = "off";	//false
//		}// 값을 업데이트 하지 말고, 출력만 하도록

	}
	
	
	//5) void channel( int channel ) 메소드 구현 (1~255 유지) 
	public void channel(int channel) {
		if(channel<1) {
			this.channel = 255;
		}
		else if(channel>225) {
			this.channel = 1;
		}
		else {
			this.channel = channel;		// 입력 받은 값 대입
		}
	}
	//6) void channel( boolean up ) 메소드 오버로딩 (1~255 유지, 1씩 증감)
	public void channel(boolean up) {
		if(up) {				// up 입력 시, 채널 증가
			int tmpChannel = this.channel + 1;
			channel(tmpChannel);	// 현재 채널로 업데이트
			}
	}
	// 7) void volume( int volume ) 메소드 구현  ( 0 ~ 100 유지 )
	public void volume(int volume) {
		if(volume<0) {
			this.volume = 100;
		}
		else if(volume>100) {
			this.volume = 0;
		}
		else {
			this.volume = volume;
		}
	}
	// 8) void volume( boolean up ) 메소드 오버로딩 (0 ~ 100 유지, 1씩 증감)
	public void volume(boolean up) {
		if(up) {
			int tmpVolume = this.volume + 1;
			volume(tmpVolume);
		}
	}

}
