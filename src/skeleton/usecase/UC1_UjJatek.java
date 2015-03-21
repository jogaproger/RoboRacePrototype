package skeleton.usecase;

import modell.Jatek;
import skeleton.Logger;

/**
 * Új játék use case megvalósítása
 *
 */
public class UC1_UjJatek extends UseCase {

	@Override
	public void execute() {
		// Inicializálás, ilyenkor még nem írunk ki
		Logger.setEnabled(false);
		Jatek jatek = new Jatek();	
		
		Logger.setEnabled(true);
		jatek.ujJatek("palya.txt", 1);
	
	}

	@Override
	public String getName() {
		return "Új játék";
	}

}
