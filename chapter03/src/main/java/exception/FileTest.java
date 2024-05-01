package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		// try-catch 예외처리
		try {
			fis = new FileInputStream("hello.txt");  // 파일이 존재하지 않을 경우, 에러 발생
			int data = fis.read();
			System.out.println((char)data);
			
		} catch (FileNotFoundException e) {		// 파일을 찾을 수 없는 경우
			System.out.println("error: " + e);	
			
		} catch(IOException e){		// 파일을 읽을 때 또는 파일을 닫을 때 발생할 수 있는 일반적인 입출력 오류
			System.out.println("error: " + e);
		
		} finally {  // 무조건 실행
			// 파일 정리
			try {
				if(fis != null) {
					fis.close();
				}
			} catch(IOException e){
				e.printStackTrace();  // 예외 정보 출력
			
			}
		}
	}
}
