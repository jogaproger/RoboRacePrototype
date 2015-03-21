package skeleton;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import skeleton.usecase.UseCase;


public class Skeleton {
	
	public static void main( String[] args )
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("RoboRace - Szkeleton verzio");
		System.out.println("56. Fixit Company");
		System.out.println();
		
		boolean vege = false;
		
		while( !vege ){
			System.out.println("Valassz az alabbi Use Case-ek kozul.");
			UseCase.Listaz();
			System.out.println("Ird be a Use case sorszamat, vagy 0-t ha kis szeretnel lepni:");		
			try{
				int i = Integer.parseInt(br.readLine());
				if(  i==0 )
					vege = true;
				else{
					try{
						UseCase.Vegrehajt(i);
					}catch(Exception e){
						e.printStackTrace();						
					}
				}
			}
			catch(Exception e){
				System.out.println("Nem jo szamot adtal meg, vagy helytelen formatumban");	
				continue;
			}
		}

	}
	
}
