package prob03;

public class CurrencyConverter {
	private static double rate;
	
	
	// 환율 세팅
	public static void setRate(double rate) {
		CurrencyConverter.rate = rate;
	}
	// 달러로 변환
	public static double toDollar(double price) {
		double dollar = price / rate;
		return dollar;
	}
	// 원으로 변환
	public static double toKRW(double price) {
		double KRW = price * rate;
		return KRW;
	}

}
