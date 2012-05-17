/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

/**
 *
 * @author ohtamaa
 */
public class Laiva {

    private int koko = 0;
    private int osumienMaara;

    public Laiva(int koko) {
        this.koko = koko;
        osumienMaara = 0;
    }

    public int getKoko() {
        return koko;
    }
    
    public int getOsumienMaara(){
        return osumienMaara;
    }

    public boolean upposiko(){
        if (osumienMaara == koko) {
            return true;
        } else {
            return false;
        }
    }
    
    public void osuLaivaan() {
        osumienMaara++;
    }
    
    
}
