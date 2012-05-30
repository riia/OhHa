/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import laivanupotus.Laiva;
import laivanupotus.Laivanupotus;

/**
 *
 * Laivanupotuspelin teksti-käyttöliittymä.
 */
public class Teksti {

    File file = new File("Lista.txt");
    Laivanupotus peli;
    Scanner scan = new Scanner(System.in);
    int rivi;
    int sarake;

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
    /**
     * Kysyy pelaajan nimen ja asettaa sen Pelaajalle
     */
    public void kysyPelaaja() {
        System.out.println("Nimesi:");
        String nimi = scan.nextLine();
        peli.getPelaaja().setNimi(nimi);
    }

    public void ruudukonTulostus() {
        for (int i = 0; i < peli.getKorkeus(); i++) {
            for (int j = 0; j < peli.getLeveys(); j++) {
                if (peli.onkoLaivaa(i, j)) {
                    System.out.print("L ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    public void tulosLista(File tiedosto) throws FileNotFoundException{
        Scanner lukija = new Scanner(tiedosto);
        while(lukija.hasNext()){
            System.out.println(lukija.nextLine());
        }
    }
    public void run() throws IOException {
        System.out.println("Tervetuloa pelaamaan laivanupotusta!");

        Laiva laiva5 = new Laiva(5);
        Laiva laiva4 = new Laiva(4);
        Laiva laiva3 = new Laiva(3);
        Laiva laiva2 = new Laiva(2);

        peli.alustaRuudukko();

        peli.sijoitaLaivaSatunnaiseen(laiva5);
        peli.sijoitaLaivaSatunnaiseen(laiva4);
        peli.sijoitaLaivaSatunnaiseen(laiva3);
        peli.sijoitaLaivaSatunnaiseen(laiva2);
        
        kysyPelaaja();
        tulostaPeli();
        
        
        while (peli.onkoPeliaJaljella()) {
            
            System.out.println("Valitse rivi (-1 lopettaa):");
            rivi = scan.nextInt();
            
            if (rivi == -1) {
                System.out.println("Lopetit pelin.");
                break;
            }
            System.out.println("Valitse sarake:");
            sarake = scan.nextInt();
            int osuiko = peli.ammu(rivi, sarake);
            if (osuiko == -1) {
                System.out.println("\nEt voi ampua tähän ruutun.\n");
            } else {
                if (osuiko == 2) {
                    System.out.println("\n***  Osui ja upposi!  ***\n");
                } else if (osuiko == 1) {
                    System.out.println("\n* Osui! *\n");
                } else {
                    System.out.println("\nOhi meni.\n");
                }
            }
            tulostaPeli();
        }
        System.out.println("Peli loppui!");
        System.out.println("Ammuit " + peli.getAmpumistenMaara() + " kertaa.");
        peli.getPelaaja().setParasTulos(peli.getAmpumistenMaara());
        peli.lisaaPelaajaListaan(peli.getPelaaja());
        tulosLista(file);
    }
    /**
     * Tulostaa peliruudukon 
     */
    public void tulostaPeli() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < peli.getKorkeus(); i++) {
            System.out.print(i + " ");
            for (int j = 0; j < peli.getLeveys(); j++) {

                if (peli.onkoAmmuttu(i, j)
                        && !peli.onkoLaivaa(i, j)) {
                    System.out.print("X ");
                } else if (peli.onkoAmmuttu(i, j)
                        && peli.onkoLaivaa(i, j)) {
                    if (peli.ruudukko[i][j].getLaiva().onkoUponnut()) {
                        System.out.print("* ");
                    } else {
                        System.out.print("L ");
                    }

                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    public void tulostaTuloslista() throws FileNotFoundException {
        Scanner tiedostoLukija = new Scanner(file);
        while (tiedostoLukija.hasNext()) {
            String tiedostonRivi = tiedostoLukija.nextLine();
            System.out.println(tiedostonRivi);
        }
    }
}
