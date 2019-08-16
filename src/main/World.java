package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import objects.Negatron;
import objects.Neutron;
import objects.Particle;
import objects.PhysicsObject;
import objects.Positron;
import util.Point;
import util.Vector;

/**
 * This class handles the list of particles. It calls the render method for each
 * particle and tells each particle to calculate its physics
 * 
 * @author Rakhyvel
 *
 */
public class World {
	private static ArrayList<Particle> particleList = new ArrayList<Particle>();

	/**
	 * Constructor sets up the particle list given parameters such as the ratio,
	 * number, and size of spawn
	 */
	public World(double ratio, double number, double size, Random rand) {
		double pos = 0;
		double neg = 0;
		for (int i = 0; i < number * ratio; i++) {
			particleList.add(new Positron(new Point(rand.nextDouble() * size + (1024 - size) / 2,
					rand.nextDouble() * size + (576 - size) / 2), new Vector(0, 0), ratio));
			pos += (2500 / (ratio * 100));
		}
		for (int i = 0; neg > -pos; i++) {
			particleList.add(new Negatron(new Point(rand.nextDouble() * size + (1024 - size) / 2,
					rand.nextDouble() * size + (576 - size) / 2), new Vector(0, 0), ratio));
			neg += -100 * ratio;
		}
		System.out.println(pos + " " + neg);
	}

	public World(double number, double size, Random rand) {
		Point temp;
		Vector vec = new Vector();
		for (int i = 0; i < number; i++) {
			temp = new Point(rand.nextDouble() * size + (1024 - size) / 2, rand.nextDouble() * size + (576 - size) / 2);
			particleList.add(new Neutron(temp, new Vector(vec.getY(), -vec.getX())));
		}
	}

	/**
	 * Draws all particles to screen
	 */
	void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 1024, 596);
		for (int i = 0; i < particleList.size(); i++) {
			particleList.get(i).render(g);

		}
	}

	/**
	 * Calculates physics and position for all particles
	 */
	void tick() {
		for (int i = 0; i < particleList.size(); i++) {
			particleList.get(i).calculate();
		}
		for (int i = 0; i < particleList.size(); i++) {
			particleList.get(i).integrate();
		}
	}

	public Particle get(int id) {
		return particleList.get(id);
	}

	public int size() {
		return particleList.size();
	}
}
