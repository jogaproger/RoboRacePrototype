package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	/** Ennyi tick van egy masodperc alatt, jatek kozben nem valtoztathato */
	private static int tickPerSecond = 60;
	
	public int getTicksPerSecond(){
		return tickPerSecond;		
	} 

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		String cmd[] = null;
		
		do{
			try{
				cmd = br.readLine().toUpperCase().split(" ");
			}
			catch( IOException ex )
			{			
				break;
			}			
			catch( NullPointerException ex )
			{			
				break;
			}
			
			
			if( cmd[0].equals("LEL") )
			{
				System.out.println("Lel bizony!");				
			}
			else if( cmd[0].equals("JUJ") )
			{
				System.out.println("Ne aggodj!");				
			}
			
			
		}while( !cmd[0].equals("EXIT") );
		
		
		
		
	}

}
