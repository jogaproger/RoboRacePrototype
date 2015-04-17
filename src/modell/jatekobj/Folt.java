package modell.jatekobj;

import modell.visitors.JOVisitor;

public abstract class Folt extends JatekObj {

	public abstract void takarit();
	
	@Override
	public void accept( JOVisitor visitor ){
		visitor.visitFolt(this);
	}

}
