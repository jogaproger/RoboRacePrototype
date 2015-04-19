package modell.jatekobj;

import main.Logger;
import modell.Jatek;
import modell.Jatekos;
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
	
	/**  */
	private Jatekos jatekos;
	
	/**
	 * Default konstruktor
	 */
	public Robot( Jatekos jatekos ) {
		super();
		Logger.printCall(this);
		
		ragacsnum = olajnum = 3;
		csusztatott = false;
		seb = new Sebesseg();
		this.jatekos = jatekos;
		
		Logger.printCallEnd();
	}
	/**
	 * Megadja mi tortenik, ha robot lep rank
	 */
	public void ralep(Robot r) {
		Logger.printCall(this, r);
		
		if( r.seb.getNagysag() > seb.getNagysag() )
		{
			r.seb = Sebesseg.Sum(seb,  r.seb);
			kill();
		}
		else
		{
			seb = Sebesseg.Sum(seb,  r.seb);
			r.kill();
		}
		
		Logger.printCallEnd();
	}

	
	/**
	 * Megadja, merre modosul majd a robot sebessege a kovetkezo
	 * leerkezeskor
	 * @param i Az adott irany
	 */
	public void iranyit(Irany i) {
		Logger.printCall(this, i.toString());
		
		if( allapot == RobotAllapot.ALLO )
			seb.modosit(i);
		
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
	@Override
	public String getAzon() {
		return "J"+jatekos.getSorszam();
	}
	@Override
	protected void erkezik(Cella c) {
		cella = c;
		c.add(this);
		forras = cel = null;
		c.ralep(this);
	}
}
