/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container){
        JLabel teksti = new JLabel("Tervetuloa pelaamaan laivanupotusta!");
        container.add(teksti, BorderLayout.NORTH);
    }
    
}
