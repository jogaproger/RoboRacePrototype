package skeleton.usecase;

import modell.jatekobj.Olaj;
import modell.jatekobj.Robot;
import modell.palya.Cella;
import skeleton.Logger;

public class UC7_OlajfoltGatol extends UseCase {

	@Override
	public void execute() {
            Logger.setEnabled(false);
            Robot robot = new Robot();
            Olaj olaj = new Olaj();
            Cella cella = new Cella(null,0,0);
            cella.add(olaj);
            Logger.setEnabled(true);
            cella.ralep(robot);
	}

	@Override
	public String getName() {
		return "Olajfolt gatol";
	}

}
