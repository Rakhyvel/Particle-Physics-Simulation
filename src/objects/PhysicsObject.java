package objects;

import util.Point;
import util.Vector;

/**
 * PhysicsObjects are objects that feel Newtonian physics. They have a position,
 * velocity, acceleration, and mass.
 * 
 * PhysicsObject is the lowest order object in this program.
 * 
 * @author Rakhyvel
 *
 */
public abstract class PhysicsObject {
	private Point position;
	private Vector velocity;
	private Vector acceleration;
	private double mass;
	private double invMass;
	public static final double G = 1 * Math.pow(10, -3);

	public PhysicsObject(Point position, Vector velocity, Vector acceleration, double mass) {
		setPosition(position);
		setVelocity(velocity);
		setAcceleration(acceleration);
		setMass(mass);
		setInvMass(1 / getMass());
	}
	
	/*
	 * Adds a force to the acceleration, multiplying by invMass because f=ma, so a=f/m
	 */
	void addForce(Vector normal, double scalar) {
		acceleration.addVec(normal.scalar(scalar * invMass));
	}

	abstract void integrate();

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Vector getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}

	public Vector getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Vector acceleration) {
		this.acceleration = acceleration;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getInvMass() {
		return invMass;
	}

	public void setInvMass(double invMass) {
		this.invMass = invMass;
	}
}
