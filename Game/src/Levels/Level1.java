package Levels;

import java.awt.Graphics;
import java.util.Random;

import GameMain.GAME;
import GameMain.Player;
import GameMain.State;

public class Level1 extends State{
	private Player player;
	private int esteprov = 0;
	private int colt = 0;
	public static int succes = 0;
	private long time, timecurrent;
	private Random randomGenerator;
	
	public Level1(GAME game){
		super(game);
		player = new Player(game, 100, 100);
		randomGenerator = new Random();
		}
	
	public void update() {
		player.update();
		if(game.GetKeyHandler().backmenu)
			State.setState(GAME.menuState);
		if(esteprov == 0){
			time = System.nanoTime()/1000000000;
			colt = randomGenerator.nextInt(4);
			esteprov = 1;
			timecurrent = time;
			}
			else if(esteprov == 1){
				timecurrent =System.nanoTime()/1000000000;
				if(timecurrent - time >= 3){
					if(colt == 0 && (player.getX() >= 1150/2 || player.getY() >= 700/2)){
						State.setState(game.menuState);
						}
					if(colt == 1 && (player.getX() <= 1150/2 || player.getY() >= 700/2)){
						State.setState(game.menuState);
						}
					if(colt == 2 && (player.getX() <= 1150/2 || player.getY() <= 700/2)){
						State.setState(game.menuState);
						}
					if(colt == 3 && (player.getX() >= 1150/2 || player.getY() <= 700/2)){
						State.setState(game.menuState);
						}
					esteprov = 0;
					succes++;
					}
				}
		if(succes == 5){
			succes = 0;
			State.setState(game.l2prepState);
			}
		}

	public void render(Graphics g) {
		g.drawImage(GAME.arena, 0, 0, null);
		player.render(g);
		drawchallenge(g);
		}
	
	private void drawchallenge(Graphics g){
		if(timecurrent - time < 1){
			if(colt == 0){
				g.drawImage(game.three, 0, 0, null);
				}
				else if(colt == 1){
					g.drawImage(game.three, 1150-112, 0, null);
					}
					else if(colt == 2){
						g.drawImage(game.three, 1150-112, 700-112, null);
						}
						else if(colt == 3){
							g.drawImage(game.three, 0, 700-112, null);
							}
			}
			else if(timecurrent - time < 2){
				if(colt == 0){
					g.drawImage(game.two, 0, 0, null);
					}
					else if(colt == 1){
						g.drawImage(game.two, 1150-112, 0, null);
						}
						else if(colt == 2){
							g.drawImage(game.two, 1150-112, 700-112, null);
							}
							else if(colt == 3){
								g.drawImage(game.two, 0, 700-112, null);
								}
				}
				else if(timecurrent - time < 3){
					if(colt == 0){
						g.drawImage(game.one, 0, 0, null);
						}
						else if(colt == 1){
							g.drawImage(game.one, 1150-112, 0, null);
							}
							else if(colt == 2){
								g.drawImage(game.one, 1150-112, 700-112, null);
								}
								else if(colt == 3){
									g.drawImage(game.one, 0, 700-112, null);
									}
					}
		}

}
