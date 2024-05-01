package prob3;

public abstract class Bird {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// 추상 클래스 - 공통된 메소드를 정의
	public abstract void fly();
	public abstract void sing();
	
}