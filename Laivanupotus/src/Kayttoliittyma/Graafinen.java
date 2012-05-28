/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import laivanupotus.Laivanupotus;

/**
 *
 * Laivanupotuspelin graafinen käyttöliittymä.
 */
public class Graafinen implements Runnable, ActionListener {

    private JFrame frame;
    Laivanupotus peli;

    public Graafinen(Laivanupotus laiva) {
        this.peli = laiva;
    }

    @Override
    public void run() {
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setLayout(new GridLayout(5, 1));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public JPanel luoRuudukko() {
        JPanel panel = new JPanel(new GridLayout(peli.getKorkeus(), peli.getLeveys()));
        for (int i = 0; i < peli.getKorkeus(); i++) {
            for (int j = 0; j < peli.getLeveys(); j++) {

                if (peli.onkoAmmuttu(i, j) && !peli.onkoLaivaa(i, j)) {
                    panel.add(new TextField("X"));
                } else if (peli.onkoAmmuttu(i, j) && peli.onkoLaivaa(i, j)) {
                    panel.add(new TextField("L"));
                } else if (peli.onkoAmmuttu(i, j) && peli.ruudukko[i][j].getLaiva().onkoUponnut()) {
                    panel.add(new TextField("*"));
                } else {
                    panel.add(new JButton("O"));
                }
            }
        }

        return panel;
    }

    public void luoKomponentit(Container container) {


//
//        JLabel teksti = new JLabel("Tervetuloa pelaamaan laivanupotusta!");
//        JLabel nimi = new JLabel("Nimi:");
//        JTextField nimiKentta = new JTextField(30);
//        JButton aloitus = new JButton("Aloita peli");
//
//        container.add(teksti);
//        container.add(nimi);
//        container.add(nimiKentta);
//        container.add(aloitus);
        container.add(luoRuudukko());

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
}
