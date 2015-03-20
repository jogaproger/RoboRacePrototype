package modell;
import java.util.ArrayList;

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
	
	public void addJatekObj( JatekObj j ){
		Logger.printCall(this, j);
		
		
		Logger.printCallEnd();
	}
	
}
