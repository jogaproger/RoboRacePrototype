package skeleton;

/**
 * Absztrakt UseCase osztály, amely egy UseCase felületét adja meg
 * Strategy minta
 * 
 */
public abstract class UseCase {
	String name;
	
	/** Usecase végrehajtása */
	abstract public void run();
	
	/** Usecase végrehajtása */
	abstract public String getName();
	
	/**
	 * Uj játék kezdése
	 *
	 */
	private class UjJatekUC extends UseCase{
		@Override
		public void run() {
			// Itt végrehajthatunk egy use case-t			
		}

		@Override
		public String getName() {
			return "Új játék kezdése";
		}
	}
	
	
	/**
	 * Use Case definiálásához származtassuk le a UseCase osztályt
	 * inner classként és adjuk hozzá a tömbhöz
	 * 
	 */
	static UseCase[] useCases = {
		new UjJatekUC()			
	};
	
	static void UseCaseListaz(){
		for( int i = 0 ; i < useCases.length ; i++ )	
			System.out.println( ""+(i+1)+". "+useCases[i].getName());
	}
	
	
	
}
