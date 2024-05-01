package exception;

public class MyException extends Exception {
	public MyException(String message) {
		super(message);			//Exception 클래스를 상속받음
	}
	public MyException() {		//오버로드
		super("MyException Trown");
	}

}
