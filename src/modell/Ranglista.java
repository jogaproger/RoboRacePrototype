package modell;

/**
 * Ranglista osztaly
 */
public class Ranglista {

    /**
     * Nev es hozza tartozo pont tarolasa
     */
    static class NevPont {

        public String nev;
        public int pont;

        /**
         * Paros inicializalasa
         *
         * @param nev Jatekos neve
         * @param pont Jatekos pontszama
         */
        public NevPont(String nev, int pont) {
            this.nev = nev;
            this.pont = pont;
        }
    }

    private static final int count = 10;

    NevPont lista[];

    public Ranglista() {

        lista = new NevPont[count];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = new NevPont("", 0);
        }

    }

    public void commit(String nev, int pont) {

    }

    public void megjelenit() {
    }
}
