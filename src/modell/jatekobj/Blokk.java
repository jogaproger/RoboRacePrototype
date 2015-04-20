package modell.jatekobj;

import modell.visitors.JOVisitor;

public class Blokk extends JatekObj {
	
	/**
	 * Default konstruktor
	 */
	public Blokk(){
		super(null);
	}
	
	/**
	 * Semmit nem csinal
	 */
	public void simulate() {
	}
	/**
	 * Megoli a robotot
	 */
	public void ralep(Robot r) {
		r.kill();
	}

	@Override
	public void accept(JOVisitor visitor) {
		visitor.visitBlokk(this);
	}

	@Override
	public void info() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAzon() {
		return "X ";
	}

}
