package modell.jatekobj;


public class Ragacs extends Folt{
	
	/**
	 * Default konstruktor
	 */
	public Ragacs(){
	}
	
	/**
	 * Lelassitja a robotot
	 */
	public void ralep(Robot r) {
		r.lassit();		
		elet -= 25.1;	// 4 ugras utan igy elpusztul a ragacs
	}


	@Override
	public String getAzon() {
		return "R ";
	}
	
	

}
