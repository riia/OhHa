/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import Kayttoliittyma.Teksti;

/**
 *
 * @author ohtamaa
 */
public class Main {
    public static void main(String[] args){
        Laivanupotus laiva = new Laivanupotus();
        Teksti kayttoliittyma = new Teksti(laiva);
    }
}