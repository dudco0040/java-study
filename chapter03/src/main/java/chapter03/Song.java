package chapter03;

public class Song {
	private String title;
	private String album; 
	private String composer;
	private String artist;
	private int track;
	private int year;
	
	// 오버로딩?
	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	public Song(String title, String album, String composer, String artist, int track, int year) {
		// 기본 생성자를 안넣어줌 - main함수에 에러가 발생할 것. main에 new 생성자를 만들어줌
		this.title = title; 
		this.album = album;
		this.composer = composer;
		this.artist = artist;
		this.track = track;
		this.year = year;
	}
	
	// getter & setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void show() {
		System.out.println(artist+" " +title);
	}
}
