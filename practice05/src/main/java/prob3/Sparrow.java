package prob3;

public class Sparrow extends Bird {
	public void fly() {
		System.out.println("참새(" + name + ")는 날아다닙니다.");
	}
	
	public void sing() {
		System.out.println("참새(" + name + ")은 소리내어 웁니다.");
	}
	
	@Override
	public String toString() {
		return "참새의 이름은 " + name + "입니다.";
	}
}
