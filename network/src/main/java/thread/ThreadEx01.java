package thread;

public class ThreadEx01 {
	public static void main(String[] args) {
//		for(int i = 0; 1<10; i++) {
//			System.out.println(i);
//		} 
		
		new DigitThread().start();
		
		for(char c = 'a'; c <= 'j'; c++) {
			System.out.println(c);
			
			// 대기
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
