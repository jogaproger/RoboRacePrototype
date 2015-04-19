package modell.jatekobj;

public class Olaj extends Folt {

    /**
     * Default konstruktor
     */
    public Olaj() {
    }

    /**
     * Semmit nem csinal
     */
    public void simulate() {
        elet -= 1;
    }

    /**
     * Megcsusztatja a robotot
     */
    public void ralep(Robot r) {
        r.csusztat();
    }

    @Override
    public void info() {
		// TODO Auto-generated method stub

    }

    @Override
    public String getAzon() {
        return "O ";
    }

}
