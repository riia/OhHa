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
    
    private int koko;
    private int osumienMaara;
    
    public Laiva(int koko){
        this.koko = koko;
        osumienMaara = 0;
    }
    
    public int GetKoko(){
        return koko;
    }
}
