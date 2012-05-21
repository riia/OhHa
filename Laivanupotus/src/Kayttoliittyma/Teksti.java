/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import laivanupotus.Laiva;
import laivanupotus.Laivanupotus;

/**
 *
 * @author ohtamaa
 */
public class Teksti {

    Laivanupotus laiva;
   
    public Teksti(Laivanupotus laiva){
        this.laiva = laiva;
        
    }
    
    public void run(){
        System.out.println("Tervetuloa!");
        laiva.kysyNimi();
        laiva.kysyRuudukonKoko();
        laiva.pelaa();
    }
    
    public void tulostaPeli() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!laiva.ruudukko[i][j].getAmmuttu()) {
                    System.out.println("O");
                } else if (laiva.ruudukko[i][j].getAmmuttu() 
                        && laiva.ruudukko[i][j].getLaiva().getKoko() == 0) {
                    System.out.println("X");
                } else if (laiva.ruudukko[i][j].getAmmuttu() 
                        && laiva.ruudukko[i][j].getLaiva().getKoko() != 0){
                    System.out.println("L");
                } else if (laiva.ruudukko[i][j].getAmmuttu() 
                        && laiva.ruudukko[i][j].getLaiva().onkoUponnut()){
                    System.out.println("*");
                }
             
            }
            System.out.println();
        }
    }
}
