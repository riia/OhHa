/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import laivanupotus.Laivanupotus;

/**
 *
 * @author ohtamaa
 */
public class Teksti {

    public Teksti(){
        
    }
    
    public void tulostaPeli(Laivanupotus peli) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!peli.ruudukko[i][j].getAmmuttu()) {
                    System.out.println("O");
                } else if (peli.ruudukko[i][j].getAmmuttu() 
                        && peli.ruudukko[i][j].getLaiva().getKoko() == 0) {
                    System.out.println("X");
                } else if (peli.ruudukko[i][j].getAmmuttu() 
                        && peli.ruudukko[i][j].getLaiva().getKoko() != 0){
                    System.out.println("L");
                } else if (peli.ruudukko[i][j].getAmmuttu() 
                        && peli.ruudukko[i][j].getLaiva().upposiko()){
                    System.out.println("*");
                }
             
            }
            System.out.println();
        }
    }
}
