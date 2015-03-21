package modell.jatekobj;

import skeleton.Logger;
import modell.palya.Cella;
/**
 * Absztrakt jatekobjektum 
 */
public abstract class JatekObj {
	protected Cella cella;
	
	/**
	 * Pillanatnyi muveletek vegrehajtasa
	 */
	public void simulate(){
		Logger.printCall(this);
		
		Logger.printCallEnd();
	}
	/**
	 * Megadja mit csinal, ha robot lep az objektumra
	 * @param r A robot, amely ralep
	 */
	public void ralep(Robot r) {
		Logger.printCall(this, r);
		
		Logger.printCallEnd();
	}
	/**
	 * Hozzaadjuk egy cellahoz
	 */
	public void addToCella(Cella c) {
		Logger.printCall(this, c);
		cella = c;
		c.add(this);
		Logger.printCallEnd();
	}
	
	

}
