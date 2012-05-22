/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ohtamaa
 */
public class Laivanupotus {

    Scanner scan = new Scanner(System.in);
    String pelaaja;
    int laivojaJaljella;
    int korkeus;
    int leveys;
    public Ruutu[][] ruudukko;

    public Laivanupotus() {
        korkeus = 10;
        leveys = 10;
        this.laivojaJaljella = 0;
        ruudukko = new Ruutu[leveys][korkeus];
    }

    public String toString() {

        return "";
    }

    public void alustaRuudukko() {

        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                ruudukko[i][j] = new Ruutu();
            }
        }
    }

    /**
     *
     * Kysytään käyttäjältä ruudukon korkeus ja leveys
     */
    public void kysyRuudukonKoko() {
        System.out.println("Ruudukon korkeus:");
        korkeus = scan.nextInt();
        System.out.println("Ruudukon leveys:");
        leveys = scan.nextInt();
    }

    /**
     *
     * Palauttaa ruudukon korkeuden
     */
    public int getKorkeus() {
        return korkeus;
    }

    /**
     *
     * Palauttaa ruudukon leveyden
     */
    public int getLeveys() {
        return leveys;
    }

    /**
     *
     * Kysytään käyttäjän nimi tuloslistaa varten
     */
    public void kysyNimi() {
        System.out.println("Nimesi:");
        pelaaja = scan.nextLine();
    }

    public void sijoitaLaivaSatunnaiseen(Laiva laiva) {
        Random arpoja = new Random();
        int rivi = arpoja.nextInt(korkeus);
        int sarake = arpoja.nextInt(leveys);

        int suunta = arpoja.nextInt(4);

        int laivaaJaljella = laiva.getKoko();

        while (laivaaJaljella > 0) {
            if (!onkoLaivaa(rivi, sarake)) {
                
                laivaaJaljella--;
                if (suunta == 0) {
                    rivi--;
                } else if (suunta == 1) {
                    sarake++;
                } else if (suunta == 2) {
                    rivi++;
                } else if (suunta == 3) {
                    sarake--;
                }
            } else
                break;



        }



        sijoitaLaiva(laiva, rivi, sarake);
    }

    /**
     *
     * Sijoittaa laivan ruudukkoon
     */
    public boolean sijoitaLaiva(Laiva laiva, int x, int y) {

        if (onkoLaivaa(x, y)) {
            return false;
        } else {
            ruudukko[x][y].setLaiva(laiva);
            laivojaJaljella++;
            return true;
        }

    }

    /**
     *
     * Tarkistaa ovatko koordinaatit ruudukolla
     */
    public boolean osuikoRuudukkoon(int x, int y) {
        if (x < 0 || y < 0 || x >= korkeus || y >= leveys) {
            return false;
        }
        return true;
    }

    /**
     *
     * Tarkistaa onko ruudussa laivaa
     */
    public boolean onkoLaivaa(int x, int y) {
        if (ruudukko[x][y].getLaiva() == null) {
            return false;
        }
        return true;
    }

    /**
     *
     * Tarkistaa onko ruutua jo ammuttu
     */
    public boolean onkoAmmuttu(int x, int y) {
        return ruudukko[x][y].getAmmuttu();
    }

    /**
     *
     * Ammutaan ruutua
     */
    public int ammu(int x, int y) {

        if (!osuikoRuudukkoon(x, y) || onkoAmmuttu(x, y)) {
            return -1;
        } else {
            ruudukko[x][y].setAmmuttu();
            if (onkoLaivaa(x, y)) {

                ruudukko[x][y].getLaiva().osuLaivaan();

                if (ruudukko[x][y].getLaiva().onkoUponnut()) {
                    laivojaJaljella--;
                    return 2;
                }
                return 1;
            }
            return 0;
        }
    }

    /**
     *
     * Tarkistaa onko laivoja vielä löytämättä eli vieläkö peliä jatketaan
     */
    public boolean onkoPeliaJaljella() {
        if (laivojaJaljella > 0) {
            return true;
        } else {
            return false;
        }
    }
}
