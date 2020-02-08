package Tutorials;

import java.awt.Graphics;

import GameMain.GAME;
import GameMain.State;

public class T4 extends State{
	private long time, timec;
	private int t=0;
	
	public T4(GAME game) {
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
				State.setState(game.tut3State);
				}
			if(game.GetKeyHandler().right == true){
				t=0;
				State.setState(game.tut5State);
				}
			}
		}

	public void render(Graphics g) {
		g.drawImage(game.t4, 0, 0, null);
		}

}
