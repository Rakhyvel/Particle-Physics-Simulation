package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * The keyboard class gets keyboard input from the user. It stores these key
 * inputs in key objects that return whether or not they are being pressed
 * 
 * @author Rakhyvel
 */
public class Keyboard extends KeyAdapter {

	private String letter = "";

	@Override
	public void keyPressed(KeyEvent e) {
		setKey(e.getKeyCode(), true);
		letter = String.valueOf(e.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		setKey(e.getKeyCode(), false);
		letter = "";
	}

	// This is where keys are set to true or false
	public void setKey(int keyCode, boolean pressed) {
		if (keyCode == KeyEvent.VK_ESCAPE) {
			esc.setPressed(pressed);
		}
		if (keyCode == KeyEvent.VK_EQUALS) {
			plus.setPressed(pressed);
		}
		if (keyCode == KeyEvent.VK_MINUS) {
			minus.setPressed(pressed);
		}
		if (keyCode == KeyEvent.VK_PERIOD) {
			period.setPressed(pressed);
		}
		if (keyCode == KeyEvent.VK_COMMA) {
			comma.setPressed(pressed);
		}
		if (keyCode == KeyEvent.VK_CONTROL) {
			ctrl.setPressed(pressed);
		}
		if (keyCode == KeyEvent.VK_SHIFT) {
			shift.setPressed(pressed);
		}
		if (keyCode == KeyEvent.VK_P) {
			p.setPressed(pressed);
		}
	}

	public Key esc = new Key();
	public Key plus = new Key();
	public Key minus = new Key();
	public Key period = new Key();
	public Key comma = new Key();
	public Key ctrl = new Key();
	public Key shift = new Key();
	public Key p = new Key();

	/**
	 * Holds information pertaining to whether or not the key is pressed or released.
	 * 
	 * @author Rakhyvel
	 *
	 */
	public class Key {

		private boolean pressed = false;

		/**
		 * @return  Whether the key is pressed or not.
		 */
		public boolean isPressed() {
			return pressed;
		}

		/**
		 * Sets whether the key is pressed. Should only be accessed by Keyboard object
		 * 
		 * @param pressed  Whether or not the key is pressed.
		 */
		private void setPressed(boolean pressed) {
			this.pressed = pressed;
		}
	}

	public String getLetter() {
		return letter;
	}
}
