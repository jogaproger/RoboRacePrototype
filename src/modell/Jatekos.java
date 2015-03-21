package modell;


import modell.jatekobj.Robot;
import modell.palya.Irany;
import skeleton.Logger;

/**
 * Jatekos osztaly
 */
public class Jatekos {
	/** Jatekos pontszama */
	private int pontszam;
	/** Jatekos neve */
	private String nev;
	/** Jatekos robotja */
	private Robot robot;
	
	public Jatekos( String nev )
	{
		Logger.printCall(this, nev);
		
		// Nev beallitasa
		this.nev = nev;
		robot = new Robot();
		pontszam = 0;
		
		// A jateknak is tudnia kell a robotunkrol
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
	
	public void iranyit(){
		Logger.printCall(this);
			
		int i = Logger.askQuestion(
					"Mit szeretnel csinalni a robotoddal?",
					"Fel iranyit", 
					"Le iranyit", 
					"Ragacsot lerak", 
					"Olajfoltot lerak"
				);
		switch( i )
		{
		case 0: Logger.printMessage("Rossz ertek, semmi sem fog tortenni!");
		case 1: robot.iranyit(Irany.Fel);break;
		case 2: robot.iranyit(Irany.Le);break;
		case 3: robot.lerakRagacs();break;
		case 4: robot.lerakOlaj();break;
		
		}
		
		
		Logger.printCallEnd();		
	}
	
}
