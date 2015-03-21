package skeleton.usecase;

import modell.jatekobj.Blokk;
import modell.jatekobj.Robot;
import modell.palya.Cella;
import skeleton.Logger;
public class UC8_BlokkElpusztit extends UseCase {

	@Override
	public void execute() {
            Logger.setEnabled(false);
            Robot robot = new Robot();
            Blokk blokk = new Blokk();
            Cella cella = new Cella(null,0,0);
            cella.add(blokk);
            Logger.setEnabled(true);
            cella.ralep(robot);
            
	}

	@Override
	public String getName() {
		return "Blokk elpusztit";
	}

}
