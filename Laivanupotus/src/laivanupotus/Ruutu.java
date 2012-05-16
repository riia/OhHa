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

    Laiva laiva;
    boolean ammuttu;

    public Ruutu(){
        
        this.ammuttu = false;
    }
    public Ruutu(Laiva laiva, boolean ammuttu) {
        this.laiva = laiva;
        this.ammuttu = ammuttu;
    }

    public boolean getAmmuttu() {
        return this.ammuttu;
    }
    
    
    public boolean setAmmuttu(){
        return ammuttu = true;
    }
}
