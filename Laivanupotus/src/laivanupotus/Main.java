/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;


import Kayttoliittyma.Teksti;
import java.io.IOException;

/**
 *
 * @author ohtamaa
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Laivanupotus laiva = new Laivanupotus();
        Teksti kayttoliittyma = new Teksti(laiva);
        
        kayttoliittyma.run();
        
//        Graafinen graaf = new Graafinen(laiva);
//        graaf.run();
        
    }
}
