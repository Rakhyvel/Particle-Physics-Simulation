package main;

import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Input{
	JFrame inputFrame = new JFrame();
	JPanel panel = new JPanel();
	Label ratioLabel = new Label("Ratio of +/-: ");
	Label quantityLabel = new Label("# of particles: ");
	Label startSize = new Label("Starting size: ");
	JTextField ratioText = new JTextField("0.5", 4);
	JTextField quantityText = new JTextField("1000", 5);
	JTextField startText = new JTextField("250", 5);
	JButton start = new JButton("Start!");
	
	public Input(Main main) {
		window();
	}
	
	void window() {
		inputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		inputFrame.setResizable(false);
		inputFrame.setTitle("Particle Physics Sim");
		inputFrame.setAlwaysOnTop(true);
		panel.setLayout(new FlowLayout());
		
		panel.add(ratioLabel);
		ratioText.setHorizontalAlignment(4);
		panel.add(ratioText);
		
		panel.add(quantityLabel);
		quantityText.setHorizontalAlignment(4);
		panel.add(quantityText);
		
		panel.add(startSize);
		startText.setHorizontalAlignment(4);
		panel.add(startText);

		panel.add(start);
		
		inputFrame.add(panel);
		inputFrame.setSize(512, 100);
		inputFrame.setVisible(true);
		inputFrame.setLocationRelativeTo(null);
	}
}
