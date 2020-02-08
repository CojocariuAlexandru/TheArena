package GameMain;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import Display.GameDisplay;
import Levels.Level1;
import Levels.Level2;
import Levels.Level3;
import Levels.Level4;
import Levels.Level5;
import Preparation.L1Prep;
import Preparation.L2Prep;
import Preparation.L3Prep;
import Preparation.L4Prep;
import Preparation.L5Prep;
import Preparation.TutRead;
import Preparation.TutReadSure;
import Tutorials.T1;
import Tutorials.T2;
import Tutorials.T3;
import Tutorials.T4;
import Tutorials.T5;

public class GAME implements Runnable{
	public int width;
	public int height;
	public String title;
	private GameDisplay display;
	private boolean running = false;
	public Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	public static BufferedImage imagine, MenuImg, PlayButton, PlayButtonBlue, InfoImg, InfoImgBlue, informatii, ExitButton, ExitButtonBlue, TutorialButton, TutorialButtonBlue, Tureta, arena, one, two, three;
	public static BufferedImage read, sure, l1, l2, l3, l4, l5, enemy, t1, t2, t3, t4, t5;
	public int FPS;
	public double NanoPeFrame;
	public double Delta;
	public long Now;
	public long LastTime;
	public static State tut1State, tut2State, tut3State, tut4State, tut5State, level1State, level2State, level3State, level4State, level5State, menuState, infoState, TutReadState, TutReadSureState, l1prepState, l2prepState, l3prepState, l4prepState, l5prepState;
	private KeyHandler keyhandler;
	private MouseHandler mousehandler;
	
	GAME(int width, int height, String title){
		this.width = width;
		this.height = height;
		this.title = title;
		keyhandler = new KeyHandler();
		mousehandler = new MouseHandler();
		}
	
	public void init(){
		display = new GameDisplay(width, height, title);
		imagine = ImageLoader.loadImage("/textures/Patrat.png");
		MenuImg = ImageLoader.loadImage("/background/MenuBackground.png");
		PlayButton = ImageLoader.loadImage("/background/PlayButton.png");
		PlayButtonBlue = ImageLoader.loadImage("/background/PlayButtonBlue.png");
		InfoImg = ImageLoader.loadImage("/background/InfoButton.png");
		InfoImgBlue = ImageLoader.loadImage("/background/InfoButtonBlue.png");
		informatii = ImageLoader.loadImage("/background/informatii.png");
		ExitButton = ImageLoader.loadImage("/background/ExitButton.png");
		ExitButtonBlue = ImageLoader.loadImage("/background/ExitButtonBlue.png");
		TutorialButton = ImageLoader.loadImage("/background/TutorialButton.png");
		TutorialButtonBlue = ImageLoader.loadImage("/background/TutorialButtonBlue.png");
		arena = ImageLoader.loadImage("/gamepic/arena.png");
		Tureta = ImageLoader.loadImage("/textures/Tureta.png");
		one = ImageLoader.loadImage("/gamepic/one.png");
		two = ImageLoader.loadImage("/gamepic/two.png");
		three = ImageLoader.loadImage("/gamepic/three.png");
		read = ImageLoader.loadImage("/prep/citit.png");
		sure = ImageLoader.loadImage("/prep/sigur.png");
		l1 = ImageLoader.loadImage("/prep/Level1prep.png");
		l2 = ImageLoader.loadImage("/prep/Level2prep.png");
		l3 = ImageLoader.loadImage("/prep/Level3prep.png");
		l4 = ImageLoader.loadImage("/prep/Level4prep.png");
		l5 = ImageLoader.loadImage("/prep/Level5prep.png");
		t1 = ImageLoader.loadImage("/tutpic/Tutorial1.png");
		t2 = ImageLoader.loadImage("/tutpic/Tutorial2.png");
		t3 = ImageLoader.loadImage("/tutpic/Tutorial3.png");
		t4 = ImageLoader.loadImage("/tutpic/Tutorial4.png");
		t5 = ImageLoader.loadImage("/tutpic/Tutorial5.png");
		enemy = ImageLoader.loadImage("/gamepic/enemy.png");
		FPS = 60;
		NanoPeFrame = 1000000000/FPS;
		Delta = 0;
		level1State = new Level1(this);
		level2State = new Level2(this);
		level3State = new Level3(this);
		level4State = new Level4(this);
		level5State = new Level5(this);
		menuState = new MenuState(this);
		infoState = new InfoState(this);
		TutReadState = new TutRead(this);
		TutReadSureState = new TutReadSure(this);
		l1prepState = new L1Prep(this);
		l2prepState = new L2Prep(this);
		l3prepState = new L3Prep(this);
		l4prepState = new L4Prep(this);
		l5prepState = new L5Prep(this);
		tut1State = new T1(this);
		tut2State = new T2(this);
		tut3State = new T3(this);
		tut4State = new T4(this);
		tut5State = new T5(this);
		State.setState(menuState);
		
		display.GetFrame().addKeyListener(keyhandler);
		display.GetFrame().addMouseListener(mousehandler);
		display.GetFrame().addMouseMotionListener(mousehandler);
		display.GetCanvas().addMouseListener(mousehandler);
		display.GetCanvas().addMouseMotionListener(mousehandler);
		}
	
	public void update(){
		keyhandler.update();
		if(State.getState() != null)
			State.getState().update();
		}
	
	public void render(){
		bs = display.GetCanvas().getBufferStrategy();
		if(bs == null){
			display.GetCanvas().createBufferStrategy(3);
			return;
			}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		if(State.getState() != null)
			State.getState().render(g);

		
		bs.show();
		g.dispose();
		}
	
	public void run() {
		init();
		LastTime = System.nanoTime();
		while(running){
			Now = System.nanoTime();
			Delta += (Now - LastTime) / NanoPeFrame;
			LastTime = Now;
			if(Delta >= 1){
				update();
				render();
				Delta--;
				}
			}
		stop();
		}
	
	public KeyHandler GetKeyHandler(){
		return keyhandler;
		}
	
	public MouseHandler GetMouseHandler(){
		return mousehandler;
		}
	
	public synchronized void start(){
		if(running == true)
			return;
			else{
				running = true;
				thread = new Thread(this);
				thread.start();
				}
		}
	
	public synchronized void stop(){
		if(running == false)
			return;
			else if(running == true){
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
					}
				}	
			}
	

}
