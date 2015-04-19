package modell.jatekobj;

import modell.Jatek;
import modell.Jatekos;
import modell.palya.Cella;
import modell.palya.Irany;
import modell.palya.Sebesseg;

/**
 * Robot osztaly
 *
 */
public class Robot extends AbstractRobot {

    /**
     * Robot sebessege
     */
    private Sebesseg seb;
    /**
     * Ragacskeszlet
     */
    private int ragacsnum;
    /**
     * Olajkeszlet
     */
    private int olajnum;
    /**
     * IRanyithatatlan-e a robot
     */
    private boolean csusztatott;

    /**
     *     */
    private Jatekos jatekos;

    /**
     * Default konstruktor
     */
    public Robot(Jatekos jatekos) {
        super();

        ragacsnum = olajnum = 3;
        csusztatott = false;
        seb = new Sebesseg();
        this.jatekos = jatekos;

    }

    /**
     * Megadja mi tortenik, ha robot lep rank
     */
    public void ralep(Robot r) {

        if (r.seb.getNagysag() > seb.getNagysag()) {
            r.seb = Sebesseg.Sum(seb, r.seb);
            kill();
        } else {
            seb = Sebesseg.Sum(seb, r.seb);
            r.kill();
        }

    }

    /**
     * Megadja, merre modosul majd a robot sebessege a kovetkezo leerkezeskor
     *
     * @param i Az adott irany
     */
    public void iranyit(Irany i) {

        if (allapot == RobotAllapot.ALLO) {
            seb.modosit(i);
        }

    }

    /**
     * Ragacs lerakasa
     */
    public void lerakRagacs() {

        cella.add(new Ragacs());

    }

    /**
     * Olaj lerakasa
     */
    public void lerakOlaj() {

        cella.add(new Olaj());
    }

    /**
     * Megcsusztatja a robotot, tehat az nem tudja majd megvaltoztatni a
     * sebesseget a kovetkezo lehetosegnel
     */
    public void csusztat() {
    }

    /**
     * Robot lassitasa, azaz sebessegenek megfelezese
     */
    public void lassit() {
        seb.felez();
    }

//    public void info() {
//        
//    }

    @Override
    public String getAzon() {
        return "J" + jatekos.getSorszam();
    }

    @Override
    protected void erkezik(Cella c) {
        cella = c;
        c.add(this);
        forras = cel = null;
        c.ralep(this);
    }
}
