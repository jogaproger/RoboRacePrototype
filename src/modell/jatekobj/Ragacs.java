package modell.jatekobj;

import skeleton.Logger;

public class Ragacs extends JatekObj{
	
	public void simulate() {
		Logger.printCall(this);
		
		Logger.printCallEnd();
	}
	
	public void ralep(Robot r) {
		Logger.printCall(this, r);
		
		Logger.printCallEnd();
	}
	
	

}
