/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import laivanupotus.Laiva;
import laivanupotus.Laivanupotus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Riia
 */
public class LaivanupotusTest {

    Laivanupotus laivapeli;
    Laiva paatti;
    Laiva vene;

    public LaivanupotusTest() {
    }

    @Before
    public void setUp() {
        laivapeli = new Laivanupotus();
        laivapeli.alustaRuudukko();
        paatti = new Laiva(2);
        vene = new Laiva(1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void alustaRuudukkoAlustaaRuudukonLaivattomillaRuuduilla() {
        laivapeli.alustaRuudukko();
        boolean eiLaivaa = true;
        for (int i = 0; i < laivapeli.getKorkeus(); i++) {
            for (int j = 0; j < laivapeli.getLeveys(); j++) {
                if (laivapeli.onkoLaivaa(i, j)) {
                    eiLaivaa = false;
                    break;
                }
            }
        }
        assertTrue(eiLaivaa);

    }

    @Test
    public void alustaRuudukkoAlustaaRuudukonAmpumattomillaRuuduilla() {
        laivapeli.alustaRuudukko();
        boolean ammuttu = false;
        for (int i = 0; i < laivapeli.getKorkeus(); i++) {
            for (int j = 0; j < laivapeli.getLeveys(); j++) {
                if (laivapeli.onkoAmmuttu(i, j)) {
                    ammuttu = true;
                }
            }
        }
        assertFalse(ammuttu);
    }

    @Test
    public void onkoAmmuttuPalauttaaTrueKunRuutuunOnJoAmmuttu() {
        laivapeli.ruudukko[1][1].setAmmuttu();
        boolean vastaus = laivapeli.onkoAmmuttu(1, 1);
        assertTrue(vastaus);
    }

    @Test
    public void onkoAmmuttuPalauttaaFalseKunRuutuunEiOleAmmuttu() {
        boolean vastaus = laivapeli.onkoAmmuttu(1, 1);
        assertFalse(vastaus);
    }

    @Test
    public void onkoLaivaaPalauttaaTrueKunRuudussaOnLaiva() {
        laivapeli.ruudukko[1][1].setLaiva(paatti);
        boolean vastaus = laivapeli.onkoLaivaa(1, 1);
        assertTrue(vastaus);
    }

    @Test
    public void onkoLaivaaPalauttaaFalseKunRuudussaEiLaivaa() {
        boolean vastaus = laivapeli.onkoLaivaa(1, 1);
        assertFalse(vastaus);
    }

    @Test
    public void negatiiviseenRuutuunEiVoiAmpua() {
        int vastaus = laivapeli.ammu(-1, -1);
        assertEquals(-1, vastaus);
    }

    @Test
    public void liianSuureenRuutuunEiVoiAmpua() {
        int vastaus = laivapeli.ammu(9, 10);
        assertEquals(-1, vastaus);
        vastaus = laivapeli.ammu(10, 9);
        assertEquals(-1, vastaus);
    }

    @Test
    public void sopivaanRuutuunVoiAmpua() {
        int vastaus = laivapeli.ammu(9, 9);
        assertEquals(0, vastaus);
        vastaus = laivapeli.ammu(0, 0);
        assertEquals(0, vastaus);

    }

    @Test
    public void samaanRuutuunEiVoiAmpuaUudestaan() {
        laivapeli.ammu(1, 1);
        int vastaus = laivapeli.ammu(1, 1);
        assertEquals(-1, vastaus);
    }

    @Test
    public void sijoitettuLaivaLoytyyRuudusta() {
        boolean vastaus = laivapeli.onkoLaivaa(1, 1);
        assertFalse(vastaus);

        laivapeli.sijoitaLaiva(paatti, 1, 1);
        vastaus = laivapeli.onkoLaivaa(1, 1);
        assertTrue(vastaus);
    }

    @Test
    public void ammuMetodiPalauttaaNollaKunEiOsuta(){
        int vastaus = laivapeli.ammu(1, 1);
        assertEquals(0, vastaus);
    }
    @Test
    public void ammuMetodiOsuuKunAmmutaanRuutuunJossaLaiva() {
        laivapeli.sijoitaLaiva(paatti, 1, 1);
        int vastaus = laivapeli.ammu(1, 1);
        assertEquals(1, vastaus);
    }

    @Test
    public void ammuMetodiUpottaaLaivanKunOsutaanTarpeeksiMontaKertaa() {
        laivapeli.sijoitaLaiva(paatti, 1, 1);
        laivapeli.sijoitaLaiva(paatti, 1, 2);
        laivapeli.ammu(1, 1);
        int vastaus = laivapeli.ammu(1, 2);
        assertEquals(2, vastaus);
    }

    @Test
    public void sopivaLaivaSopiiRuudukkoon() {
        boolean vastaus = laivapeli.sopiikoLaiva(1, 1, 0, paatti);
        assertTrue(vastaus);
    }

    @Test
    public void laivaaEiVoiSijoittaaRuudukonUlkopuolelle() {
        boolean vastaus = laivapeli.sopiikoLaiva(9, 9, 0, paatti);
        assertFalse(vastaus);
    }

    @Test
    public void sijoitaLaivaAsettaaRuutuunOikeanLaivan() {
        laivapeli.sijoitaLaiva(paatti, 1, 1);
        Laiva vastaus = laivapeli.ruudukko[1][1].getLaiva();
        assertEquals(paatti, vastaus);
    }

    @Test
    public void peliaOnJaljellaKunLaivojaOnAmpumatta() {
        laivapeli.sijoitaLaivaSatunnaiseen(paatti);
        boolean vastaus = laivapeli.onkoPeliaJaljella();
        assertTrue(vastaus);
    }

    @Test
    public void peliaEiOleJaljellaKunKaikkiLaivatUpotettu() {
        boolean vastaus = laivapeli.onkoPeliaJaljella();
        assertFalse(vastaus);
    }
    
    @Test
    public void pelaajaLisataanListaan() throws IOException{
        
    }
}
