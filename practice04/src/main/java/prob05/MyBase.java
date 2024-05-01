package prob05;

public class MyBase extends Base {
	public void service(String state) {
		// 오버라이딩 - 덮어 씌우기 0
		if(state.equals("낮")) {
			System.out.println("닞에는 열심히 일하자!");
		} else if (state.equals("오후")) {
			System.out.println("오후에도 낮과 마찬가지로 일해야 합니다.");
		} else {  // 밤
			Base base = new Base();  // ??
			base.service(state);
		}
	}

}
