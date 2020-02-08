package Valori;

public class ValRotatie {
	public static int returnDegrees(double sinus, int caz){
		//0-90 Degrees
		int dg = 0;
		if(caz == 1){
			if(sinus <= 0.087)
				dg = 0;
				else if(sinus >= 0.087 && sinus <= 0.173)
					dg = -5;
				else if(sinus >= 0.173 && sinus <= 0.258)
					dg = -10;
				else if(sinus >= 0.258 && sinus <= 0.342)
					dg = -15;
				else if(sinus >= 0.342 && sinus <= 0.422)
					dg = -20;
				else if(sinus >= 0.422 && sinus <= 0.5)
					dg = -25;
				else if(sinus >= 0.5 && sinus <= 0.573)
					dg = -30;
				else if(sinus >= 0.573 && sinus <= 0.642)
					dg = -35;
				else if(sinus >= 0.642 && sinus <= 0.707)
					dg = -40;
				else if(sinus >= 0.707 && sinus <= 0.766)
					dg = -45;
				else if(sinus >= 0.766 && sinus <= 0.819)
					dg = -50;
			}
		//90-180 Degrees
			else if(caz == 2){
			
				}
		//180-270 Degrees
				else if(caz == 3){
				
					}
		//270-360 Degrees
					else if(caz == 4){
					
						}
		return dg;
		}
}
