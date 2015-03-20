package skeleton;

import modell.Jatek;

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
	 * Példa Use Case Definiálására
	 *
	 */
	static private class PeldaUC extends UseCase{
		@Override
		public void execute() {
			// Itt végrehajthatunk egy use case-t		
		}

		@Override
		public String getName() {
			return "Példa use case";
		}
	}
	
	/**
	 * Uj játék kezdése
	 *
	 */
	static private class UjJatekUC extends UseCase{
		@Override
		public void execute() {
			// Inicializálás, ilyenkor még nem írunk ki
			Logger.setEnabled(false);
			Jatek jatek = new Jatek();	
			
			Logger.setEnabled(true);
			jatek.ujJatek("probafajl", 2);
			
		}

		@Override
		public String getName() {
			return "Új játék kezdése";
		}
	}
	
	
	/**
	 * Use Case definiálásához származtassuk le a UseCase osztályt
	 * statikus inner classként és adjuk hozzá a tömbhöz
	 * 
	 */
	static UseCase[] useCases = {
		new UjJatekUC()		
		
	};
	
	static void Listaz(){
		for( int i = 0 ; i < useCases.length ; i++ )	
			System.out.println( ""+(i+1)+". "+useCases[i].getName());
	}
	
	static boolean Vegrehajt(int i){
		i--;	// 1-tõl van számozva, de nekünk 0-tól kell
		if( i < 0 || i >= useCases.length )
			return false;
		
		System.out.println(useCases[i].getName()+" végrehajtása:");
		useCases[i].execute();
				
		return true;
	}
	
	
}
