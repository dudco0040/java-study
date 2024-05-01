package structural.decorator;

public class ConcretComponent extends Component {
	private String text;
	
	public ConcretComponent(String text) {
		this.text = text;
	}
	
	
	@Override
	public String operation() {
	
		return text;  //데이터를 String으로 바꿔서 리턴
	}

}
