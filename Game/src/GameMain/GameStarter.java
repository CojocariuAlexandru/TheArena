package GameMain;
import java.awt.*;
import javax.swing.*;
import Display.GameDisplay;

public class GameStarter {
	public static void main(String args[]){
		GAME game = new GAME(1150, 700, "Titlu");
		game.start();
		}
}
