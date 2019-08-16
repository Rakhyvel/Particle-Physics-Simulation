package main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.JFrame;

import util.Point;

/**
 * This class is called first, it sets up the window and the world, and does the
 * game loop
 * 
 * @author Rakhyvel
 *
 */
public class Main extends Canvas {
	private static final long serialVersionUID = 4421389816626483761L;
	private static JFrame frame = new JFrame();
	private static boolean isRunning = true;
	private Random rand = new Random();

	public static World world;
	public static double zoom = 1;
	public static Keyboard keyboard = new Keyboard();
	public static Mouse mouse = new Mouse();
	
	private boolean mouseDown = false;
	public static Point center = new Point(512,288);
	private Point startPoint = null;

	public static void main(String[] args) {
		Main m = new Main();
		m.window();
		m.init();
	}

	void run() {
		while (isRunning) {
			input();
			tick();
			render();
		}
		// Pulling the plug after the game loop
		WindowEvent wev = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

		frame.setVisible(false);
		frame.dispose();
		System.exit(0);
	}

	/**
	 * Initializes objects before the game loop starts
	 */
	void init() {
		rand.setSeed(0);
		// 0.38196601125
		this.addMouseListener(mouse);
		this.addKeyListener(keyboard);
		world = new World(1 / 2.0, 1000, 600, rand);
		run();
	}

	/**
	 * Sets up the game's window
	 */
	void window() {
		frame.setSize(1024, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Particle Physics Sim");
		frame.setLocationRelativeTo(null);
		frame.add(this);
	}
	
	void input() {
		if(keyboard.minus.isPressed()) {
			zoom*=.990099009900990;
		}
		if(keyboard.plus.isPressed()) {
			zoom*=1.01;
		}
	}

	/**
	 * Calls World to render all particles
	 */
	void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		//
		world.render(g);
		//
		g.dispose();
		bs.show();
	}

	/**
	 * Calls World to calculate physics for all particles
	 */
	void tick() {
		world.tick();
	}
}
