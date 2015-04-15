package modell.jatekobj;

import main.Logger;
import modell.Jatek;
import modell.palya.Cella;
import modell.palya.Irany;
import modell.palya.Sebesseg;

/**
 * Robot osztaly
 *
 */
public class Robot extends AbstractRobot{

	
	/** Robot sebessege */
	private Sebesseg seb;
	/** Ragacskeszlet */
	private int ragacsnum;
	/** Olajkeszlet */
	private int olajnum;
	/** IRanyithatatlan-e a robot */
	private boolean csusztatott;

	
	/**
	 * Default konstruktor
	 */
	public Robot( ) {
		super();
		Logger.printCall(this);
		
		ragacsnum = olajnum = 3;
		csusztatott = false;
		seb = new Sebesseg();
		
		Logger.printCallEnd();
	}
	/**
	 * Cselekvesek vegrehajtasa
	 */
	public void simulate() {
		Logger.printCall(this);
		
		Logger.printCallEnd();
	}
	/**
	 * Megadja mi tortenik, ha robot lep rank
	 */
	public void ralep(Robot r) {
		Logger.printCall(this, r);
		
		Logger.printCallEnd();
	}
	/**
	 * Robot megolese, allapotanak halottra valtoztatasa
	 */
	public void kill() {
		Logger.printCall(this);
                this.allapot=RobotAllapot.HALOTT;
		Logger.printCallEnd();
	}
	
	
	/**
	 * Megadja, merre modosul majd a robot sebessege a kovetkezo
	 * leerkezeskor
	 * @param i Az adott irany
	 */
	public void iranyit(Irany i) {
		Logger.printCall(this, i.toString());
		
		Logger.printMessage("irany = "+i.toString());
		irany = i;
		
		Logger.printCallEnd();
	}
	/**
	 * @param seb Sebesseg, amellyel meglokjuk a robotot
	 */
	public void lok(Sebesseg seb) {
		Logger.printCall(this, seb);
		
		this.seb = seb;
		this.allapot = RobotAllapot.UGRO;
		forras = cella;
		cel = cella.getKov(seb);
		cella = null;
		
		Logger.printCallEnd();
	}
	/**
	 * Ragacs lerakasa
	 */
	public void lerakRagacs() {
		Logger.printCall(this);
		
		if( Logger.askQuestion("Van meg ragacsod?", "Igen", "Nem") == 1 ){
			cella.add(new Ragacs());			
		}
				
		Logger.printCallEnd();
	}
	/**
	 * Olaj lerakasa
	 */
	public void lerakOlaj() {
		Logger.printCall(this);
		
		if( Logger.askQuestion("Van meg olajad?", "Igen", "Nem") == 1 ){
			cella.add(new Olaj());			
		}
		Logger.printCallEnd();
	}
	
	
	@Override
	protected void onErkezes( Cella c ){
		c.ralep( this );		
	}

	/**
	 * Megcsusztatja a robotot, tehat az nem tudja majd megvaltoztatni
	 * a sebesseget a kovetkezo lehetosegnel
	 */
	public void csusztat() {
		Logger.printCall(this);
		
		Logger.printCallEnd();
	}

	/**
	 * Robot lassitasa, azaz sebessegenek megfelezese
	 */
	public void lassit() {
		Logger.printCall(this);
		seb.felez();
		Logger.printCallEnd();
	}
	
	public void info(){
		Logger.printCall(this);
		
		Logger.printCallEnd();
	}
}
