package dropbaby.Modelo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fase extends JPanel implements ActionListener {

	private Image fundo;
	private Player Player;
	private Timer timer;
	private List<Baby> baby;
	private boolean emJogo;
	

	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);

		ImageIcon referencia = new ImageIcon("imgs\\backgroundCity.jpg");
		fundo = referencia.getImage();

		Player = new Player();
		Player.load();

		addKeyListener(new TecladoAdapter());

		timer = new Timer(5, this);
		timer.start();
		
		inicializaBabys();
		emJogo = true;
	}
	
	public void inicializaBabys() {
		int coordenadas[] = new int [99];
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		if (emJogo == true) {
		graficos.drawImage(fundo, 0, 0, null);
		graficos.drawImage(Player.getImagem(), Player.getX(), Player.getY(), this);

		List<Baby> babys = Player.getBabys();
		for (int i = 0; i < babys.size(); i++) {
			Baby m = babys.get(i);
			m.load();
			graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);

		}
		}
	                                         /*	for (int o = 0; o < baby.size(); o++) {
			                                 Baby in = baby.get(o);
			                                 in.load();
			                                 graficos.drawImage(in.getImagem(),in.getX(),in.getY(), this);
				                            } */
		else {
			ImageIcon fimJogo = new ImageIcon ("imgs\\sefudeu.png");
			graficos.drawImage(fimJogo.getImage(), 0, 0, null);		
		
	}
		g.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Player.update();

		List<Baby> babys = Player.getBabys();
		for (int i = 0; i < babys.size(); i++) {
			Baby m = babys.get(i);
			if (m.isVisivel()) {
				m.update();
			} else {
				babys.remove(i);
			}
			
		} 
		
	/*	for (int o = 0; o < baby.size(); o++) {
			Baby in = baby.get(o);
				if (in.isVisivel()) {
					in.update();
				} else {
					baby.remove(o);
				}
		} 
		checarColisoes();  */
		repaint();

	}
	/*public void checarColisoes () {
		Rectangle formaPlayer;
		Rectangle formaBaby;
		
		for (int i = 0; i< baby.size(); i++) {
			Baby tempBaby = baby.get(i);
			formaBaby = tempBaby.getBounds();
					if(formaPlayer.intersects(formaBaby)) {
						Player.setVisivel(false);
						tempBaby.setVisivel(false);
						emJogo = false;
					}
		}
	} */
	
	
	

	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			Player.keyPressed(e);
		}

	}

}
