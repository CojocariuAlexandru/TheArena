package Levels;

import java.awt.Graphics;
import java.util.Random;

import GameMain.GAME;
import GameMain.Player;
import GameMain.State;
import GameMain.enemy;

public class Level4 extends State{
	private Player player;
	private int esteprov = 0;
	private int colt = 0;
	public static int succes = 0;
	private long time, timecurrent;
	private Random randomGenerator;
	public enemy obs1, obs2, obs3, obs4, obs5, obs6, obs7, obs8;
	
	public Level4(GAME game){
		super(game);
		player = new Player(game, 100, 100);
		randomGenerator = new Random();
		obs1 = new enemy(0, (700/2)-12, 1150-12, (700/2)-12, game);
		obs2 = new enemy((1150/2)-12, 0, (1150/2)-12, 700-12, game);
		
		obs3 = new enemy(0, (700/2)-60, 1150-12, (700/2)-60, game);
		obs4 = new enemy(0, (700/2)+38, 1150-12, (700/2)+38, game);
		
		obs5 = new enemy((1150/2)-72, 0, (1150/2)-72, 700-12, game);
		obs6 = new enemy((1150/2)+48, 0, (1150/2)+48, 700-12, game);
		
		obs7 = new enemy((1150/2)-150, 0, (1150/2)-150, 700-12, game);
		obs8 = new enemy((1150/2)+126, 0, (1150/2)+126, 700-12, game);
		obs7.speeden = 10;
		obs8.speeden = 10;
		}
	
	public void update() {
		player.update();
		obs1.update();
		obs2.update();
		obs3.update();
		obs4.update();
		obs5.update();
		obs6.update();
		obs7.update();
		obs8.update();
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
			State.setState(game.l5prepState);
			}
		}

	public void render(Graphics g) {
		g.drawImage(GAME.arena, 0, 0, null);
		player.render(g);
		obs1.render(g);
		obs2.render(g);
		obs3.render(g);
		obs4.render(g);
		obs5.render(g);
		obs6.render(g);
		obs7.render(g);
		obs8.render(g);
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
