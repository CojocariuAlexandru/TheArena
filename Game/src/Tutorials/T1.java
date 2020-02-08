package Tutorials;

import java.awt.Graphics;

import GameMain.GAME;
import GameMain.State;

public class T1 extends State{
	private long time, timec;
	private int t=0;
	
	public T1(GAME game) {
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
		if(timec - time >= 0.5){
			if(game.GetKeyHandler().left == true){
				t=0;
				State.setState(game.menuState);
				}
			if(game.GetKeyHandler().right == true){
				t=0;
				State.setState(game.tut2State);
				}
			}
		}

	public void render(Graphics g) {
		g.drawImage(game.t1, 0, 0, null);
		}

}
