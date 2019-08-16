package objects;

import java.awt.Color;
import java.awt.Graphics;

import main.Main;
import util.Point;
import util.Vector;

/**
 * Particles are PhysicsObjects. They have a charge, color, and size, and they
 * collide with the wall.
 * 
 * PhysicsObject > Particle
 * 
 * @author Rakhyvel
 *
 */
public abstract class Particle extends PhysicsObject {
	private double charge;
	private Color color;
	private int size;

	public Particle(Point position, Vector velocity, double charge, double mass, Color color) {
		super(position, velocity, new Vector(), mass);
		setCharge(charge);
		setColor(color);
		setSize(7);
	}

	/**
	 * Changes the particles velocity based on acceleration, and position then based
	 * on velocity. Then reset acceleration to 0, then calculates wall collision
	 */
	public void integrate() {
		getVelocity().addVec(getAcceleration());
		getPosition().addVector(getVelocity());

		getAcceleration().setX(0);
		getAcceleration().setY(0);

//		doWallCollision();
	}

	/**
	 * Checks to see if the particle is past each wall, if so, it places it back and
	 * reverses the velocity in that direction
	 */
	void doWallCollision() {
		// North Wall
		if (getPosition().getY() < size >> 1) {
			getPosition().setY(size >> 1);
			getVelocity().setY(-getVelocity().getY());
		}
		// East Wall
		if (getPosition().getX() > 1024 - (size >> 1) - 7) {
			getPosition().setX(1024 - (size >> 1) - 7);
			getVelocity().setX(-getVelocity().getX());
		}
		// South Wall
		if (getPosition().getY() > 576 - (size >> 1) - 10) {
			getPosition().setY(576 - (size >> 1) - 10);
			getVelocity().setY(-getVelocity().getY());
		}
		// West Wall
		if (getPosition().getX() < size >> 1) {
			getPosition().setX(size >> 1);
			getVelocity().setX(-getVelocity().getX());
		}
	}

	/*
	 * First calculates the amount the particle should be repeled by, and adds the
	 * repulsive force to the particle
	 */
	void getRepelForce(Particle particle, double distance, double acceptableDistance) {
		double repelAmount = getPosition().subVec(particle.getPosition()).normalize()
				.dot(getVelocity().subVec(particle.getVelocity()))+(acceptableDistance-distance);
		addForce(getPosition().subVec(particle.getPosition()).normalize(), -Math.abs(2 * repelAmount * (acceptableDistance - distance)));
	}

	/*
	 * Adds the force of gravity to the particle 
	 */
	void getGravity(Particle particle, double distance) {
		addForce(getPosition().subVec(particle.getPosition()).normalize(),
				(G * particle.getMass() * getMass()) / distance);
	}

	public abstract void calculate();

	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval((int) (getPosition().getX()*Main.zoom - ((int) (size*Main.zoom) >> 1))-(int)(Main.center.getX()*(Main.zoom-1)),
				(int) (getPosition().getY()*Main.zoom - ((int) (size*Main.zoom) >> 1))-(int)(Main.center.getY()*(Main.zoom-1)), (int) Math.max(2,(size*Main.zoom)), (int) Math.max(2,(size*Main.zoom)));
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
