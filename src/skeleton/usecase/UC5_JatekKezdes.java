package skeleton.usecase;

import modell.Jatek;
import skeleton.Logger;

public class UC5_JatekKezdes extends UseCase {

	@Override
	public void execute() {
		Logger.setEnabled(false);
		Jatek jatek = new Jatek();	
		
		Logger.setMaxDepth(1);
		Logger.setEnabled(true);
		jatek.ujJatek("palya.txt", 1);
		jatek.simulate();
		
		Logger.setMaxDepth(100);
	}

	@Override
	public String getName() {
		return "Jatek kezdes";
	}

}
