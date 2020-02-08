package GameMain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.lang.Math.*;

import javax.swing.JLabel;

import GameMain.GAME;
import Valori.ValRotatie;

public class Player extends Creature{
	private GAME game;
	private int speed=5;
	private int DEFAULT_PLAYER_HEIGHT = 40;
	private int DEFAULT_PLAYER_WIDTH = 40;
	private int caz=0;
	public Player(GAME game, float x, float y) {
		super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		this.game = game;
		}

	public void update(){
		if(game.GetKeyHandler().up && y>=0){
			y -= speed;
			if(y<0)
				y=0;
			}
		if(game.GetKeyHandler().right && x<=game.width-width){
			x += speed;
			if(x > game.width-width)
				x = game.width-width;
			}
		if(game.GetKeyHandler().down && y<=game.height-height){
			y += speed;
			if(y > game.height-height)
				y=game.height-height;
			}
		if(game.GetKeyHandler().left && x>=0){
			x -= speed;
			if(x < 0)
				x=0;
			}
		if(game.GetKeyHandler().backmenu){
			x=100;
			y=100;
			}
		}

	public void render(Graphics g) {
		setarecaz((int)x, (int)y);
		if(caz == 1)
			g.setColor(Color.ORANGE);
				else if(caz == 2)
				g.setColor(Color.RED);
					else if(caz == 3)
					g.setColor(Color.GREEN);
						else
						g.setColor(Color.BLUE);
		g.fillRect((int)x, (int)y, DEFAULT_PLAYER_HEIGHT,  DEFAULT_PLAYER_WIDTH);
		}
	
	private void setarecaz(int x1, int y1){
		if(y1 >= 350 && 575 >= x1)
			caz = 1;
		else if(350 > y1 && 575>=x1)
			caz = 2;
		else if(350 > y1 && 575 < x1)
			caz = 3;
		else
			caz = 4;
		}
	public static int getXINT(){
		int xg = (int)x;
		return xg;
		}
	public static int getYINT(){
		int yg = (int)y;
		return yg;
		}
}

