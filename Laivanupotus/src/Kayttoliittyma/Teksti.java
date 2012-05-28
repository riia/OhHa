/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.util.Scanner;
import laivanupotus.Laiva;
import laivanupotus.Laivanupotus;

/**
 *
 * Teksti-käyttöliittymä
 */
public class Teksti {

    Laivanupotus peli;
    Scanner scan = new Scanner(System.in);

    public Teksti(Laivanupotus laiva) {
        this.peli = laiva;


    }
    /**
     *
     * Kysytään käyttäjältä ruudukon korkeus ja leveys
     */
    public void kysyRuudukonKoko() {
        System.out.println("Ruudukon korkeus:");
        int korkeus = scan.nextInt();
        peli.setKorkeus(korkeus);
        System.out.println("Ruudukon leveys:");
        int leveys = scan.nextInt();
        peli.setLeveys(leveys);
    }
    
    public void kysyPelaaja(){
        System.out.println("Nimesi:");
        String nimi = scan.nextLine();
        
    }

    public void ruudukonTulostus(){
        for (int i = 0; i < peli.getKorkeus(); i++) {
            for (int j = 0; j < peli.getLeveys(); j++) {
                if(peli.onkoLaivaa(i, j)) {
                    System.out.print("L ");
                } else{
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
    public void run() {
        System.out.println("Tervetuloa!");
        
        Laiva laiva5 = new Laiva(5);
        Laiva laiva4 = new Laiva(4);
        Laiva laiva3 = new Laiva(3);
        Laiva laiva2 = new Laiva(2);
        Laiva laiva1 = new Laiva(1);
        
        
        peli.alustaRuudukko();
        
        peli.sijoitaLaivaSatunnaiseen(laiva5);
        peli.sijoitaLaivaSatunnaiseen(laiva4);
        peli.sijoitaLaivaSatunnaiseen(laiva3);
        peli.sijoitaLaivaSatunnaiseen(laiva2);
        peli.sijoitaLaivaSatunnaiseen(laiva1);
        
        ruudukonTulostus();
        
        while (peli.onkoPeliaJaljella()) {
            tulostaPeli();
            System.out.println("Valitse rivi:");
            int rivi = scan.nextInt();
            System.out.println("Valitse sarake:");
            int sarake = scan.nextInt();
            int osuiko = peli.ammu(rivi, sarake);
            if (osuiko == -1) {
                System.out.println("Et voi ampua tähän ruutun.");
            } else {
                
                if (osuiko == 2) {
                    System.out.println("Osui ja upposi!");
                } else if (osuiko == 1) {
                    System.out.println("Osui!");
                } else {
                    System.out.println("Ohi meni.");
                }
            }
        }
        System.out.println("Peli loppui!");
    }

    public void tulostaPeli() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < peli.getKorkeus(); i++) {
            System.out.print(i + " ");
            for (int j = 0; j < peli.getLeveys(); j++) {
                if (!peli.onkoAmmuttu(i, j)) {
                    System.out.print("O ");
                } else if (peli.onkoAmmuttu(i, j)
                        && !peli.onkoLaivaa(i, j)) {
                    System.out.print("X ");
                } else if (peli.onkoAmmuttu(i, j)
                        && peli.onkoLaivaa(i, j)) {
                    System.out.print("L ");
                } else if (peli.onkoAmmuttu(i, j)
                        && peli.ruudukko[i][j].getLaiva().onkoUponnut()) {
                    System.out.print("* ");
                }

            }
            System.out.println();
        }
    }
}
