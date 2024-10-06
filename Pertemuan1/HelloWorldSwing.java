package Pertemuan1;
import javax.swing.*;

public class HelloWorldSwing {
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("TugasPengenalanJFC");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Hello, Daniel");
		frame.getContentPane().add(label);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}