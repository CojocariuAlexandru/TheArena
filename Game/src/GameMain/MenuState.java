package GameMain;

import java.awt.Color;
import java.awt.Graphics;

import Levels.Level1;
import Levels.Level2;
import Levels.Level3;
import Levels.Level4;
import Levels.Level5;

public class MenuState extends State{
	private float pozX, pozY, pozX2, pozY2, pozX3, pozY3, pozX4, pozY4;
	private int direction, direction2, direction3, direction4;
	private float speedPBKv, speedPBKo;
	private int dimPBK;
	private int alpha;
	private Color culoarePBK1, culoarePBK2, culoarePBK3, culoarePBK4;
	Level1 lv1;
	Level2 lv2;
	Level3 lv3;
	Level4 lv4;
	Level5 lv5;
	public MenuState(GAME game){
		super(game);
		alpha = 120;
		culoarePBK1 = new Color(0, 0, 255, alpha);
		culoarePBK2 = new Color(0, 255, 0, alpha);
		culoarePBK3 = new Color(255, 0, 0, alpha);
		culoarePBK4 = new Color(255, 160, 0, alpha);
		dimPBK = 40;
		speedPBKv = 3.0f;
		speedPBKo = 5.19f;
		pozY2 = game.height-dimPBK;
		pozX2 = game.width-dimPBK;
		pozX3 = 0;
		pozY3 = game.height-dimPBK;
		pozX4 = game.width-dimPBK;
		pozY4 = 0;
		direction4 = 3;
		}
	
	public void update() {
		DetermineMovement1(pozX, pozY, direction);
		DetermineMovement2(pozX2, pozY2, direction2);
		DetermineMovement3(pozX3, pozY3, direction3);
		DetermineMovement4(pozX4, pozY4, direction4);
		lv1.succes = 0;
		lv2.succes = 0;
		lv3.succes = 0;
		lv4.succes = 0;
		lv5.succes = 0;
		
		if(game.GetMouseHandler().leftPressed == true && LocationPlay() == true){
			State.setState(game.TutReadState);
			}
		if(game.GetMouseHandler().leftPressed == true && LocationInfo() == true){
			State.setState(game.infoState);
			}
		if(game.GetMouseHandler().leftPressed == true && LocationTut() == true){
			State.setState(game.tut1State);
			}
		if(game.GetMouseHandler().leftPressed == true && LocationExit() == true){
			System.exit(0);
			}
		}

	public void render(Graphics g) {
		g.drawImage(game.MenuImg, 0,  0, null);
		if(LocationPlay() == false)
			g.drawImage(game.PlayButton, 380, 230, null);
			else if(LocationPlay() == true)
				g.drawImage(game.PlayButtonBlue, 380, 230, null);
		if(LocationInfo() == false)
			g.drawImage(game.InfoImg, 1060,  610, null);
			else if(LocationInfo() == true)
				g.drawImage(game.InfoImgBlue, 1060,  610, null);
		if(LocationExit() == false)
			g.drawImage(game.ExitButton, 380, 550, null);
			else if(LocationExit() == true)
				g.drawImage(game.ExitButtonBlue, 380, 550, null);
		if(LocationTut() == false)
			g.drawImage(game.TutorialButton, 280, 385, null);
			else if(LocationTut() == true)
				g.drawImage(game.TutorialButtonBlue, 280, 385, null);
		g.setColor(culoarePBK1);
		g.fillRect((int)pozX, (int)pozY, dimPBK, dimPBK);
		g.setColor(culoarePBK2);
		g.fillRect((int)pozX2, (int)pozY2, dimPBK, dimPBK);
		g.setColor(culoarePBK3);
		g.fillRect((int)pozX3, (int)pozY3, dimPBK, dimPBK);
		g.setColor(culoarePBK4);
		g.fillRect((int)pozX4, (int)pozY4, dimPBK, dimPBK);
		}
	
