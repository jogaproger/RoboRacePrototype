package skeleton.usecase;

import skeleton.Logger;

/**
 * Absztrakt UseCase osztaly, amely egy UseCase feluletet adja meg
 * Strategy minta
 * 
 */
public abstract class UseCase {
	String name;
	
	/** Usecase vegrehajtasa */
	abstract public void execute();
	
	/** Usecase vegrehajtasa */
	abstract public String getName();
		
	
	/**
	 * Use Case definialasahoz szarmaztassuk le a UseCase osztalyt
	 * irjunk metodust neki, amely vegrehajtja, illetve lekerdi a nevet
	 * majd adjuk hozza ezen tombhoz:
	 * Tipp: Elobb hozzaadni a tombhoz, majd legeneraltatni eclipse-szel
	 */
	static UseCase[] useCases = {
		new UC1_UjJatek(),
		new UC2_Ranglista(),
		new UC3_RobotVezerles(),
		new UC4_Kilepes(),
		
		new UC4_JatekKezdes(),
		new UC5_JatekVege(),
		new UC6_OlajfoltGatol(),
		new UC7_RagacsLassit(),
		new UC8_BlokkElpusztit()		
	};
	
	public static void Listaz(){
		for( int i = 0 ; i < useCases.length ; i++ )	
			System.out.println( ""+(i+1)+". "+useCases[i].getName());
	}
	
	public static boolean Vegrehajt(int i){
		i--;	// 1-tol van szamozva, de nekunk 0-tol kell
		if( i < 0 || i >= useCases.length )
			return false;
		
		System.out.println(useCases[i].getName()+" vegrehajtasa:");
		useCases[i].execute();
		Logger.releaseNames();	// Use Case altal foglalt nevek mar nem maradhatnak
				
		return true;
	}
	
	
}
