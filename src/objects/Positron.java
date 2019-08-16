package objects;

import java.awt.Color;

import util.Point;
import util.Vector;

/**
 * Positrons are positively charged ChargedParticles
 * 
 * PhysicsObject > Particle > ChargedParticle > Positron
 * 
 * @author Rakhyvel
 *
 */
public class Positron extends ChargedParticle {
	public Positron(Point position, Vector velocity, double ratio) {
		super(position, velocity, (2500/ (ratio * 100)), 100, new Color(255,0,0));
	}
}
