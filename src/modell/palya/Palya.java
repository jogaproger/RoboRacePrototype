package modell.palya;

import modell.Jatek;
import modell.jatekobj.Ragacs;
import main.Logger;

/**
 *	Pálya osztály
 */
public class Palya {
	
	/** Palya alapertelmezett merete */
	private static final int meret = 4;
	/** Palya szelessege, magassaga */
	private int szelesseg, magassag;
	/** Palyakat alkoto cellak */
	private Cella[][] cellak;
	/** Jatek amelyhez a palya tartozik */
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
	/**
	 * Palya betoltese fajlbol
	 * @param fajl Fajl neve
	 */
	public void betolt( String fajl ){
		Logger.printCall(this, fajl);

		cellak[0][0] = new Cella(this, 0, 0);
		cellak[1][1] = new Cella(this, 1, 1);

		Ragacs ragacs = new Ragacs();
		cellak[1][1].add(ragacs);
		jatek.addJatekObj(ragacs);
		
		Logger.printCallEnd();	
	}
	/**
	 * i. kezdocella lekerdezese
	 * @param i Sorszam
	 * @return Valamelyik sarokcella i-tol fuggoen
	 */
	public Cella getStartCell( int i ){
		Logger.printCall(this, new Integer(i));
		Logger.printCallEnd();	
		return cellak[0][0];
	}
	/**
	 * cella lekerdese az X,Y helyen
	 * @param x X koordinata
	 * @param y Y koordinata
	 * @return az adott cella, null ha nincs a palyan
	 */
	Cella cellaxy( int x, int y ){
		Logger.printCall(this, ""+x, ""+y);
		Logger.printCallEnd();	
		// Ha palyan kivul esunk
		if( x < 0 || y < 0 || x >= szelesseg || y >= magassag )
			return null;
		else
			return cellak[x][y];
	}
}
