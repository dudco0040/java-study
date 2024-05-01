package prob2;

public class SmartPhone extends MusicPhone {
	// 같은 이름의 메소드를 생성해서 오버라이딩 시킴
	// "다운로드해서 음악재생" 출력
	  
	  //통화
	  public void execute(String function) {
		  // 통화
		  if(function.equals("통화")) {
			  super.execute(function);
			  return;
		  // 앱
		  } else if(function.equals("앱")) {
			  playApp();
			  return;
		  }
		  // 음악
		  super.execute( function );
	  }
	  
	  @Override
	  public void playMusic(){
		  System.out.println("다운로드해서 음악재생");
	  }
	  
	  public void playApp() {
		  System.out.println("앱 실행");
	  }
}
