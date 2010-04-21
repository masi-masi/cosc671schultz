public class Rectangle {
	private Point p1, p2;
	private Double width, height;
	
	Rectangle(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		
		width = (this.p2.x - this.p1.x);
		height = (this.p2.y - this.p1.y);
	}
	
	public Double getArea() {
		Double area = Math.abs(width * height);
		return area;
	}
	
	public Double getDiagonal() {
		Double diagonal;
		
		Double x = Math.pow(width, 2);
		Double y = Math.pow(height, 2);
		
		diagonal = Math.sqrt(x + y);

		return diagonal;
	}
}
