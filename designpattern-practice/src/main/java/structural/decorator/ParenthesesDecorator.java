package structural.decorator;

public class ParenthesesDecorator extends Decorator {

	public ParenthesesDecorator(Component component) {  // 앞의 스트링을 받을 수 있도록
		super(component);

	}

	@Override
	public String operation() {
		String text = component.operation();
		
		
		return "(" + text + ")";
	}

}
