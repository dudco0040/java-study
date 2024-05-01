package prob6;

public class Rectangle extends Shape implements Resizable{
	double width; 
	double height;
	
	public Rectangle(double w, double h) {
		width = w;
		height = h;	
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		double area = width * height;
		
		return area;
	}
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		double perimeter = (width + height)*2;
		
		return perimeter;
	}
	
	@Override
	public void resize(double s) {
		width *= s;
		height *= s;
	}

}
