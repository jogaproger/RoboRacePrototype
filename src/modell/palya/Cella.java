package modell.palya;

import java.util.ArrayList;

import modell.jatekobj.JatekObj;
import modell.jatekobj.Robot;
import modell.visitors.JOVisitor;
import modell.visitors.TakaritoVisitor;
import main.Logger;

public class Cella {

    private int x;
    private int y;
    private ArrayList<JatekObj> o;
    private Palya palya;

    Cella(Palya p, int x, int y) {
        Logger.printCall(this);

        this.x = x;
        this.y = y;
        o = new ArrayList<>();
        this.palya = p;

        Logger.printCallEnd();
    }

    /**
     * Kovetkezo cella lekerdezese,sebessegtol fuggoen
     *
     * @param s Aktualis sebesseg
     * @return
     */
    public Cella getKov(Sebesseg s) {
        Logger.printCall(this, s);
        Cella c = palya.cellaxy(x + s.jobbra, y + s.fel);
        Logger.printCallEnd();
        return c;
    }

    /**
     * Jatekobjektum hozzaadasa a cellahoz
     *
     * @param j Lerakando jatekobjektum
     */
    public void add(JatekObj j) {
        Logger.printCall(this, j);

        o.add(j);

        Logger.printCallEnd();
    }

    /**
     * Jatekobjektum eltavolitasa a cellarol
     *
     * @param j Eltavolitando jatekobjektum
     */
    public void remove(JatekObj j) {
        Logger.printCall(this, j);
        o.remove(j);
        Logger.printCallEnd();
    }

    /**
     * Robot ralep a cellara
     *
     */
    public void ralep(Robot r) {
        Logger.printCall(this, r);
        for (JatekObj obj : o) {
            obj.ralep(r);
        }
        Logger.printCallEnd();
    }

    @Override
    public String toString() {
        return "c[" + x + "," + y + "]";
    }

    public Cella keresFolt() {
        return palya.keresFolt(x, y);
    }

    public void accept(JOVisitor visitor) {
        for (JatekObj obj : o) {
            obj.accept(visitor);
        }
    }

    public String getAzon() {
        if (o.size() ==0) {
            return "  ";
        } else if (o.size()>1) {
            return "..";

        }
        else
        {
            return o.get(0).getAzon();
        }
    }

}
