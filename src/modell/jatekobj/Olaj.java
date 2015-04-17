package modell.jatekobj;

import main.Logger;
import modell.visitors.JOVisitor;

public class Olaj extends Folt{
	
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

	@Override
	public void takarit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info() {
		// TODO Auto-generated method stub
		
	}
	
	


}
