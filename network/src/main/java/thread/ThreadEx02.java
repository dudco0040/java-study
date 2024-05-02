package thread;

public class ThreadEx02 {

	public static void main(String[] args) {
		// 생성
		Thread thread1 = new DigitThread();
		Thread thread2 = new AlphabetThread();
		
		// 실행
		thread1.start();
		thread2.start();

	}

}
