package main;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.GameController;

public class Hangdude implements Runnable {
	public GameController gameController;
	
	public static void main(String... args) {
		Hangdude hangdude = new Hangdude();
		hangdude.run();
	}
	
	public Hangdude() {
		gameController = new GameController();
        JFrame frame = new JFrame("JFrame Example");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("This is a label!");
        JButton button = new JButton();
        button.setText("Press me");
        panel.add(label);
        panel.add(button);
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	public void run() {
		while (true) {
			gameController.runGame();
		}
	}
}
