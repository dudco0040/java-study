package chapture04;

public class ObjectTest01 {
	public static void main(String[] args) {
		Point point = new Point();
		
		Class klass = point.getClass();	 //refrelection
		System.out.println(klass);
		
		System.out.println(point.hashCode());	//address 기반의 hashing 값
												//address X
												//reference X
		// 아래 두개는 같음
		
		System.out.println(point.toString());	//getClass().toString + "@" + hashCode()
		System.out.println(point);
	}
}
