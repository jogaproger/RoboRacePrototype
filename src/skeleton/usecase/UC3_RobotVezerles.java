package skeleton.usecase;

import modell.Jatek;
import modell.Jatekos;
import skeleton.Logger;

public class UC3_RobotVezerles extends UseCase {

	@Override
	public void execute() {
		Logger.setEnabled(false);
		Jatek jatek = new Jatek();
		jatek.ujJatek("rand", 0);
		
		// A jatek jatekosait nem erjuk el ezert sajatot csinalunk
		// aki nem resze a jateknak, de felhasznalja a jatekter elemeit
		// ezert kellett letrehozni a fenti palyat
		Jatekos jatekos = new Jatekos("Bela");
		
		Logger.setEnabled(true);
		jatekos.iranyit();
		
	}

	@Override
	public String getName() {
		return "Robot vezerles";
	}

}
