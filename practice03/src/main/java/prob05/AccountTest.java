package prob05;

public class AccountTest {

	public static void main(String[] args) {
		
		Account account = new Account( "078-3762-293" );  // 생성과 동시에 값을 대입
		System.out.println( account.getAccountNo() + "계좌의 잔고는 " + account.getBalance() + "만원입니다." );
		
		account.save( 100 ); // 100만원이 입금되었다. 
		System.out.println( account.getAccountNo() + "계좌의 잔고는 " + account.getBalance() + "만원입니다." );

		account.deposit( 30 ); // 30만원이 출급되었다.
		System.out.println( account.getAccountNo() + "계좌의 잔고는 " + account.getBalance() + "만원입니다." );

	}

}


//출력 결과에 맞게 작성하면 됨