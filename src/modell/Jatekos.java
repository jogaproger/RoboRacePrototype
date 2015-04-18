package modell;


import modell.jatekobj.Robot;
import modell.palya.Irany;
import modell.palya.Sebesseg;
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
	
	int sorszam = 0;
	
	public Jatekos( String nev, Jatek jatek, int sorszam )
	{
		Logger.printCall(this, nev, jatek);
		
		// Nev beallitasa
		this.nev = nev;
		this.sorszam = sorszam;
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
	
	public void iranyit( Irany i ){
		Logger.printCall(this, i.toString() );
			
		Logger.printCallEnd();		
	}
	
	public void iranyit( Sebesseg seb ){
		Logger.printCall(this, seb.toString());
			
		Logger.printCallEnd();		
	}

	public int getSorszam() {
		return sorszam;
	}
	
}
