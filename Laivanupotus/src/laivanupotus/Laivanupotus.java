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
    Pelaaja pelaaja;
    int ampumistenMaara = 0;
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

    /**
     *
     * Alustaa pelialueen tyhjillä ruuduilla
     */
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
        String pelaajanNimi = scan.nextLine();
        pelaaja = new Pelaaja(pelaajanNimi);
    }

    /**
     *
     * Tarkistaa voiko laivaa sijoittaa kohdasta (x,y) lähtien
     */
    public boolean sopiikoLaiva(int x, int y, int suunta, Laiva laiva) {
        int laivaaJaljella = laiva.getKoko();
        boolean sopiiko = false;
        while (laivaaJaljella > 0) {
            if (!onkoLaivaa(x, y) && x<korkeus && y<leveys) {
                sopiiko = true;
                laivaaJaljella--;
                if (suunta == 0) {
                    x++;
                } else if (suunta == 1) {
                    y++;
                }
            } else {
                sopiiko = false;
                break;
            }
        }
        if (sopiiko == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * Sijoittaa laivan satunnaisesesta ruudusta lähtien
     */
    public void sijoitaLaivaSatunnaiseen(Laiva laiva) {
        Random arpoja = new Random();
        int rivi = arpoja.nextInt(korkeus);
        int sarake = arpoja.nextInt(leveys);
        int suunta = arpoja.nextInt(2);

        if (sopiikoLaiva(rivi, sarake, suunta, laiva)) {
            int laivaaJaljella = laiva.getKoko();

            while (laivaaJaljella > 0) {
                sijoitaLaiva(laiva, rivi, sarake);
                laivaaJaljella--;
                if (suunta == 0) {
                    rivi++;
                } else {
                    sarake++;
                }
            }
            laivojaJaljella++;
        }
    }

    /**
     *
     * Sijoittaa laivan ruudukkoon kohtaan (x,y)
     */
    public boolean sijoitaLaiva(Laiva laiva, int x, int y) {

        if (onkoLaivaa(x, y)) {
            return false;
        } else {
            ruudukko[x][y].setLaiva(laiva);
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
            ampumistenMaara++;
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
