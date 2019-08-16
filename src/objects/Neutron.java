package objects;

import java.awt.Color;

import util.Point;
import util.Vector;

/**
 * Negatrons are negatively charged ChargedParticles.
 * 
 * PhysicsObject > Particle > ChargedParticle > Negatron
 * 
 * @author Rakhyvel
 *
 */
public class Neutron extends ChargedParticle {
	public Neutron(Point position, Vector velocity) {
		super(position, velocity, 0, 100, Color.white);
	}
}
