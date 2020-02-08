package Preparation;
import java.awt.Graphics;
import java.util.Random;

import GameMain.GAME;
import GameMain.Player;
import GameMain.State;

public class TutReadSure extends State{
	
	private long time, timec;
	private int t=0;
	
	public TutReadSure(GAME game){
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
		if(game.GetKeyHandler().left == true){
			t=0;
			State.setState(game.menuState);
			}
		if(timec - time >= 0.5){
			if(game.GetKeyHandler().right == true){
				t = 0;
				State.setState(game.l1prepState);
				}
			}
			
		}

	public void render(Graphics g) {
		g.drawImage(game.sure, 0, 0, null);
		}

}
