package objects;

import java.awt.Color;

import main.Main;
import util.Point;
import util.Vector;

/**
 * Charged particles are particles with a charge. They feel the charged force.
 * 
 * PhysicsObject > Particle > ChargedParticle
 * 
 * @author Rakhyvel
 *
 */
public class ChargedParticle extends Particle {

	public ChargedParticle(Point position, Vector velocity, double charge, double mass, Color color) {
		super(position, velocity, charge, mass, color);
	}

	/**
	 * Goes through every other particle in the World's particle list and calculates
	 * attraction/repulsion to each if the particle's distance squared is less than
	 * 2000 units
	 * 
	 * If you were to modify the behavior of particles in any way, it would most
	 * likely have something to do with this method.
	 */
	public void calculate() {
		for (int i = 0; i < Main.world.size(); i++) {
			if (Main.world.get(i) != this) {
				Particle particle = Main.world.get(i);
				double distance = particle.getPosition().getDist(getPosition());
				if (distance > 4 * getSize() * getSize()) {
					getChargeForce(particle, distance);
					getGravity(particle,distance);
				} else {
					getRepelForce(particle, Math.sqrt(distance), 2 * getSize());
				}
			}
		}
	}

	/**
	 * Adds a force to the particle given another particle and the distance squared
	 * to that particle
	 */
	void getChargeForce(Particle particle, double distance) {
		addForce(getPosition().subVec(particle.getPosition()).normalize(),
				(-1*getCharge() * particle.getCharge()) / distance);
	}

}
