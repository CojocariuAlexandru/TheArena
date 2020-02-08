package Preparation;
import java.awt.Graphics;
import java.util.Random;

import GameMain.GAME;
import GameMain.Player;
import GameMain.State;

public class TutRead extends State{

	public TutRead(GAME game) {
		super(game);
		}

	public void update() {
		if(game.GetKeyHandler().left == true){
			State.setState(game.menuState);
			}
		if(game.GetKeyHandler().right == true){
			State.setState(game.TutReadSureState);
			}
		}

	public void render(Graphics g) {
		g.drawImage(GAME.read, 0, 0, null);
		}

}
