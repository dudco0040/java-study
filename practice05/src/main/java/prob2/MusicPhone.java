package prob2;

public class MusicPhone extends Phone {
	  public void execute ( String function ) {
	      if (function.equals("음악") ) {
	          playMusic();
	          return;
	      }
	      
	      super.execute( function );
	      // 입력된 기능이 "음악"이 아닌 경우, 부모 클래스인 Phone의 execute 메서드 호출
	}

	 protected void playMusic(){
	    System.out.println("MP3 플레이어에서 음악재생");
	  }
	}