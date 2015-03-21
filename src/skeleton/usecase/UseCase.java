package skeleton.usecase;

import skeleton.Logger;

/**
 * Absztrakt UseCase osztály, amely egy UseCase felületét adja meg
 * Strategy minta
 * 
 */
public abstract class UseCase {
	String name;
	
	/** Usecase végrehajtása */
	abstract public void execute();
	
	/** Usecase végrehajtása */
	abstract public String getName();
		
	
	/**
	 * Use Case definiálásához származtassuk le a UseCase osztályt
	 * írjunk metódust neki, amely végrehajtja, illetve lekérdi a nevét
	 * majd adjuk hozzá ezen tömbhöz:
	 * Tipp: Elõbb hozzáadni a tömbhöz, majd legeneráltatni eclipse-szel
	 */
	static UseCase[] useCases = {
		new UC1_UjJatek(),
		new UC2_Ranglista(),
		new UC3_RobotVezerles(),
		new UC4_Kilepes(),
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
		i--;	// 1-tõl van számozva, de nekünk 0-tól kell
		if( i < 0 || i >= useCases.length )
			return false;
		
		System.out.println(useCases[i].getName()+" végrehajtása:");
		useCases[i].execute();
		Logger.releaseNames();	// Use Case által foglalt nevek már nem maradhatnak
				
		return true;
	}
	
	
}
