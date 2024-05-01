package paint;

public class ColorPoint extends Point {
	// 아래의 기본 생성자가 자동으로 들어간 것 - 
//	public ColorPoint() {
//		super();
//	} 
	
	private String color;
	
	public ColorPoint(int x, int y, String color) {
//		setX(x);
//		setY(y);  // 멋있는 코드로 만들어!
		super(x,y);   // 부로 생성사 명시 - 부모의  
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	

}
