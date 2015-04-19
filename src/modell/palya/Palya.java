package modell.palya;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import modell.Jatek;
import modell.jatekobj.Ragacs;
import main.Logger;
import modell.jatekobj.Blokk;
import modell.jatekobj.Olaj;

/**
 * Palya osztaly
 */
public class Palya {

    /**
     * Palya szelessege, magassaga
     */
    private int szelesseg, magassag;
    /**
     * Palyakat alkoto cellak
     */
    private Cella[][] cellak;
    /**
     * Jatek amelyhez a palya tartozik
     */
    private Jatek jatek;
    /**
     * Robot kezdopoziciojat tarolja
     */
    private Cella[] robotkezdo;

    /**
     * Palya letrehozasa
     *
     * @param j A jatek, amelyhez a palya tartozik
     *
     */
    public Palya(Jatek j) {
        Logger.printCall(this, j);

        jatek = j;


        Logger.printCallEnd();
    }

    /**
     * Palya betoltese fajlbol
     *
     * @param fajl Fajl neve
     * @return Sikeres volt-e a beolvasas
     */
    public boolean betolt(String fajl) {
        Logger.printCall(this, fajl);
        File file = new File(System.getProperty("user.dir") + "/palyak/" + fajl + ".txt");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            scanner.useDelimiter(System.getProperty("line.separator"));
            if (scanner.hasNext()) {
                String[] palyameret = scanner.next().split(" ");
                this.szelesseg = Integer.parseInt(palyameret[0]);
                this.magassag = Integer.parseInt(palyameret[1]);
                generalCella(this.szelesseg, this.magassag);

                System.out.println("Palya: " + this.szelesseg + this.magassag);
            }

            for (int y = 0; y < magassag && scanner.hasNext(); y++) {
                String palyasor = scanner.next();
                for (int x = 0; x < palyasor.length() && x < szelesseg; x++) {
                    char palyaelem = palyasor.charAt(x);
                    switch (palyaelem) {
                        case 'R':
                            cellak[x][y].add(new Ragacs());
                            break;
                        case 'X':
                            cellak[x][y].add(new Blokk());
                            break;
                        case 'O':
                            cellak[x][y].add(new Olaj());

                            break;
                        case '-':
                            break;
                        default:
                            try {
                                int robotnum = Integer.parseInt(Character.toString(palyaelem));
                                this.robotkezdo[robotnum] = cellak[x][y];
                            } catch (Exception ex) {
                                Logger.printMessage(ex.getMessage());
                                System.out.println("Maximum 4 jatekos lehet!");
                            }
                            break;
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.printCallEnd();
            return false;
        }
        Logger.printCallEnd();
        return true;
    }

    /**
     * i. kezdocella lekerdezese
     *
     * @param i Sorszam
     * @return Valamelyik sarokcella i-tol fuggoen
     */
    public Cella getStartCell(int i) {
        Logger.printCall(this, new Integer(i));
        Logger.printCallEnd();
        return this.robotkezdo[i];
    }

    /**
     * cella lekerdese az X,Y helyen
     *
     * @param x X koordinata
     * @param y Y koordinata
     * @return az adott cella, Blokkot tartalmazo cella ha nincs a palyan
     */
    Cella cellaxy(int x, int y) {
        Logger.printCall(this, "" + x, "" + y);
        Logger.printCallEnd();
        // Ha palyan kivul esunk
        if (x < 0 || y < 0 || x >= szelesseg || y >= magassag) {
            Cella ret = new Cella(this, x, y);
            ret.add(new Blokk());	// Ez pusztitja el a kieso robotot
            return ret;
        } else {
            return cellak[x][y];
        }
    }

    /**
     * Palyaszerkesztes vegrehajtasa
     *
     */
    public void szerkeszt() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String command = "";

        int x;
        int y;
        // TODO teszteles
        while (!"kesz".equals(command)) {
            System.out.print("palyaszerkeszto>:");
            try {
                command = in.readLine();
                String[] args = command.toUpperCase().split(" ");
                if (args[0].equals("PALYA") )
                {
                        this.szelesseg = Integer.parseInt(args[1]);
                        this.magassag = Integer.parseInt(args[2]);
                        generalCella(this.szelesseg, this.magassag);
                } 
                else if (args[0].equals("KEZD") ) 
                {
                    int robotszam = Integer.parseInt(args[1]);
                    x = Integer.parseInt(args[2]);
                    y = Integer.parseInt(args[3]);
                    if (x >= 0 && y >= 0 && x < szelesseg && y < magassag) {
                        try {
                            this.robotkezdo[robotszam - 1] = this.cellaxy(x, y);
                        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                            System.out.println("Maximum 4 jatekos megengedett!");
                        }
                    }
                    else{
                        System.out.println("Nincsen ilyen indexu cella!");
                    }
                } 
                else if (args[0].equals("RAGACS") ) 
                {
                        x = Integer.parseInt(args[1]);
                        y = Integer.parseInt(args[2]);
                        this.cellaxy(x, y).add(new Ragacs());
                } 
                else if (args[0].equals("OLAJ") ) 
                {
                        x = Integer.parseInt(args[1]);
                        y = Integer.parseInt(args[2]);
                        this.cellaxy(x, y).add(new Olaj());
                } 
                else if (args[0].equals("BLOCK") || args[0].equals("BLOKK") ) 
                {
                        x = Integer.parseInt(args[1]);
                        y = Integer.parseInt(args[2]);
                        this.cellaxy(x, y).add(new Blokk());
                } 
                else if (args[0].equals("INFO") )
                {
                        info();
                } 
                else if (args[0].equals("KESZ") ) 
                {
                	break;                	
                }
                else 
                {
                	System.out.println("Ervenytelen parancs");                	
                }
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Palya.class.getName()).log(Level.SEVERE, null, ex);
            } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                System.out.println("Tul keves parameter!");
            } catch (java.lang.NumberFormatException ex) {
                System.out.println("Nem szamot kaptam!");
            }

        }

    }

    Cella getkov(Cella c, Sebesseg s) {
        return c.getKov(s);
    }

    public Cella keresFolt(int x, int y) {
        
        return null;
    }

    public void info() {
        System.out.println("Palya:");
        String elvalaszto = "";
        for (int num = 0; num < (this.szelesseg * 3) + 1; num++) {
            elvalaszto += "-";
        }

        // TODO tesztelni
        for (int y = 0; y < this.magassag; y++) {
            System.out.println(elvalaszto);
            String line = "|";
            for (int x = 0; x < this.szelesseg; x++) {
                line += this.cellak[x][y].getAzon() + "|";
            }

            System.out.println(line);
        }
        System.out.println(elvalaszto);

    }

    private void generalCella(int sz, int m) {
        cellak = new Cella[sz][m];
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < sz; x++) {
            	cellak[x][y] = new Cella(this, x, y);
            }
        }
        robotkezdo = new Cella[4];
        robotkezdo[0] = cellak[0][0];
        robotkezdo[1] = cellak[sz-1][m-1];
        robotkezdo[2] = cellak[sz-1][0];
        robotkezdo[3] = cellak[0][m-1];

    }
}
