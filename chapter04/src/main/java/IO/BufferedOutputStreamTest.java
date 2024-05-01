package IO;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;


public class BufferedOutputStreamTest {

	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		
		try {
			// 기반 스트림 - 주 스트림
			FileOutputStream fos = new FileOutputStream("hello.text");  // 소스 파일에 직접적으로 연결됨
			
			// 보조 스트림
			// 내부에 array buffer가 존재
			bos = new BufferedOutputStream(fos);   	// 주 스트림과 연결
			
			//for(int i = 'a'; i<= 'z'; i++) { 	//char -> int 형변환  
			for(int i = 97; i<= 122; i++) { 	
				bos.write(i);
			
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found: "+e);
		
		} catch (IOException e) {
			System.out.println("file not found: "+e);
		
		} finally { 	// 사용하고 있는 보조스트림만 닫아주면 자동으로 닫힘 - 개별적으로 close 해 줄 필요가 없음
			try {
				if(bos != null) {
					bos.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
