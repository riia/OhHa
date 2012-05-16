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

    boolean laiva;
    boolean ammuttu;

    public Ruutu(){
        this.laiva = false;
        this.ammuttu = false;
    }
    public Ruutu(boolean laiva, boolean ammuttu) {
        this.laiva = laiva;
        this.ammuttu = ammuttu;
    }

    public boolean getLaiva() {
        return this.laiva;
    }

    public boolean getAmmuttu() {
        return this.ammuttu;
    }
    
    public boolean setLaiva(){
        return laiva = true;
    }
    public boolean setAmmuttu(){
        return ammuttu = true;
    }
}
