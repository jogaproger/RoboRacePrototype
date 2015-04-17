package modell;
import java.util.ArrayList;

import main.Logger;
import modell.jatekobj.JatekObj;
import modell.jatekobj.Robot;
import modell.palya.Palya;
/**
 * Jatekot megvalosito osztaly
 *
 */
public class Jatek {
	
	/** Jatekhoz tartozo ranglista */
	private Ranglista ranglista;
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
		ranglista = new Ranglista();
	}
	
	public void ujJatek( String palyafajl, int jatekosnum ){
		
		jatekosok = new Jatekos[jatekosnum];
		objects = new ArrayList<JatekObj>();
		robotszam = 0;
		
		palya = new Palya(this);
		if( palyafajl == null || !palya.betolt(palyafajl));
			palya.szerkeszt();
		
		for( int i = 0 ; i < jatekosnum ; i++ )
			jatekosok[i] = new Jatekos("Nev"+i, this);
	}
	
	/**
	 * Jatekobjektum hozzaadasa a jatekhoz
	 * 
	 */	
	public void addJatekObj( JatekObj j ){
		
		this.objects.add(j);		
		
	}
	
	/**
	 * Robot hozzaadasa a jatekhoz es lehelyezese
	 * a kovetkezo kezdocellara
	 */	
	public void addRobot(Robot r){
		r.addToCella(palya.getStartCell(robotszam));
		robotszam++;		
		addJatekObj(r);		
	}
	
	/**
	 * Kilepes a jatekbol
	 * 
	 */	
	public void kilepes(){
		Logger.printMessage("endflag set true");
		endflag = true;
	}

	/**
	 * Jatek lejatszasa
	 * 
	 */	
	public void futtat(){
		Logger.printCall(this);
		
		
	
		Logger.printCallEnd();
	}
	
	/**
	 * Pontok elkuldese a ranglistanak
	 * 
	 */	
	public void commitPontok(){
	}
	
}
