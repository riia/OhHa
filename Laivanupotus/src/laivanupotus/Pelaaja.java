/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

/**
 *
 * Ppelaaja-luokasta löytyy pelaajan nimi ja paras tulos pelissä.
 */
public class Pelaaja {
    
    String nimi;
    int parasTulos;
    
    public Pelaaja(String nimi){
        this.nimi = nimi;
        
    }
    /**
     *
     * Palauttaa pelaajan nimen
     */
    public String getNimi(){
        return nimi;
    }
    
    /**
     *
     * Palauttaa pelaajan parhaan tuloksen
     */
    public int getParasTulos(){
        return parasTulos;
    }
    /**
     *
     * Asettaa pelaajalle parhaan tuloksen
     */
    public void setParasTulos(int tulos){
        this.parasTulos = tulos;
    }
}
