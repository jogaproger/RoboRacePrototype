package modell.jatekobj;


public class Ragacs extends Folt{
	
	/**
	 * Default konstruktor
	 */
	public Ragacs(){
	}
	
	/**
	 * Semmit nem csinal
	 */
	public void simulate() {
	}
	/**
	 * Lelassitja a robotot
	 */
	public void ralep(Robot r) {
		r.lassit();		
		elet -= 25.1;	// 4 ugras utan igy elpusztul a ragacs
	}

	@Override
	public void info() {
		// TODO Auto-generated method stub
		
	}
	
	

}
