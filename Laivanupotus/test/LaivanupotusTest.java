/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
    public void negatiiviseenRuutuunEiVoiAmpua(){
        int vastaus = laivapeli.ammu(-1, -1);
        assertEquals(-1, vastaus);
    }
    
    @Test
    public void liianSuureenRuutuunEiVoiAmpua(){
        int vastaus = laivapeli.ammu(9, 10);
        assertEquals(-1, vastaus);
        vastaus = laivapeli.ammu(10, 9);
        assertEquals(-1, vastaus);
    }
    
    @Test
    public void ampuminenOnnistuu(){
        int vastaus = laivapeli.ammu(9, 9);
        assertEquals(0, vastaus);
        vastaus = laivapeli.ammu(0, 0);
        assertEquals(0, vastaus);
        
    }
    
    @Test 
    public void samaanRuutuunEiVoiAmpuaUudestaan(){
        laivapeli.ammu(1, 1);
        int vastaus = laivapeli.ammu(1, 1);
        assertEquals(-1, vastaus);
    }
    
    @Test
    public void sijoitettuLaivaLoytyyRuudusta(){
        boolean vastaus = laivapeli.onkoLaivaa(1, 1);
        assertEquals(false, vastaus);
        
        laivapeli.sijoitaLaiva(paatti, 1, 1);
        vastaus = laivapeli.onkoLaivaa(1, 1);
        assertEquals(true, vastaus);
    }
    
    @Test
    public void laivaUppoaaKunOsutaanTarpeeksiMontaKertaa(){
        laivapeli.sijoitaLaiva(paatti, 1, 1);
        laivapeli.sijoitaLaiva(paatti, 1, 2);
        laivapeli.ammu(1, 1);
        int vastaus = laivapeli.ammu(1, 2);
        assertEquals(2, vastaus);
    }
    
    @Test
    public void sopivaLaivaSopiiRuudukkoon(){
        boolean vastaus = laivapeli.sopiikoLaiva(1, 1, 0, paatti);
        assertEquals(true, vastaus);
    }
    
    @Test  
    public void laivaaEiVoiSijoittaaRuudukonUlkopuolelle(){
        boolean vastaus = laivapeli.sopiikoLaiva(9, 9, 0, paatti);
        assertEquals(false, vastaus);
    }
}
