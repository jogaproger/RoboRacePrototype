package modell.jatekobj;

import skeleton.Logger;

public class Olaj extends JatekObj{
	
	public void simulate() {
		Logger.printCall(this);
		
		Logger.printCallEnd();
	}
	
	public void ralep(Robot r) {
		Logger.printCall(this, r);
		r.csusztat();
		Logger.printCallEnd();
	}
	
	


}
