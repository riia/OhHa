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

    private int koko = 0;
    private int osumienMaara;

    public Laiva(int koko) {
        this.koko = koko;
        osumienMaara = 0;
    }

    /**
     *
     * Palauttaa laivan koon
     */
    public int getKoko() {
        return koko;
    }

    /**
     *
     * Palauttaa laivan osumien määrän
     */
    public int getOsumienMaara() {
        return osumienMaara;
    }

    /**
     *
     * Tarkistaa onko laiva uponnut
     */
    public boolean onkoUponnut() {
        if (osumienMaara == koko) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * Lisää laivan osumien määrää
     */
    public void osuLaivaan() {
        osumienMaara++;
    }
}
