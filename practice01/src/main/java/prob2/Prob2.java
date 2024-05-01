package prob2;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */
		
		int no = 1;
		while (no<=10) {
//			System.out.println(no);
			for(int i =no; i <= no+9; i++) {
				System.out.print(i+" ");
			}
			System.out.println();
			no++;
//			break;
		}
	}
}
