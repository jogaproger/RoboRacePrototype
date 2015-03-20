package skeleton;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Skeleton {

	
	public static void main( String[] args )
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("RoboRace - Szkeleton verzió");
		System.out.println("56. Fixit Company");
		System.out.println();
		
		boolean vege = false;
		
		while( !vege ){
			System.out.println("Válassz az alábbi Use Case-ek közül.");
			UseCase.Listaz();
			System.out.println("Írd be a Use case sorszámát, vagy 0-t ha kis szeretnél lépni:");		
			try{
				int i = Integer.parseInt(br.readLine());
				if(  i==0 )
					vege = true;
				else{
					UseCase.Vegrehajt(i);
				}
			}
			catch(Exception e){
				System.out.println("Nem jó számot adtál meg, vagy helytelen formátumban");	
				continue;
			}
		}

	}
	
}
