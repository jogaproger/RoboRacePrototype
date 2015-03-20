package modell.jatekobj;

import skeleton.Logger;
import modell.Jatek;
import modell.palya.Cella;
import modell.palya.Irany;
import modell.palya.Sebesseg;

public class Robot extends JatekObj{

	private enum RobotAllapot{
		HALOTT, ALLO, UGRO		
	};
	RobotAllapot allapot;
	
	private Sebesseg seb;
	private Cella forras;
	private Cella cel;
	private Irany irany;
	private int ragacsnum;
	private int olajnum;
	private boolean csusztatott;
	private int ugrasido;
	
	
	public void simulate() {
		Logger.printCall(this);
		
		Logger.printCallEnd();
	}
	
	public void ralep(Robot r) {
		Logger.printCall(this, r);
		
		Logger.printCallEnd();
	}
	
	public void kill() {
		Logger.printCall(this);
		
		Logger.printCallEnd();
	}
	
	public void lassit() {
		Logger.printCall(this);
		
		Logger.printCallEnd();
	}
	
	public void csusztat() {
		Logger.printCall(this);
		
		Logger.printCallEnd();
	}
	
	public void iranyit(Irany i) {
		Logger.printCall(this, i);
		
		Logger.printCallEnd();
	}
	
	public void lok(Sebesseg seb) {
		Logger.printCall(this, seb);
		
		Logger.printCallEnd();
	}
	
	public void lerakRagacs() {
		Logger.printCall(this);
		
		Logger.printCallEnd();
	}
	
	public void lerakOlaj() {
		Logger.printCall(this);
		
		Logger.printCallEnd();
	}
	
	
	
	
}
