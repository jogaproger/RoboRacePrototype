package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import skeleton.usecase.UseCase;

/**
 * Foosztaly
 */
public class Skeleton {
	/**
	 * Belepesi pont
	 * @param args 
	 */
	public static void main( String[] args )
	{
		// Beolvasasokhoz
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Szoftverinformaciok kiiratasa
		System.out.println("RoboRace - Szkeleton verzio");
		System.out.println("56. Fixit Company");
		System.out.println();
		
		boolean vege = false;
		// Addig amig a felhasznalo meg nem szakitja
		while( !vege ){
			// Use case listazas, valasztasi feltetelek biztositasa
			System.out.println("Valassz az alabbi Use Case-ek kozul.");
			UseCase.Listaz();
			System.out.println("Ird be a Use case sorszamat, vagy 0-t ha kis szeretnel lepni:");		
			
			try{
				// Melyik use-caset valasztja a felhasznalo?
				int i = Integer.parseInt(br.readLine());
				// Nulla jelenti a kilepest
				if(  i==0 )
					break;					

				else{
					try{
						// Kivalasztott usecase vegrehajtasa
						if(!UseCase.Vegrehajt(i))
							System.out.println("Nem jo szamot adtal meg!");
							
					}catch(Exception e){
						// Use case altal kezeletlenul maradt kivetel
						e.printStackTrace();						
					}
				}
			}
			catch(Exception e){
				// Ezt az exceptiont a parseInt dobhatja
				System.out.println("Helytelen szamformatum!");	
			}
			System.out.println("Nyomj entert a folytatáshoz.");
			try {
				br.readLine();
			} catch (IOException e) {
			}
		}

	}
	
}
