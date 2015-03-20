package modell;
import java.util.ArrayList;

import modell.jatekobj.JatekObj;
import modell.jatekobj.Robot;
import modell.palya.Palya;
import skeleton.Logger;

public class Jatek {
	private static Jatek instance = new Jatek();
	
	private Ranglista ranglista = new Ranglista();
	private Jatekos[] jatekosok;
	private ArrayList<JatekObj> objects;
	private Palya palya;
	private boolean endflag;
	private int ido;
	
	public static Jatek getInstance(){
		return instance;		
	}
	
	public void ujJatek( String palya, int jatekosnum ){
		Logger.printCall(this, palya, ""+jatekosnum);
		
		jatekosok = new Jatekos[jatekosnum];
		objects = new ArrayList<JatekObj>();
		
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
		
		addJatekObj(r);
		
		Logger.printCallEnd();	
	}
	
	/**
	 * Kilépés a játékból
	 * 
	 */	
	public void kilepes(){
		Logger.printCall(this);
		
		
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
