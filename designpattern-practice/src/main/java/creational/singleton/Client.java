package creational.singleton;

public class Client {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		// 두 객체가 같아야함
		
		System.out.println(s1==s2); // true

	}

}
