package Display;
import java.awt.*;
import javax.swing.*;

public class GameDisplay {
	public JFrame frame;
	public int width;
	public int height;
	public String title;
	public Canvas desen;	
	
	public GameDisplay(int width, int height, String title){
		this.width = width;
		this.height = height;
		this.title = title;
		WindowDisplay();
		}
	
	
	public void WindowDisplay(){
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		desen = new Canvas();
		desen.setPreferredSize(new Dimension(width, height));
		desen.setMinimumSize(new Dimension(width, height));
		desen.setMaximumSize(new Dimension(width, height));
		desen.setFocusable(false);
		
		frame.add(desen);
		frame.pack();
		}
	
	public Canvas GetCanvas(){
		return desen;
		}
	public JFrame GetFrame(){
		return frame;
		}
}
