package prob5;

import java.util.Scanner;

public class Prob5 {
	public static void main(String[] args) {	
		for(int i =1; i<100; i++) {
			String text = Integer.toString(i);
			int cnt = 0;
			for(int j=0; j<text.length();j++) {
				char c = text.charAt(j);
				if(c=='3' ||c == '6' ||c =='9') {
					cnt++;
				}
			}
			if(cnt!=0) {
				System.out.printf(text+ " ");
			
			for(int no = 0; no<cnt; no++) {
				System.out.print("짝");
				
			}
			System.out.println();
			}
		}
	}
}
