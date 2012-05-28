/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Laivanupotuspelin pelialusta. Ruutu-olioista koostuva ruudukko, jonne voi
 * sijoittaa laivoja ja jota voi ampua.
 * @author ohtamaa
 */
public class Laivanupotus implements ActionListener{

    Scanner scan = new Scanner(System.in);
    ArrayList<Pelaaja> Lista = new ArrayList<Pelaaja>();
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

    /**
     *
     * Asettaa ruudukon korkeuden
     */
    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }

    /**
     *
     * Asettaa ruudukon leveyden
     */
    public void setLeveys(int leveys) {
        this.leveys = leveys;
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
    public void setPelaaja(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;

    }

    
    /**
     *
     * Tarkistaa voiko laivaa sijoittaa kohdasta (x,y) lähtien
     */
    public boolean sopiikoLaiva(int x, int y, int suunta, Laiva laiva) {
        int laivaaJaljella = laiva.getKoko();

        boolean sopiiko = false;

        while (laivaaJaljella > 0) {
            if (osuikoRuudukkoon(x, y) && !onkoLaivaa(x, y)) {
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
        int rivi;
        int sarake;
        int suunta;

        do {
            rivi = arpoja.nextInt(korkeus);
            sarake = arpoja.nextInt(leveys);
            suunta = arpoja.nextInt(2);
        } while (!sopiikoLaiva(rivi, sarake, suunta, laiva));

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

    /**
     *
     * Sijoittaa laivan ruudukkoon kohtaan (x,y)
     */
    public void sijoitaLaiva(Laiva laiva, int x, int y) {
        ruudukko[x][y].setLaiva(laiva);
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        Laivanupotus peli = new Laivanupotus();
    }
}
