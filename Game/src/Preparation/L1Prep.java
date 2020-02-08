package Preparation;
import java.awt.Graphics;
import java.util.Random;

import GameMain.GAME;
import GameMain.Player;
import GameMain.State;

public class L1Prep extends State{
	
	private long time, timec;
	private int t=0;
	
	public L1Prep(GAME game){
		super(game);
		}

	public void update() {
		if(t==0){
			time = System.nanoTime() / 1000000000;
			timec = time;
			t = 1;
			}
			else{
				timec = System.nanoTime() / 1000000000;
				}
		if(timec - time >= 5){
			t=0;
			State.setState(game.level1State);
			}
		Player.x = 100;
		Player.y = 100;
		}

	public void render(Graphics g) {
		g.drawImage(game.l1, 0, 0, null);
		}

}
