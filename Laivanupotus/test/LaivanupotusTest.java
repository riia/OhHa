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
    
    public LaivanupotusTest() {
    }

    @Before
    public void setUp() {
        laivapeli = new Laivanupotus();
        laivapeli.alustaRuudukko();
        paatti = new Laiva(2);
    }
    
    @After
    public void tearDown() {
    }
    
    
    
    
    
    @Test
    public void negatiiviseenRuutuunEiVoiAmpua(){
        boolean vastaus = laivapeli.ammu(-1, -1);
        assertEquals(false, vastaus);
    }
    
    @Test
    public void liianSuureenRuutuunEiVoiAmpua(){
        boolean vastaus = laivapeli.ammu(11, 1);
        assertEquals(false, vastaus);
    }
    
    @Test
    public void ampuminenOnnistuu(){
        
        boolean vastaus = laivapeli.ammu(3, 3);
        assertEquals(true, vastaus);
    }
    
    @Test 
    public void samaanRuutuunEiVoiAmpuaUudestaan(){
        laivapeli.ammu(1, 1);
        boolean vastaus = laivapeli.ammu(1, 1);
        assertEquals(false, vastaus);
    }
    
    @Test
    public void sijoitettuLaivaLoytyyRuudusta(){
        boolean vastaus = laivapeli.onkoLaivaa(1, 1);
        assertEquals(false, vastaus);
        
        laivapeli.sijoitaLaiva(paatti, 1, 1);
        vastaus = laivapeli.onkoLaivaa(1, 1);
        assertEquals(true, vastaus);
    }
}
