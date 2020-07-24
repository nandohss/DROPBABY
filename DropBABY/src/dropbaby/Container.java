package dropbaby;

import javax.swing.JFrame;

import dropbaby.Modelo.Fase;

public class Container extends JFrame {

	public Container () {
		add(new Fase());
		setTitle("Drop BABY");
		setSize (1028,640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
	
	public static void main (String []args) {
		new Container();
	}
}