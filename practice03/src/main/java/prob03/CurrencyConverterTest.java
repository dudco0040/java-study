package prob03;

public class CurrencyConverterTest {

	public static void main(String[] args) {
		//  환율을 세팅 합니다.
		CurrencyConverter.setRate(1374); //클래스이름을 그대로 썻으니 static
		
		// 환율 계산하기
		double dollar = CurrencyConverter.toDollar( 1000000. );
		System.out.println( "백만원은 " + dollar + "달러 입니다" );
		
		double krw = CurrencyConverter.toKRW( 100. ); //100 달러 -> n원
		System.out.println( "백달러는 " + krw + "원 입니다" );
	}

}

//유틸리티 만들기