package util;

/**
 * Vectors represent direction and magnitude. They have an x and a y coordinate.
 * 
 * @author Rakhyvel
 *
 */
public class Vector {

	double x, y;

	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector(Vector vector) {
		this.x = vector.x;
		this.y = vector.y;
	}

	public Vector() {
		this.x = 0;
		this.y = 0;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double d) {
		this.y = d;
	}

	public Vector normalize() {
		double magnitude = x * x + y * y;
		double x1 = x, y1 = y;
		if (magnitude == 0) {
			return new Vector(0, 0);
		}
		magnitude = 1 / Math.sqrt(magnitude);
		x1 *= magnitude;
		y1 *= magnitude;
		return new Vector(x1, y1);
	}

	public Vector scalar(double t) {
		return new Vector(x * t, y * t);
	}
	
	public void multScalar(double t) {
		x*=t;
		y*=t;
	}

	public float getRadian() {
		if (y == 0) {
			if (x == 0)
				return 0;
			if (x > 0)
				return -(float) Math.PI / 2;
			return (float) Math.PI / 2;
		}
		return (float) (Math.atan(x / y));
	}

	public double dot(Vector v) {
		// Projects one vector onto another, giving a scalar value
		return x * v.x + y * v.y;
	}

	public void addVec(Vector v) {
		x += v.x;
		y += v.y;
	}

	public Vector subVec(Vector v) {
		return new Vector(x - v.x, y - v.y);
	}

	public double magnitude() {
		return Math.sqrt(x * x + y * y);
	}

	public String toString() {
		return String.valueOf(x) + " " + String.valueOf(y);
	}
}
