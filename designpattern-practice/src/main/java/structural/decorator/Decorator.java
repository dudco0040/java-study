package structural.decorator;

public abstract class Decorator extends Component {
	// 주 스트림 또는 보조 스트림(데코레이터의 앞의 스트림)을 읽어올 수 있다.
	protected Component component;
	
	public Decorator(Component component){ // 데이레이터를 생성하기 위해 강제한다.
		this.component = component;
	}
	
	
	
//	@Override
//	public String operation() {
//		// TODO Auto-generated method stub
//		return null;
//	}  // 구현을 할 수 없다 - 왜? 

}
