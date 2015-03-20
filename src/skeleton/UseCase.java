package skeleton;

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
	 * Uj játék kezdése
	 *
	 */
	static private class UjJatekUC extends UseCase{
		@Override
		public void execute() {
			// Itt végrehajthatunk egy use case-t			
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
	
	static void UseCaseListaz(){
		for( int i = 0 ; i < useCases.length ; i++ )	
			System.out.println( ""+(i+1)+". "+useCases[i].getName());
	}
	
	static boolean UseCaseVegrehajt(int i){
		i--;	// 1-tõl van számozva, de nekünk 0-tól kell
		if( i < 0 || i >= useCases.length )
			return false;
		
		System.out.println(useCases[i].getName()+" végrehajtása:");
		useCases[i].execute();
				
		return true;
	}
	
	
}
