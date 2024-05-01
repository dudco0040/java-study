package prob6;

public class RectTriangle extends Shape {
	double width; 
	double height;
	
	public RectTriangle(double w, double h) {
		width = w;
		height = h;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		double area = width * height * 1/2;
		
		return area;
	}
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		double perimeter = width + height +  Math.sqrt(Math.pow(width,2) + Math.pow(height,2));
		
		return perimeter;
	}

}
