package exception;

public class ExceptrionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10-a;
		
		System.out.println(" Some Code1 ...");
		
		try {
			System.out.println(" Some Code2 ...");
			System.out.println(" Some Code3 ...");
			
			int result = (1+2+3)/b;   // 예외 발생시키기
			
			System.out.println(" Some Code4 ...");
			System.out.println(" Some Code5 ...");
			
		} catch(ArithmeticException ex) {   // 발생한 예외 이름
			/* 예외 처리 */
			// ex.printStackTrace();  // console에 기록 - 좋은 방법은 아님
						
			// 1. 로깅
			System.out.println("error: " + ex);
			
			// 2. 안내문
			System.out.println("Sorry...");
			
			// 3. 정상종료
//			System.exit(0);  // return 0 : 정상 종료. return 1 : 비정상 종료
			return;
			
		}finally {
			System.out.println("자원정리: ex) close file, socket, db connect");
		}  //파일이 열려있는 상태에서 error 발생 -> finally 구문을 마지막에 꼭 실행해줌(자원정리를 해주는 코드 사용에 좋다!)
		
		System.out.println(" Some Code6 ...");
		System.out.println(" Some Code7 ...");

	}

}
