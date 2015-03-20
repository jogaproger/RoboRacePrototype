package modell.palya;

import modell.Jatek;
import skeleton.Logger;

/**
 *	Pálya osztály
 */
public class Palya {

	private static final int meret = 4;
	private int szelesseg, magassag;
	private Cella[][] cellak;
	private Jatek jatek;
	
	/**
	 * Pálya létrehozása
	 * @param j A játék, amelyhez a pálya tartozik
	 * 
	 */
	public Palya(Jatek j){
		Logger.printCall(this, j);
		jatek = j;
		szelesseg = magassag = meret;
		cellak = new Cella[szelesseg][magassag];
		
		Logger.printCallEnd();	
	}
	
	public void betolt( String fajl ){
		Logger.printCall(this, fajl);
		
		Logger.printCallEnd();	
	}
	
	public void getStartCell( int i ){
		Logger.printCall(this, ""+i);
		
		Logger.printCallEnd();	
	}
	
	Cella cellaxy( int x, int y ){
		Logger.printCall(this, ""+x, ""+y);
		
		Logger.printCallEnd();	
		return cellak[x][y];
	}
}
