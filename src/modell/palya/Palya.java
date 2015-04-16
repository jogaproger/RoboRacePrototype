package modell.palya;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import modell.Jatek;
import modell.jatekobj.Ragacs;
import main.Logger;
import modell.jatekobj.Blokk;
import modell.jatekobj.Olaj;
import modell.jatekobj.Robot;

/**
 * Palya osztaly
 */
public class Palya {

    /**
     * Palya alapertelmezett merete
     */
    private static final int meret = 4;
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
        szelesseg = magassag = meret;
        cellak = new Cella[szelesseg][magassag];
        robotkezdo = new Cella[4];

        Logger.printCallEnd();
    }

    /**
     * Palya betoltese fajlbol
     *
     * @param fajl Fajl neve
     */
    public void betolt(String fajl) {
        Logger.printCall(this, fajl);
        File file = new File(System.getProperty("user.dir") + "/palyak/" + fajl + ".txt");
        Scanner scanner;
        String[] palyameret = new String[2];
        try {
            scanner = new Scanner(file);
            scanner.useDelimiter(System.getProperty("line.separator"));
            if (scanner.hasNext()) {
                palyameret = scanner.next().split(" ");
                this.szelesseg = Integer.parseInt(palyameret[0]);
                this.magassag = Integer.parseInt(palyameret[1]);
                cellak = new Cella[this.szelesseg][this.magassag];
                System.out.println("Palya: " + this.szelesseg + this.magassag);
            }
            int y = 0;
            while (scanner.hasNext()) {
                String palyasor = scanner.next();
                for (int x = 0; x < palyasor.length(); x++) {
                    char palyaelem = palyasor.charAt(x);
                    switch (palyaelem) {
                        case 'R':
                            this.cellak[x][y] = new Cella(this, x, y);
                            this.cellak[x][y].add(new Ragacs());
                            break;
                        case 'X':
                            this.cellak[x][y] = new Cella(this, x, y);
                            this.cellak[x][y].add(new Blokk());
                            break;
                        case 'O':
                            this.cellak[x][y] = new Cella(this, x, y);
                            this.cellak[x][y].add(new Olaj());

                            break;
                        case '-':
                            break;
                        default:
                            int robotnum = Integer.parseInt(Character.toString(palyaelem));
                            //TODO:handle exception if robotnumber out of range
                            this.robotkezdo[robotnum] = new Cella(this, x, y);
                            this.cellak[x][y] = new Cella(this, x, y);
                            Robot r = new Robot();
                            this.cellak[x][y].add(r);
                            break;
                    }
                }
                y++;
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Nem letezik ilyen palyafajl");//TODO palyakeszito mod?
        }
        Logger.printCallEnd();
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
     * @return az adott cella, null ha nincs a palyan
     */
    Cella cellaxy(int x, int y) {
        Logger.printCall(this, "" + x, "" + y);
        Logger.printCallEnd();
        // Ha palyan kivul esunk
        if (x < 0 || y < 0 || x >= szelesseg || y >= magassag) {
            return null;
        } else {
            return cellak[x][y];
        }
    }
}
