/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Random;
import java.util.Scanner;

/**
 * Laivanupotuspelin pelialusta. Sisältää Ruutu-olioista koostuvan ruudukon, jonne voi
 * sijoittaa laivoja ja jota voi ampua.
 * 
 * 
 */
public class Laivanupotus {

    File lista = new File("Lista.txt");
    FileWriter kirjoittaja;

//    Scanner tiedostoLukija = new Scanner(lista);
    Scanner scan = new Scanner(System.in);
    /**
     * Pelin pelaaja
     */
    Pelaaja pelaaja = new Pelaaja();
    /**
     * Arvo, joka kertoo kuinka monta kertaa pelaaja on pelissä ampunut.
     */
    int ampumistenMaara = 0;
    /**
     * Kertoo kuinka monta laivaa pelissä on vielä upottamatta.
     */
    int laivojaJaljella;
    /**
     * Peliruudukon korkeus
     */
    int korkeus;
    /**
     * Peliruudukon leveys
     */
    int leveys;
    /**
     * Itse peliruudukko, jossa ammuttavat ruudut.
     */
    public Ruutu[][] ruudukko;

    public Laivanupotus() {
        korkeus = 10;
        leveys = 10;
        this.laivojaJaljella = 0;
        ruudukko = new Ruutu[korkeus][leveys];
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
     * 
     */
    public void setLeveys(int leveys) {
        this.leveys = leveys;
    }

    /**
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
     * Palauttaa ampumiskertojen lukumäärän.
     */
    public int getAmpumistenMaara() {
        return ampumistenMaara;
    }

    /**
     *
     * Palauttaa pelaajan.
     */
    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    /**
     *  Lisää pelaajan nimen ja tuloksen tuloslistaan.
     * @param pelaaja Lisättävä pelaajaa
     */
    public void lisaaPelaajaListaan(Pelaaja pelaaja) throws IOException {
        kirjoittaja = new FileWriter("Lista.txt");
        
        kirjoittaja.append(pelaaja + "\n");
        kirjoittaja.close();
    }

    /**
     *
     * Tarkistaa voiko laivaa sijoittaa kohdasta (x,y) lähtien
     * @param x         käyttäjän antama ruudukon rivi, johon laivaa ollaan 
     *                  sijoittamassa
     * @param y         käyttäjän antama ruudukon sarake, johon laivaa ollaan 
     *                  sijoittamassa
     * @param suunta    0 tai 1
     * @param laiva     Käyttäjän antama Laiva-olio
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
        return sopiiko == true;

    }

    /**
     *
     * Sijoittaa laivan satunnaisesesta ruudusta lähtien
     * @param laiva Käyttäjän antama laiva joka sijoitetaan
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
     * Sijoittaa laivan ruudukkoon kohtaan (x,y)
     * @param laiva sijoitettava laiva
     * @param x rivi, johon sijoitetaan
     * @param y sarake, johon sijoitetaan
     */
    public void sijoitaLaiva(Laiva laiva, int x, int y) {
        ruudukko[x][y].setLaiva(laiva);
    }

    /**
     * Tarkistaa ovatko koordinaatit ruudukolla
     * @return true jos koordinaatit löytyvät ruudukosta
     */
    public boolean osuikoRuudukkoon(int x, int y) {
        if (x < 0 || y < 0 || x >= korkeus || y >= leveys) {
            return false;
        }
        return true;
    }

    /**
     * Tarkistaa onko ruudussa laivaa
     * @return true jos ruudussa on jokin laiva
     */
    public boolean onkoLaivaa(int x, int y) {
        return ruudukko[x][y].getLaiva() != null;
    }

    /**
     *  Tarkistaa onko ruutua jo ammuttu
     * @return true jos ruutua on ammuttu
     */
    public boolean onkoAmmuttu(int x, int y) {
        return ruudukko[x][y].getAmmuttu();
    }

    /**
     * Ampuu ruutua. Tarkistaa, voiko kyseiseen ruutuun ampua ja onko 
     * ruudussa laivaa sekä toimii näiden tietojen mukaan.
     * 
     * @param x Ruudukon rivi johon ammutaan
     * @param y Ruudukon sarake johon ammutaan
     * @return -1 jos ruutuun ei voi ampua, 0-2 sen mukaan onko ruudussa laivaa
     *          ja onko mahdollinen laiva uponnut
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
     * Tarkistaa onko laivoja vielä löytämättä eli vieläkö peliä jatketaan
     * @return True jos pelissä vielä laivoja
     */
    public boolean onkoPeliaJaljella() {
        return laivojaJaljella > 0;
    }
}
