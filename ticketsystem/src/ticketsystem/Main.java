package ticketsystem;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		Bildschirm unserBildschirm = new Bildschirm();
		unserBildschirm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		unserBildschirm.setSize(800, 600);
		unserBildschirm.setVisible(true);

}
}