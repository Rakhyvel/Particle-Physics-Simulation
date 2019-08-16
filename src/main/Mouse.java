package main;

import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Gets mouse input from the user. Handles mouse presses and the position of the mouse.
 * 
 * @author Rakhyvel
 *
 */
public class Mouse extends MouseAdapter {
	private boolean mouseLeftDown = false;
	private boolean mouseRightDown = false;

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			mouseLeftDown = true;
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			mouseRightDown = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			mouseLeftDown = false;
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			mouseRightDown = false;
		}
	}

	/**
	 * @return  The x coordinate of the position of the mouse relative to the top-left corner of the screen.
	 */
	public int getX() {
		return (int) MouseInfo.getPointerInfo().getLocation().getX() - Main.WIDTH-3;
	}

	/**
	 * @return  The y coordinate of the position of the mouse relative to the top-left corner of the screen
	 * -24 for windows
	 * -37 for mac
	 */
	public int getY() {
		return (int) MouseInfo.getPointerInfo().getLocation().getY() - Main.HEIGHT-24;
	}

	/**
	 * @return  Whether the left mouse button (MouseEvent.BUTTON1) is pressed
	 */
	public boolean getMouseLeftDown() {
		return mouseLeftDown;
	}

	/**
	 * @return  Whether the right mouse button (MouseEvent.BUTTON3) is pressed
	 */
	public boolean getMouseRightDown() {
		return mouseRightDown;
	}
}
