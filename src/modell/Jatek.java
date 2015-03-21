package modell;
import java.util.ArrayList;

import modell.jatekobj.JatekObj;
import modell.jatekobj.Robot;
import modell.palya.Palya;
import skeleton.Logger;
/**
 * Játékot megvalósító osztály
 *
 */
public class Jatek {
	/** Singleton Példány */
	private static Jatek instance = new Jatek();
	
	/** Játékhoz tartozó ranglista */
	private Ranglista ranglista = new Ranglista();
	/** Játékosok tömbje */
	private Jatekos[] jatekosok;
	/** Játéevõ objektumok listája*/
	private ArrayList<JatekObj> objects;
	/** A pálya, amelyen a játék zajlik */
	private Palya palya;
	/** Játék végét jelzi */
	private boolean endflag;
	/** Játék kezdete óta eltelt idõ */
	private int ido;
	/** robotok száma a pályán */
	private int robotszam;
	
	/**
	 * Játékos példányának visszaadása
	 * @return Singleton példány
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
			jatekosok[i] = new Jatekos("Név"+i);
		
		Logger.printCallEnd();
	}
	
	/**
	 * Játékobjektum hozzáadása a játékhoz
	 * 
	 */	
	public void addJatekObj( JatekObj j ){
		Logger.printCall(this, j);
		
		
		Logger.printCallEnd();
	}
	
	/**
	 * Robot hozzáadása a játékhoz és lehelyezése
	 * a következõ kezdõcellára
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
	 * Kilépés a játékból
	 * 
	 */	
	public void kilepes(){
		Logger.printCall(this);
		
		endflag = true;
		Logger.print("endflag = true");
		
		Logger.printCallEnd();	
	}

	/**
	 * Játék lejátszása
	 * 
	 */	
	public void simulate(){
		Logger.printCall(this);
		
		
		Logger.printCallEnd();	
	}
	
	/**
	 * Pontok elküldése a ranglistának
	 * 
	 */	
	public void commitPontok(){
		Logger.printCall(this);
		
		
		Logger.printCallEnd();	
	}
	
}
