package GameMain;

import java.awt.Color;
import java.awt.Graphics;

public class InfoState extends State{
	public InfoState(GAME game){
		super(game);
		}
	public void update() {
		if(game.GetKeyHandler().backmenu)
			State.setState(GAME.menuState);
		}

	public void render(Graphics g) {
		g.drawImage(GAME.informatii, 0,  0, null);
		}

}
