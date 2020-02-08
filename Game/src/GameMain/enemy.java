package GameMain;

import java.awt.Graphics;

public class enemy{
	private int xstart, ystart, xfin, yfin, xcurent, ycurent;
	private int direction=0, x2, y2;
	public int speeden;
	private float aux1, aux2;
	GAME game;
	Player player;
	public enemy(int xstart, int ystart, int xfin, int yfin, GAME game){
		this.xstart = xstart;
		this.ystart = ystart;
		this.xfin = xfin;
		this.yfin = yfin;
		this.game = game;
		xcurent = this.xstart;
		ycurent = this.ystart;
		speeden = 5;
		}
	public void update(){
		if(xstart == xfin){
			if(direction == 0){
				ycurent += speeden;
				if(ycurent >= yfin){
					ycurent = yfin;
					direction = 1;
					}
				}
				else if(direction == 1){
					ycurent -= speeden;
					if(ycurent <= ystart){
						direction = 0;
						ycurent = ystart;
						}
					}
			}
			else if(ystart == yfin){
				if(direction == 0){
					xcurent += speeden;
					if(xcurent >= xfin){
						xcurent = xfin;
						direction = 1;
						}
					}
					else if(direction == 1){
						xcurent -= speeden;
						if(xcurent <= xstart){
							direction = 0;
							xcurent = xstart;
							}
						}
				}
		x2 = Player.getXINT();
		y2 = Player.getYINT();
		if(x2 > xcurent){
			if(x2 - xcurent <= 25){
				if(y2 > ycurent){
					if(y2 - ycurent <= 25){
						State.setState(game.menuState);
						}
					}
					else if(ycurent >= y2){
						if(ycurent - y2 <= 40)
							State.setState(game.menuState);
						}	
				}
			}
		else if(xcurent >= x2){
			if(xcurent - x2 <= 40){
				if(y2 > ycurent){
					if(y2 - ycurent <= 25){
						State.setState(game.menuState);
						}
					}
					else if(ycurent >= y2){
						if(ycurent - y2 <= 40)
							State.setState(game.menuState);
						}
				}
			}
		}
	public void render(Graphics g){
		g.drawImage(game.enemy, xcurent, ycurent, null);
		}
	
}
