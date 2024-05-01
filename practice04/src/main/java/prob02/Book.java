package prob02;

public class Book {
	int bookNo;		 // 번호
	String title; 	 // 제목
	String author; 	 // 작가
	int stateCode; 	 // 상태코드 - defalt: 0, 호출 시 1로 업데이트
	
	// 생성자
	public Book(int bookNo, String title, String authuor) {
		this.setBookNo(bookNo);
		this.setTitle(title);
		this.setAuthor(authuor);
		this.setStateCode(1);
	}
	
	
	// getter & setter
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	
	
	// rent
	public void rent() {
		// Book 클래스의 stateCode를 0으로 변경 
		// 대여 메세지 출력
		this.stateCode = 0; 
		System.out.println(stateCode + "이(가) 대여 됐습니다.");
	}
	
	
	// print
	public void print() {
		// 책의 정보 출력
		System.out.println("[" + bookNo + "] 책 제목:" + title + ", 작가:" + author + ", 대여 유무:" + (stateCode == 1 ? "재고있음" : "대여중"));
		}
}
