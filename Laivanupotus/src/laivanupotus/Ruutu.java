/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

/**
 * Ruutu-luokka. Ruutuun voi sijoittaa Laiva-olion ja ruudulla on tieto onko
 * sitä ammuttu.
 */
public class Ruutu {

    /**
     * Laiva joka ruudussa on
     */
    Laiva laiva;
    /**
     * True jos ruutuun on ammuttu
     */
    boolean ammuttu;

    public Ruutu() {
        this.ammuttu = false;
        this.laiva = null;
    }

    /**
     * Kertoo onko ruutua ammuttu
     * @return true jos ruutua on ammuttu
     */
    public boolean getAmmuttu() {
        return ammuttu;
    }

    /**
     * Palauttaa ruudussa olevan laivan
     * @return Laiva joka on ruudussa, null jos laivaa ei ole
     */
    public Laiva getLaiva() {
        return laiva;
    }

    /**
     * Määrittää ruudun ammutuksi
     */
    public void setAmmuttu() {
        ammuttu = true;
    }

    /**
     * Asettaa ruutuun laivan
     */
    public void setLaiva(Laiva laiva) {
        this.laiva = laiva;
    }
}
