package modell.jatekobj;

import main.Main;

public class Olaj extends Folt {

	
	static final double eletMP = 10;
	
    /**
     * Default konstruktor
     */
    public Olaj() {
    }

    /**
     * Semmit nem csinal
     */
    public void simulate() {
        elet -= 100/(eletMP*Main.getTicksPerSecond()) ;
        super.simulate();
    }

    /**
     * Megcsusztatja a robotot
     */
    public void ralep(Robot r) {
        r.csusztat();
    }

    @Override
    public String getAzon() {
        return "O ";
    }

}
