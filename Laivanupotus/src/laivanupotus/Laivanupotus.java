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
    int laivojaJaljella;
    public Ruutu[][] ruudukko = new Ruutu[10][10];

    public Laivanupotus() {
        this.laivojaJaljella = 5;
        
    }
    
    
    public void alustaRuudukko() {
        Laiva laiva = new Laiva(0);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ruudukko[i][j].setLaiva(laiva);
            }
        }
    }

    public void kysyNimi() {
        System.out.println("Nimesi:");
        pelaaja = scan.nextLine();
    }

    public void sijoitaLaiva(Laiva laiva, int x, int y) {
        ruudukko[x][y].setLaiva(laiva);
    }

    public boolean ammu(int x, int y) {
        if (x > 10 || y > 10) {
            System.out.println("Ruutu ei sijaitse ruudukolla");
            return false;
        } else if (ruudukko[x][y].getAmmuttu()) {
            System.out.println("Olet jo ampunut tähän ruutuun.");
            return false;
        } else {
            ruudukko[x][y].setAmmuttu();
            if (ruudukko[x][y].getLaiva().getKoko() != 0) {
                ruudukko[x][y].getLaiva().osuLaivaan();
                if (ruudukko[x][y].getLaiva().upposiko()) {
                    laivojaJaljella--;
                    System.out.println("Osui ja upposi!");
                } else {
                    System.out.println("Osui!");
                }
            } else {
                System.out.println("Ohi meni.");
            }
            return true;

        }
    }

    public void pelaa() {
        while (laivojaJaljella > 0) {
            System.out.println("Rivi? (0-9)");
            int rivi = scan.nextInt();
            System.out.println("Sarake? (0-9)");
            int sarake = scan.nextInt();
            ammu(rivi, sarake);
        }
    }
}
