package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modell.Jatek;

public class Main {
	
	/** Ennyi tick van egy masodperc alatt, jatek kozben nem valtoztathato */
	private static int tickPerSecond = 60;
	
	public static int getTicksPerSecond(){
		return tickPerSecond;		
	} 
	
	/**
	 * Tick parancs vegrehajtasa
	 * @param cmd parancs es argumentumok
	 */
	public static void parancsTick(String[] cmd){
		if( cmd.length < 2 )
		{
			System.out.println("Tul keves parameter");		
			return;
		}
		try{
			int beolvas = Integer.parseInt(cmd[1]);
			// Az exception nem erre van, de ha már egyszer van
			// catch a parseInt miatt, hasznaljuk azt
			if( beolvas < 3 || beolvas > 100 )
				throw new Exception();
			// Csak akkor valtoztatunk, ha ertelmes szamot kapunk
			tickPerSecond = beolvas;
		}catch(Exception ex){
			System.out.println("Ervenytelen szam( 3..100 kozotti integer legyen! )");	
		}
	}
	
	/**
	 * Jatek parancs vegrehajtasa
	 * @param cmd parancs es argumentumok
	 */
	public static void parancsJatek(String[] cmd){
		if( cmd.length < 2 )
		{
			System.out.println("Tul keves parameter");		
			return;
		}
		try{
			int jatekosnum = Integer.parseInt(cmd[1]);
			// Az exception nem erre van, de ha már egyszer van
			// catch a parseInt miatt, hasznaljuk azt
			if( jatekosnum < 1 || jatekosnum > 4 )
				throw new Exception();
			
			String palya = null;
			if( cmd.length >= 3 )
				palya = cmd[2];				
			
			Jatek jatek = new Jatek(palya, jatekosnum);
			
			jatek.futtat();
			
		}catch(Exception ex){
			System.out.println("Ervenytelen szam( 1..4 kozotti integer legyen! )");	
		}
	}
	
	

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String cmd[] = null;
		
		do{
			try{
				cmd = br.readLine().toUpperCase().split(" ");
			}
			catch( Exception ex ){
				break;
			}
			
			if( cmd[0].equals("JATEK") )
				parancsJatek( cmd );
			
			if( cmd[0].equals("TICK") )
				parancsTick( cmd );
			
		}while( !cmd[0].equals("EXIT") );
			
		
	}

}
