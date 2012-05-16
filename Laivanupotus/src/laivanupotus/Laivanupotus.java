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
    
      
    String pelaaja;
    int laivojaJaljella = 10;
    
    Ruutu[][] ruudukko = new Ruutu[10][10];


    public void kysyNimi() {
        System.out.println("Nimesi:");
        pelaaja = scan.nextLine();
    }


    public void sijoitaLaivat() {

    }

    public boolean onkoAmmuttu(int x, int y) {
        if (ruudukko[x][y].ammuttu) {
            return true;
        }
        return false;
    }

    public boolean onkoLaivaa(int x, int y) {
        
        return false;
    }

    public void ammu(int x, int y) {
        if (x > 10 || y > 10){
            System.out.println("Ruutu ei kentällä.");
        }else {
            ruudukko[x][y].setAmmuttu();
        }
    }
    
    public void pelaa(){
        while (laivojaJaljella > 0){
            System.out.println("Rivi?");
            int rivi = scan.nextInt();
            System.out.println("Sarake?");
            int sarake = scan.nextInt();
            ammu(rivi, sarake);
        }
    }

    
}
