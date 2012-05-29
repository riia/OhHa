/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import javax.swing.JButton;

/**
 *
 * @author ohtamaa
 */
public class MunButton extends JButton {

    int rivi;
    int sarake;

    public MunButton(String text, int x, int y) {
        super(text);
        rivi = x;
        sarake = y;
    }

    public int getRivi() {
        return rivi;
    }

    public int getSarake() {
        return sarake;
    }
}
