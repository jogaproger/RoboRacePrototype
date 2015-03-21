package skeleton.usecase;

import modell.Jatek;
import skeleton.Logger;

public class UC6_JatekVege extends UseCase {

	@Override
	public void execute() {
		
            Logger.setEnabled(false);
            Jatek jatek = new Jatek();
            jatek.ujJatek("rand", 2);
                
            Logger.setEnabled(true);
            jatek.commitPontok();
	}

	@Override
	public String getName() {
		return "Jatek vege";
	}

}
