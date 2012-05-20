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
        this.laiva = new Laiva(0);
    }
    
    public boolean getAmmuttu() {
        return this.ammuttu;
    }
    
    public Laiva getLaiva(){
        return laiva;
    }
    public boolean setAmmuttu(){
        return ammuttu = true;
    }
    
    public Laiva setLaiva(Laiva laiva){
        return this.laiva = laiva;
    }
}
