package lr222qp_assign3;

public class Point {
private int X;
private int Y;
private double dist;

	public Point(int Xvalue, int Yvalue) {
		X=Xvalue;
		Y=Yvalue;
	}
	public Point() {
	X = 0;
	Y = 0;
	}
	public String toString() {
		String text =("("+X+","+Y+")");
		return text;
	}
	public boolean isEqualTo(Point p2) {
	if(X == p2.X && Y==p2.Y)
		return true;
	else
	return false;
	}
	public double distanceTo(Point p2) {
	dist = Math.sqrt((p2.X-X)*(p2.X-X) + (p2.Y-Y)*(p2.Y-Y));
		return dist;
	}
	public void move(int x2, int y2) {
		X = X + x2;
		Y = Y + y2;
		
	}
	public void moveToXY(int x3, int y3) {
		X = x3;
		Y = y3;
		
	}

}
