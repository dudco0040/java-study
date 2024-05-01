package creational.singleton;

public class Singleton {
	private static Singleton instance;   // static 변수가 있어야함 - 왜???

	private Singleton() {
		
	}
	public static Singleton getInstance() {  //static은 static에서 접근할 수 있다. 
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

}
