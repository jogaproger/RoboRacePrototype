package modell.jatekobj;

import skeleton.Logger;
import modell.palya.Cella;

public abstract class JatekObj {
	protected Cella cella;
	
	public void simulate(){
		Logger.printCall(this);
		
		Logger.printCallEnd();
	}
	
	public void ralep(Robot r) {
		Logger.printCall(this, r);
		
		Logger.printCallEnd();
	}
	
	public void addToCella(Cella c) {
		Logger.printCall(this, c);
		
		Logger.printCallEnd();
	}
	
	

}
