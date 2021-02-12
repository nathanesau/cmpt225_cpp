package example.geometry;

public class Circle {

	protected Point center;
	protected int radius;
	
	public Circle(int x, int y,int r)
	{
		setCenter(new Point(x, y));
		setRadius(r);
	}
	
	public Circle(Point c,int r)
	{
		setCenter(c);
		setRadius(r);
	}
	
	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point c) {
		this.center = c;
	}

	public void setRadius(int rad) {
		if (rad >= 0)
			this.radius = rad;
		else {
			IllegalArgumentException ex = new IllegalArgumentException("radius < 0"); 
			throw ex;
		}
	}
	
	public int getRadius() {
		return radius;
	}
	
	public double getArea() {
		return Math.PI*radius*radius;
	}
}
