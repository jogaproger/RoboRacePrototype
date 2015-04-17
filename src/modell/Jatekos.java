package modell;


import modell.jatekobj.Robot;
import modell.palya.Irany;
import main.Logger;

/**
 * Jatekos osztaly
 */
public class Jatekos {
	/** Jatek, amelyhez a jatekos tartozik */
	private Jatek jatek;
	/** Jatekos pontszama */
	private int pontszam;
	/** Jatekos neve */
	private String nev;
	/** Jatekos robotja */
	private Robot robot;
	
	public Jatekos( String nev, Jatek jatek )
	{
		Logger.printCall(this, nev, jatek);
		
		// Nev beallitasa
		this.nev = nev;
		robot = new Robot(this);
		pontszam = 0;
		
		// A jateknak is tudnia kell a robotunkrol
		jatek.addRobot(robot);
		
		Logger.printCallEnd();
	}
	
	public void addPont( int p ){
		Logger.printCall(this,  new Integer(p));
		
		Logger.printCallEnd();
	}
	
	public void commitPont( Ranglista r ){
		Logger.printCall(this,  r);
		
		Logger.printCallEnd();		
	}
	
	public void iranyit(){
		Logger.printCall(this);
			
		
		
		Logger.printCallEnd();		
	}
	
}
