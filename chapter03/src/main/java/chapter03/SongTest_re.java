package chapter03;

public class SongTest_re {

	public static void main(String[] args) {
//		Song song = new Song();
//		Song song = new Song("좋은날", "아이유", "real", "이민수", 3, 2010); // 아래를 주석처리하고, 파라미터 값을 넣어줌
		Song song01 = new Song("좋은날", "아이유", "real", "이민수", 3, 2010);
		
//		song01.setTitle("좋은날");
//		song01.setArtist("아이유");
//		song01.setAlbum("Real");
//		song01.setComposer("이민수");
//		song01.setTrack(3);
//		song01.setYear(2010);
		
		song01.show();  //출력

		Song song02 = new Song("Ditto","New Jeans"); //노래제목과 가수만 알 경우
		song02.show();
	}

}
