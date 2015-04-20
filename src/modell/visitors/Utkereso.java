package modell.visitors;

import modell.jatekobj.AbstractRobot;
import modell.jatekobj.Blokk;
import modell.jatekobj.Folt;

public class Utkereso implements JOVisitor {

	/** Az utkereses szempontjabol relevans adatok */
	public boolean folt=false, blokkol=false;
	
	/**
	 * AbstractRobot visitalasa, flag beallitasa
	 */
	@Override
	public void visitAbstractRobot(AbstractRobot r) {
		// Mas robotokat igyekszik elkerulni a kisrobot
		blokkol = true;
	}
	/**
	 * Folt visitalasa, flag beallitasa
	 */
	@Override
	public void visitFolt(Folt f) {
		folt = true;
	}
	/**
	 * Blokk visitalasa, flag beallitasa
	 */
	@Override
	public void visitBlokk(Blokk b) {
		// A blokkokat is elkeruli a kisrobot
		blokkol = true;

	}
	/**
	 * Eredeti allapotaba modositja a visitort
	 */
	public void reset() {
		folt = blokkol = false;		
	}

}
