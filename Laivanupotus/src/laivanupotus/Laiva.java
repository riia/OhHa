/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

/**
 * 
 * Laiva-luokka. Laivalla on koko ja tieto kuinka monta kertaa siihen on osuttu.
 */
public class Laiva {

    /**
     * Laivan koko eli moneenko ruutuun se voidaan sijoittaa
     */
    private int koko = 0;
    /**
     * Kuinka monta kertaa laivaan on osuttu.
     */
    private int osumienMaara;

    public Laiva(int koko) {
        this.koko = koko;
        osumienMaara = 0;
    }

    /**
     * Palauttaa laivan koon
     * @return Laivan koko
     */
    public int getKoko() {
        return koko;
    }

    /**
     * Palauttaa laivan osumien määrän
     * @return Laivan osumien määrä
     */
    public int getOsumienMaara() {
        return osumienMaara;
    }

    /**
     *  Tarkistaa onko laiva uponnut
     * @return true jos laivaan on osuttu laivan koon verran
     */
    public boolean onkoUponnut() {
        return osumienMaara == koko;
    }

    /**
     * Lisää laivan osumien määrää
     */
    public void osuLaivaan() {
        osumienMaara++;
    }
}
