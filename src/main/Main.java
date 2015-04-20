package main;

import modell.Jatek;

public class Main {

    /**
     * Ennyi tick van egy masodperc alatt, jatek kozben nem valtoztathato
     */
    private static int tickPerSecond = 60;

    public static int getTicksPerSecond() {
        return tickPerSecond;
    }

    /**
     * Tick parancs vegrehajtasa
     *
     * @param cmd parancs es argumentumok
     */
    public static void parancsTick(String[] cmd) {
        if (cmd.length < 2) {
            System.out.println("Tul keves parameter");
            return;
        }
        try {
            int beolvas = Integer.parseInt(cmd[1]);
			// Az exception nem erre van, de ha m�r egyszer van
            // catch a parseInt miatt, hasznaljuk azt
            if (beolvas < 3 || beolvas > 100) {
                throw new Exception();
            }
            // Csak akkor valtoztatunk, ha ertelmes szamot kapunk
            tickPerSecond = beolvas;
        } catch (Exception ex) {
            System.out.println("Ervenytelen szam( 3..100 kozotti integer legyen! )");
        }
    }

    /**
     * Jatek parancs vegrehajtasa
     *
     * @param cmd parancs es argumentumok
     */
    public static void parancsJatek(String[] cmd) {
        if (cmd.length < 2) {
            System.out.println("Tul keves parameter");
            return;
        }
        try {
            int jatekosnum = Integer.parseInt(cmd[1]);
			// Az exception nem erre van, de ha m�r egyszer van
            // catch a parseInt miatt, hasznaljuk azt
            if (jatekosnum < 1 || jatekosnum > 4) {
                throw new Exception();
            }

            String palya = null;
            if (cmd.length >= 3) {
                palya = cmd[2];
            }

            Jatek jatek = new Jatek(palya, jatekosnum);

            // 100 mp-ig tart egy jatek
            jatek.futtat(100);

        } catch (Exception ex) {
            System.out.println("Ervenytelen szam( 1..4 kozotti integer legyen! )");
            System.out.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    public static void main(String[] args) {

        String line;
        String cmd[] = null;

        while ((line = Input.getLine()) != null) {

            cmd = line.toUpperCase().split(" ");

            if (cmd[0].equals("JATEK")) {
                parancsJatek(cmd);
            }

            if (cmd[0].equals("TICK")) {
                parancsTick(cmd);
            }

            if (cmd[0].equals("EXIT")) {
                break;
            }
        };

    }

}
