package modell.jatekobj;

import skeleton.Logger;

public class Blokk extends JatekObj {
	
	public void simulate() {
		Logger.printCall(this);
		ss
		Logger.printCallEnd();
	}
	
	public void ralep(Robot r) {
		Logger.printCall(this, r);
		
		Logger.printCallEnd();
	}

}
