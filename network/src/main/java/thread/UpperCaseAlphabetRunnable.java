package thread;

public class UpperCaseAlphabetRunnable extends UpperCaseAlphabet implements Runnable{

	@Override
	public void run() {
		print();
	}  // implements Runnable을 구현하는 객체는 스레드로 태울 수 있다.
	

}