	private boolean LocationPlay(){
		if(game.GetMouseHandler().getmouseX()>=440 && game.GetMouseHandler().getmouseY()>=230 && game.GetMouseHandler().getmouseX() <= 730 && game.GetMouseHandler().getmouseY() <= 360){
			return true;
			}
			else
			return false;
		}
	
	private boolean LocationInfo(){
		if(game.GetMouseHandler().getmouseX()>=1060 && game.GetMouseHandler().getmouseY()>=610 && game.GetMouseHandler().getmouseX() <= 1150 && game.GetMouseHandler().getmouseY() <= 700){
			return true;
			}
			else
			return false;
		}
	
	private boolean LocationExit(){
		if(game.GetMouseHandler().getmouseX()>=420 && game.GetMouseHandler().getmouseY()>=560 && game.GetMouseHandler().getmouseX() <= 740 && game.GetMouseHandler().getmouseY() <= 710){
			return true;
			}
			else
			return false;
		}
	
	private boolean LocationTut(){
		if(game.GetMouseHandler().getmouseX()>=320 && game.GetMouseHandler().getmouseY()>=395 && game.GetMouseHandler().getmouseX() <= 860 && game.GetMouseHandler().getmouseY() <= 525){
			return true;
			}
			else
			return false;
		}
	
	public void DetermineMovement1(float x, float y, int dir){
		//JOS
		if(dir == 0){
			y += speedPBKv;
			if(y > game.height-dimPBK){
				dir = 2;
				}
			}
		//SUS
		if(dir == 1){
			y -= speedPBKv;
			if(y < 0){
				dir = 3;
				}
			}
		//DREAPTA
		if(dir == 2){
			x += speedPBKo;
			if(x > game.width-dimPBK){
				dir = 1;
				}
			}
		//STANGA
		if(dir == 3){
			x -= speedPBKo;
			if(x < 0)
				dir = 0;
			}
		pozY = y;
		pozX = x;
		direction = dir;
		}
	
	public void DetermineMovement2(float x, float y, int dir){
		//JOS
		if(dir == 0){
			y += speedPBKv;
			if(y > game.height-dimPBK){
				dir = 2;
				}
			}
		//SUS
		if(dir == 1){
			y -= speedPBKv;
			if(y < 0){
				dir = 3;
				}
			}
		//DREAPTA
		if(dir == 2){
			x += speedPBKo;
			if(x > game.width-dimPBK){
				dir = 1;
				}
			}
		//STANGA
		if(dir == 3){
			x -= speedPBKo;
			if(x < 0)
				dir = 0;
			}
		pozY2 = y;
		pozX2 = x;
		direction2 = dir;
		}


	public void DetermineMovement3(float x, float y, int dir){
		//JOS
		if(dir == 0){
			y += speedPBKv;
			if(y > game.height-dimPBK){
				dir = 2;
				}
			}
		//SUS
		if(dir == 1){
			y -= speedPBKv;
			if(y < 0){
				dir = 3;
				}
			}
		//DREAPTA
		if(dir == 2){
			x += speedPBKo;
			if(x > game.width-dimPBK){
				dir = 1;
				}
			}
		//STANGA
		if(dir == 3){
			x -= speedPBKo;
			if(x < 0)
				dir = 0;
			}
		pozY3 = y;
		pozX3 = x;
		direction3 = dir;
		}

	public void DetermineMovement4(float x, float y, int dir){
		//JOS
		if(dir == 0){
			y += speedPBKv;
			if(y > game.height-dimPBK){
				dir = 2;
				}
			}
		//SUS
		if(dir == 1){
			y -= speedPBKv;
			if(y < 0){
				dir = 3;
				}
			}
		//DREAPTA
		if(dir == 2){
			x += speedPBKo;
			if(x > game.width-dimPBK){
				dir = 1;
				}
			}
		//STANGA
		if(dir == 3){
			x -= speedPBKo;
			if(x < 0)
				dir = 0;
			}
		pozY4 = y;
		pozX4 = x;
		direction4 = dir;
		}
}
