package modell.jatekobj;

import main.Logger;

public class Blokk extends JatekObj {
	
	/**
	 * Default konstruktor
	 */
	public Blokk(){
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
	 * Megoli a robotot
	 */
	public void ralep(Robot r) {
		Logger.printCall(this, r);
		r.kill();
		Logger.printCallEnd();
	}

}
