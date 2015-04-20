package modell.visitors;

import modell.jatekobj.AbstractRobot;
import modell.jatekobj.Blokk;
import modell.jatekobj.Folt;

public class TakaritoVisitor implements JOVisitor {

	public boolean takaritott = false;

	@Override
	public void visitAbstractRobot(AbstractRobot r) {
	}

	@Override
	public void visitFolt(Folt f) {
		f.takarit();
		takaritott = true;
	}

	@Override
	public void visitBlokk(Blokk b) {
	}

}
