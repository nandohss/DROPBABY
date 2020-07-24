package dropbaby.Modelo;

import java.util.Random;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


import javax.swing.ImageIcon;


public class Player {

	private int x,y;
	private int dx,dy;
	private Image imagem;
	private int altura,largura;
	private List <Baby> babys;
	private boolean isVisivel;
	
	
	public Player() {
	this.x = 450;
	this.y = 480;
	isVisivel = true;
	
	babys = new ArrayList<Baby>();
	
	}
	
	public void load() {
		ImageIcon referencia = new ImageIcon("imgs\\playerUP.png");
		imagem = referencia.getImage();
		
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}
	public void update() {
		x+= dx;
		y+= dy;
	}

	
	public Rectangle getBounds() {
		return new Rectangle (x,y,largura,altura);
	}
	
	public int babySimples() {
		
		int queda = 0;
		
		do {
			queda=queda+1;
			int randomNum = ThreadLocalRandom.current().nextInt(10, 1100 + 1); //calculo randomico


			this.babys.add(new Baby(randomNum,queda)); //O bebe aparece em posição aleatória
			return randomNum;
			
			
		}
		while (queda <300);
		
	}
	
	
	public void keyPressed(KeyEvent e) {
		int codigo = e.getKeyCode();
		
		if(codigo == KeyEvent.VK_LEFT) {
			dx=-3;
		}
		if(codigo == KeyEvent.VK_RIGHT) {
			dx=3;
		}
		
		if(codigo == KeyEvent.VK_A) {
			babySimples();
			
		} 
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}

	public List<Baby> getBabys() {
		return babys;
	}

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	
}