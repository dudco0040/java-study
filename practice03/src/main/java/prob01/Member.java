package prob01;

public class Member {
	private String id;
	private String name;
	private int point;
	
	public void setName(String name) {	// 이름 변경
		this.name = name;
	}
	public String getName() {	// 이름 반환
		return name;
	}
	
	public void setPoint(int point) {	// 포인트 변경
		this.point = point;
	}
	
	public int getPoint() {	// 포인트 반환
		return point;
	}
	
	public void setId(String id) {	// 회원 아이디 변경
		this.id = id;
	}
	
	public String getId(String id) {	// 회원 아이디 반환
		return id;
	}
	
}