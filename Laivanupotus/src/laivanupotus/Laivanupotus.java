/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

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
        this.laivojaJaljella = 5;
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
     * Kysytään käyttäjän nimi tuloslistaa varten
     */
    public void kysyNimi() {
        System.out.println("Nimesi:");
        pelaaja = scan.nextLine();
    }

    /**
     *
     * Sijoittaa laivat ruudukkoon
     */
    public void sijoitaLaiva(Laiva laiva, int x, int y) {
        ruudukko[x][y].setLaiva(laiva);
    }

    /**
     *
     * Tarkistaa ovatko koordinaatit ruudukolla
     */
    public boolean osuikoRuudukkoon(int x, int y) {
        if (x < 0 || y < 0 || x > korkeus || y > leveys) {
            return false;
        }
        return true;
    }

    /**
     *
     * Tarkistaa onko ruudussa laivaa
     */
    public boolean onkoLaivaa(int x, int y) {
        if (ruudukko[x][y].getLaiva().getKoko() == 0) {
            return false;
        }
        return true;
    }

    /**
     *
     * Tarkistaa onko ruutua jo ammuttu
     */
    public boolean onkoAmmuttu(int x, int y) {
        if (ruudukko[x][y].getAmmuttu()) {
            return true;
        }
        return false;
    }

    /**
     *
     * Ammutaan ruutua
     */
    public boolean ammu(int x, int y) {
        if (!osuikoRuudukkoon(x, y)) {
            System.out.println("Ruutu ei sijaitse ruudukolla");
            return false;
        } else if (onkoAmmuttu(x, y)) {
            System.out.println("Olet jo ampunut tähän ruutuun.");
            return false;
        } else {
            ruudukko[x][y].setAmmuttu();
            if (onkoLaivaa(x, y)) {                             //ruudussa on laiva
                ruudukko[x][y].getLaiva().osuLaivaan();
                if (ruudukko[x][y].getLaiva().onkoUponnut()) {
                    laivojaJaljella--;
                    System.out.println("Osui ja upposi!");
                } else {
                    System.out.println("Osui!");
                }
            } else {                                            //ruudussa ei ole laivaa
                System.out.println("Ohi meni.");
            }

            return true;
        }
    }

    public void pelaa() {
        while (laivojaJaljella > 0) {
            System.out.println("Rivi? (0-9)");
            int rivi = scan.nextInt();
            System.out.println("Sarake? (0-9)");
            int sarake = scan.nextInt();
            ammu(rivi, sarake);
        }
    }
}
