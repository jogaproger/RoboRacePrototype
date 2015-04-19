package modell;
import java.util.ArrayList;

import main.Input;
import main.Logger;
import main.Main;
import modell.jatekobj.JatekObj;
import modell.jatekobj.Robot;
import modell.palya.Irany;
import modell.palya.Palya;
import modell.palya.Sebesseg;
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
	private int kezdoIndex;
	
	public Jatek( String palyafajl, int jatekosnum ){
		ujJatek(palyafajl, jatekosnum);
	}
	
	public void ujJatek( String palyafajl, int jatekosnum ){
		
		jatekosok = new Jatekos[jatekosnum];
		objects = new ArrayList<JatekObj>();
		kezdoIndex = 0;
		
		palya = new Palya(this);
		if( palyafajl == null || !palya.betolt(palyafajl));
			palya.szerkeszt();
		
		for( int i = 0 ; i < jatekosnum ; i++ )
			jatekosok[i] = new Jatekos("Nev"+(1+i), this, 1+i);
	}
	
	public int getJatekosNum(){
		return jatekosok.length;		
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
		r.addToCella(palya.getStartCell(kezdoIndex));
		kezdoIndex++;		
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
	public void futtat( double jatekidoSec ){
		Logger.printCall(this);
		int skipnum = 0;
		
		for( int tick = 0 ; tick < jatekidoSec*Main.getTicksPerSecond() ; tick++ )
		{
			if( skipnum <= 0 )
			{
				for( Jatekos jatekos:jatekosok )
				{
					String line;
					String cmd[] = null;
					
					if( (line = Input.getLine()) != null )
						break;
	
					cmd = line.toUpperCase().split(" ");
					
					if( cmd[0].equals("IRANYIT") )
						if(!parancsIranyit( cmd, jatekos ))
							System.out.println("Ervenytelen parancs");
					
					if( cmd[0].equals("IRANYIT") )
						if(!parancsIranyit( cmd, jatekos ))
							System.out.println("Ervenytelen parancs");	
					
					if( cmd[0].equals("NEXT") )
						continue;
					
					if( cmd[0].equals("SKIP") ){
						skipnum = parancsSkip( cmd );
						break;
					}
				}
			}
			else
			{
				skipnum--;
			}
			// Minden jatekobjektum viselkedesenek megvalositasa
			for( JatekObj jobj: objects )
				jobj.simulate();				
		}
	
		Logger.printCallEnd();
	}
	
	private int parancsSkip(String[] cmd) {
		int ret = 1;
		try{
			ret = Integer.parseInt(cmd[1]);
		}catch(Exception ex){}

		return ret < 1 ? ret : 1;
	}

	private boolean parancsIranyit(String[] cmd, Jatekos jatekos) {
		if( cmd.length < 2 )
			return false;
		
		for( Irany irany : Irany.values() )
		{
			if( irany.toString().toUpperCase().equals(cmd[1]) ){
				jatekos.iranyit(irany);
				return true;
			}
		}

		if( cmd.length >= 3 )
		{	
			try{
				int x = Integer.parseInt(cmd[1]);
				int y = Integer.parseInt(cmd[2]);
					
				jatekos.iranyit(new Sebesseg(x,y));
			}
			catch(Exception ex)
			{
				return false;
			}
		}
			
		return false;
	}

	/**
	 * Pontok elkuldese a ranglistanak
	 * 
	 */	
	public void commitPontok(){
	}
	
}
