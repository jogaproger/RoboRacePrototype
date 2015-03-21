package modell;
import java.util.ArrayList;

import modell.jatekobj.JatekObj;
import modell.jatekobj.Robot;
import modell.palya.Palya;
import skeleton.Logger;
/**
 * Jatekot megvalosito osztaly
 *
 */
public class Jatek {
	/** Elsodleges Peldany */
	private static Jatek instance;
	
	/** Jatekhoz tartozo ranglista */
	private Ranglista ranglista = new Ranglista();
	/** Jatekosok tombje */
	private Jatekos[] jatekosok;
	/** Jateevo objektumok listaja*/
	private ArrayList<JatekObj> objects;
	/** A palya, amelyen a jatek zajlik */
	private Palya palya;
	/** Jatek veget jelzi */
	private boolean endflag;
	/** Jatek kezdete ota eltelt ido */
	private int ido;
	/** robotok szama a palyan */
	private int robotszam;
	
	/**
	 * barmely jatekpeldany letrehozasakor valtozik az instance
	 */	
	public Jatek(){
		instance = this;		
	}
	
	/**
	 * Jatek peldanyanak visszaadasa
	 * @return Singleton peldany
	 */
	public static Jatek getInstance(){
		return instance;		
	}
	
	public void ujJatek( String palyafajl, int jatekosnum ){
		Logger.printCall(this, palyafajl, ""+jatekosnum);
		
		jatekosok = new Jatekos[jatekosnum];
		objects = new ArrayList<JatekObj>();
		robotszam = 0;
		
		palya = new Palya(this);
		palya.betolt(palyafajl);
		
		for( int i = 0 ; i < jatekosnum ; i++ )
			jatekosok[i] = new Jatekos("Nev"+i);
		
		Logger.printCallEnd();
	}
	
	/**
	 * Jatekobjektum hozzaadasa a jatekhoz
	 * 
	 */	
	public void addJatekObj( JatekObj j ){
		Logger.printCall(this, j);
		
		
		Logger.printCallEnd();
	}
	
	/**
	 * Robot hozzaadasa a jatekhoz es lehelyezese
	 * a kovetkezo kezdocellara
	 * 
	 */	
	public void addRobot(Robot r){
		Logger.printCall(this, r);
		
		palya.getStartCell(robotszam);
		robotszam++;
		
		addJatekObj(r);		
		Logger.printCallEnd();	
	}
	
	/**
	 * Kilepes a jatekbol
	 * 
	 */	
	public void kilepes(){
		Logger.printCall(this);
		
		endflag = true;
		Logger.printMessage("endflag = true");
		
		Logger.printCallEnd();	
	}

	/**
	 * Jatek lejatszasa
	 * 
	 */	
	public void simulate(){
		Logger.printCall(this);
		
		
		Logger.printCallEnd();	
	}
	
	/**
	 * Pontok elkuldese a ranglistanak
	 * 
	 */	
	public void commitPontok(){
		Logger.printCall(this);
		
		
		Logger.printCallEnd();	
	}
	
}
