package modell.palya;

import modell.jatekobj.JatekObj;
import modell.jatekobj.Robot;

public class Cella {

    private int x;
    private int y;
    private JatekObj[] o;
    private Palya palya;
    
    Cella(int x, int y) {

    }
    /**
     * Kovetkezo cella lekerdezese,sebessegtol fuggoen
     * @param s Aktualis sebesseg
     * @return 
     */
    public Cella getKov(Sebesseg s) {
        int resultx = 0;
        int resulty = 0;
        Cella c = new Cella(resultx, resulty);
        return c;
    }
    /**
     * Jatekobjektum hozzaadasa a cellahoz
     * @param j Lerakando jatekobjektum
     */
    public void add(JatekObj j) {

    }
    /**
     * Jatekobjektum eltavolitasa a cellarol
     * @param j Eltavolitando jatekobjektum
     */
    public void remove(JatekObj j) {

    }
    /**
     * Robot ralep a cellara
     * 
     */
    public void ralep(Robot r) {

    }
}
