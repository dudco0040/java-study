package prob05;

public class Account {
	private String accountno;	// 계좌번호
	private int balance;		// 잔고
	
	// 생성자(Constructor)
	Account(String accountNo){
		this.setAccountNo(accountNo);
		System.out.println("계좌가 계설되었습니다.");
	}
	
	// getter & setter
	public void setAccountNo(String accountNo) {
		this.accountno = accountNo;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public String getAccountNo() {
		return accountno;
	}
	public int getBalance() {
		return balance;
	}
	
	
	//입금
	public void save(int money) {
		balance = balance + money;
		System.out.println(money+ "원이 입급되었습니다.");
	}
	//출금
	public void deposit(int money) {
		balance = balance - money; 
		System.out.println(money + "원이 출금되었습니다.");
	}
	
}


// Account class를 완성하기
// 생성자 만들어서 세팅
// 출력이 가능해야함
