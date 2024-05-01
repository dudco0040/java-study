package prob01;

public class Printer {
	// 메소드 오버로딩
	public void println(int number) {
		System.out.println(number);
	}
	public void println(boolean bool) {
		System.out.println(bool);
	}
	public void println(double doubleNumber) {
		System.out.println(doubleNumber);
	}
	public void println(String text) {
		System.out.println(text);
	}
}
