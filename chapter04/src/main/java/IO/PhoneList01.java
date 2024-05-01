package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PhoneList01 {
	public static void main(String[] args) {
		try {			
			File file = new File("./phone.txt");
			if(!file.exists()) {
				System.out.println("file not found");
				return;  // 바로 종료
				
			}
			
			FileInputStream fis = new FileInputStream("./phone.txt");
			fis.read();
		} catch (IOException e) {
			
		}
		
	}
}
