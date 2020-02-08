package GameMain;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener{
	
	public boolean leftPressed;
	public int mouseX, mouseY;
	
	public MouseHandler(){
		
		}
	
	public void mouseDragged(MouseEvent e) {
		
		}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		}

	public void mouseClicked(MouseEvent e) {
	
		}

	public void mouseEntered(MouseEvent e) {
		
		}

	public void mouseExited(MouseEvent e) {
		
		}

	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			leftPressed = true;
			}
		}

	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			leftPressed = false;
			}
		}
	
	public boolean IsLeftPressed(){
		return leftPressed;
		}
	
	public int getmouseX(){
		return mouseX;
		}
	public int getmouseY(){
		return mouseY;
		}
}
