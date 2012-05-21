/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

/**
 *
 * @author ohtamaa
 */
public class Ruutu {

    Laiva eiLaivaa = new Laiva(0);
    Laiva laiva;
    boolean ammuttu;

    public Ruutu() {
        this.ammuttu = false;
        this.laiva = eiLaivaa;
    }

    /**
     *
     * Kertoo onko ruutua ammuttu
     */
    public boolean getAmmuttu() {
        return ammuttu;
    }

    /**
     *
     * Palauttaa ruudussa olevan laivan
     */
    public Laiva getLaiva() {
        return laiva;
    }

    /**
     *
     * Määrittää ruudun ammutuksi
     */
    public boolean setAmmuttu() {
        return ammuttu = true;
    }

    /**
     *
     * Asettaa ruutuun laivan
     */
    public Laiva setLaiva(Laiva laiva) {
        return this.laiva = laiva;
    }
}
