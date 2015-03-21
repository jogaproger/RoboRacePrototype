package modell;


import modell.jatekobj.Robot;
import skeleton.Logger;

public class Jatekos {
	private int pontszam;
	private String nev;
	private Robot robot;
	
	Jatekos( String nev )
	{
		Logger.printCall(this, nev);
		this.nev = nev;
		robot = new Robot();
		
		Jatek.getInstance().addRobot(robot);
		
		Logger.printCallEnd();
	}
	
	public void addPont( int p ){
		Logger.printCall(this,  ""+p);
		
		Logger.printCallEnd();
	}
	
	public void commitPont( Ranglista r ){
		Logger.printCall(this,  ""+r);
		
		Logger.printCallEnd();		
	}
	
	public void iranyit( Ranglista r ){
		Logger.printCall(this);
			
		int i = Logger.askQuestion(
					"Merre szeretned iranyitani a robotod?(csokkentett)",
					"Fel", "Le", "Jobbra", "Balra"
				);
		
		Logger.printCallEnd();		
	}
	
}
