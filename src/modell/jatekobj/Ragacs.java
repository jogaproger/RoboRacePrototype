package modell.jatekobj;

import skeleton.Logger;

public class Ragacs extends JatekObj{
	
	/**
	 * Default konstruktor
	 */
	public Ragacs(){
		Logger.printCall(this);
		
		Logger.printCallEnd();
	}
	
	/**
	 * Semmit nem csinal
	 */
	public void simulate() {
		Logger.printCall(this);
		
		Logger.printCallEnd();
	}
	/**
	 * Lelassitja a robotot
	 */
	public void ralep(Robot r) {
		Logger.printCall(this, r);
		r.lassit();
		Logger.printCallEnd();
	}
	
	

}
