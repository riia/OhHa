/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author ohtamaa
 */
public class Graafinen implements Runnable {
    
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(700, 150));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container){
        GridLayout layout = new GridLayout(4, 2);
        container.setLayout(layout);
        
        JLabel teksti = new JLabel("Tervetuloa pelaamaan laivanupotusta!");
        JLabel nimi = new JLabel("Nimi:");
        JTextField nimiKentta = new JTextField();
        JLabel korkeus = new JLabel("Kentän korkeus:");
        JTextField korkeusKentta = new JTextField();
        JLabel leveys = new JLabel("Kentän leveys:");
        JTextField leveysKentta = new JTextField();
        
        
        container.add(teksti, BorderLayout.NORTH);
        container.add(new JLabel(""));
        container.add(nimi);
        container.add(nimiKentta);
        container.add(korkeus);
        container.add(korkeusKentta);
        container.add(leveys);
        container.add(leveysKentta);
    }
    
}
