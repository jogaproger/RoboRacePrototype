package modell.jatekobj;

import main.Logger;
import modell.palya.Cella;
import modell.visitors.JOVisitor;
/**
 * Absztrakt jatekobjektum 
 */
public abstract class JatekObj {
	protected Cella cella;
	
	/**
	 * Pillanatnyi muveletek vegrehajtasa
	 */
	public abstract void simulate();
	
	/**
	 * Megadja mit csinal, ha robot lep az objektumra
	 * @param r A robot, amely ralep
	 */
	public abstract void ralep(Robot r);
	
	/**
	 * Hozzaadjuk egy cellahoz
	 */
	public void addToCella(Cella c) {
		Logger.printCall(this, c);
		cella = c;
		c.add(this);
		Logger.printCallEnd();
	}
	
	public abstract void accept(JOVisitor visitor);
	
	public abstract void info();
	
	

}
