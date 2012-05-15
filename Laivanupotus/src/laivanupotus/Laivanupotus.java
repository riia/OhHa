/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import java.util.Scanner;

/**
 *
 * @author ohtamaa
 */
public class Laivanupotus {
    Scanner scan = new Scanner(System.in);
    
    Laivanupotus peli;  
    String pelaaja;
    
    Ruutu[][] ruudukko = new Ruutu[10][10];


    public void KysyNimi() {
        System.out.println("Nimesi:");
        pelaaja = scan.nextLine();
    }


    public void SijoitaLaivat() {
        ruudukko[1][1] = new Ruutu(true, false);
    }

    public boolean OnkoAmmuttu(int x, int y) {
        if (ruudukko[x][y].ammuttu) {
            return true;
        }
        return false;
    }

    public boolean OnkoLaivaa(int x, int y) {
        if (ruudukko[x][y].laiva) {
            return true;
        }
        return false;
    }

    public void Ammu(int x, int y) {
        if (x > 10 || y > 10){
            System.out.println("Ruutu ei kentällä.");
        }else {
            ruudukko[x][y].setAmmuttu();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                
                System.out.println();
            }
        }
        
        
    }
}
