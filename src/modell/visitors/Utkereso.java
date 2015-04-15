package modell.visitors;

import modell.jatekobj.AbstractRobot;
import modell.jatekobj.Blokk;
import modell.jatekobj.Folt;

public class Utkereso implements JOVisitor {

	/** Az utkereses szempontjabol relevans adatok */
	boolean folt=false, blokkol=false;
	
	@Override
	public void visitAbstractRobot(AbstractRobot r) {
		// Mas robotokat igyekszik elkerulni a kisrobot
		blokkol = false;
	}

	@Override
	public void visitFolt(Folt f) {
		// A foltok lesznek a celok
		folt = true;
	}

	@Override
	public void visitBlokk(Blokk b) {
		// A blokkokat is elkeruli a kisrobot
		blokkol = true;

	}

}
