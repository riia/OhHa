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
    
    public Pelaaja(){
    }
    /**
     *
     * Palauttaa pelaajan nimen.
     */
    public String getNimi(){
        return nimi;
    }
    
    /**
     *
     * Palauttaa pelaajan parhaan tuloksen.
     */
    public int getParasTulos(){
        return parasTulos;
    }
    /**
     *
     * Asettaa pelaajalle nimen.
     */
    public void setNimi(String nimi){
        this.nimi = nimi;
    }
    /**
     *
     * Asettaa pelaajalle parhaan tuloksen.
     */
    public void setParasTulos(int tulos){
        this.parasTulos = tulos;
    }
    
    @Override
    public String toString(){
        return nimi + "." +  parasTulos;
    }
}
