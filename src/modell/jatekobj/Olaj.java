package modell.jatekobj;

import skeleton.Logger;

public class Olaj extends JatekObj{
	
	/**
	 * Default konstruktor
	 */
	public Olaj(){
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
	 * Megcsusztatja a robotot
	 */
	public void ralep(Robot r) {
		Logger.printCall(this, r);
		r.csusztat();
		Logger.printCallEnd();
	}
	
	


}
