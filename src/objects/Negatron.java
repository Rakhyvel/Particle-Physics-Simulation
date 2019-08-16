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
public class Negatron extends ChargedParticle {
	public Negatron(Point position, Vector velocity, double ratio) {
		super(position, velocity, -100 * ratio, 100, new Color(0,128,255));
	}
}
