package util;

/**
 * Points represent points in space. They have an x and a y coordinate.
 * 
 * @author Rakhyvel
 *
 */
public class Point {
	double x, y;

	public Point() {
		this.setX(0);
		this.setY(0);
	}

	public Point(double x, double y) {
		this.setX(x);
		this.setY(y);
	}

	public Point(Point p) {
		this.setX(p.getX());
		this.setY(p.getY());
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Point addPoint(Point p2) {
		return new Point(x + p2.x, y + p2.y);
	}

	public void addVector(Vector v) {
		x += v.x;
		y += v.y;
	}

	public double getDist(Point p2) {
		return ((x - p2.x) * (x - p2.x) + (y - p2.y) * (y - p2.y));
	}

	public double getDist(double x1, double y1) {
		return (x - x1) * (x - x1) + (y - y1) * (y - y1);
	}

	public double getDistSquared(Point p2) {
		double distance = (x - p2.x) * (x - p2.x) + (y - p2.y) * (y - p2.y);
		return Math.sqrt(distance);
	}

	public Vector getTargetVector(Point p) {
		if (getDist(p) == 0)
			return new Vector(0, 0);
		return new Vector(p.x - x, p.y - y);
	}

	public Vector subVec(Point p) {
		return new Vector(p.x - x, p.y - y);
	}

	public double getCabDist(Point p2) {
		return Math.abs(x - p2.x) + Math.abs(y - p2.y);
	}

	public Point multScalar(double scalar) {
		return new Point(x * scalar, y * scalar);
	}

	public Point getMidPoint(Point p) {
		return new Point((x + p.x) / 2, (y + p.y) / 2);
	}

	public boolean equals(Point p) {
		if (p == this)
			return true;
		if (p == null)
			return false;
		double dX = x - p.x;
		double dY = y - p.y;
		return (dX * dX) + (dY * dY) < 1;
	}

	public String toString() {
		return String.valueOf(x) + " " + String.valueOf(y);
	}
}
