package skeleton.usecase;

import modell.jatekobj.Ragacs;
import modell.jatekobj.Robot;
import modell.palya.Cella;
import skeleton.Logger;

public class UC7_RagacsLassit extends UseCase {

	@Override
	public void execute() {
            Logger.setEnabled(false);
            Robot robot = new Robot();
            Ragacs ragacs = new Ragacs();
            Cella cella = new Cella(null,0,0);
            cella.add(ragacs);
            Logger.setEnabled(true);
            cella.ralep(robot);
	}

	@Override
	public String getName() {
		return "Ragacs lassit";
	}

}
