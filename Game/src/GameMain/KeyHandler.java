package GameMain;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	private boolean[] keys;
	public boolean up, right, down, left, backmenu;
	
	public KeyHandler(){
		keys = new boolean[256];
		}
	
	public void update(){
		up = keys[KeyEvent.VK_W] | keys[KeyEvent.VK_UP];
		right = keys[KeyEvent.VK_D] | keys[KeyEvent.VK_RIGHT];
		down = keys[KeyEvent.VK_S] | keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_A] | keys[KeyEvent.VK_LEFT];
		backmenu = keys[KeyEvent.VK_ESCAPE];
		}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		}

	public void keyTyped(KeyEvent e) {
		
		}

}
