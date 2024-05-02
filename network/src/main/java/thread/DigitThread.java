package thread;

public class DigitThread extends Thread {
	@Override
	public void run() {
//		super.run();

			for(int i = 0; 1 < 20; i++) {
				System.out.println(i);
				
				// 대기
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}
}
