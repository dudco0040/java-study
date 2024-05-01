package prob6;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {

	public static void main(String[] args) {
		List<Shape> list = new ArrayList<Shape>();
		
		list.add( new Rectangle(5., 6.) );
		list.add( new RectTriangle(6., 2.) );
		// Shape을 상속받은 클래스이기 때문에 객체 추가가 가능함
		
		for( Shape shape : list ) {
			System.out.println( "area:" + shape.getArea() );			// 넓이
			System.out.println( "perimeter:" + shape.getPerimeter() );	// 둘레
			
			if( shape instanceof Resizable ) {
				Resizable resizable = (Resizable) shape;
				resizable.resize( 0.5 );
				System.out.println( "new area:" + shape.getArea() );
				System.out.println( "new perimeter:" + shape.getPerimeter() );
			}
		}
	}
}