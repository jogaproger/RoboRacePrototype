package skeleton.usecase;

import modell.Jatek;
import skeleton.Logger;

/**
 * Uj jatek use case megvalositasa
 *
 */
public class UC1_UjJatek extends UseCase {

	@Override
	public void execute() {
		// Inicializalas, ilyenkor meg nem irunk ki
		Logger.setEnabled(false);
		Jatek jatek = new Jatek();	
		
		Logger.setEnabled(true);
		jatek.ujJatek("palya.txt", 1);
	
	}

	@Override
	public String getName() {
		return "Uj jatek";
	}

}
