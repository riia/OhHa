/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import laivanupotus.Laiva;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ohtamaa
 */
public class LaivaTest {
    
    public LaivaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriLuoOikeanKokoisenLaivan(){
        Laiva laiva = new Laiva(3);
        int koko = laiva.getKoko();
        assertEquals(3, koko);
    }
    @Test
    public void laivaanOsuminenKasvattaaOsumienMaaraa(){
        Laiva laiva = new Laiva(3);
        laiva.osuLaivaan();
        int osumat = laiva.getOsumienMaara();
        assertEquals(1, osumat);
    }
    
    @Test
    public void laivaUppoaaKunSiihenOsuuTarpeeksiMontaKertaa(){
        Laiva laiva = new Laiva(2);
        laiva.osuLaivaan();
        laiva.osuLaivaan();
        boolean vastaus = laiva.onkoUponnut();
        assertEquals(true, vastaus);
    }
    
    @Test
    public void laivaEiUppoaKunEiOleOsuttuTarpeeksi(){
        Laiva laiva = new Laiva(2);
        laiva.osuLaivaan();
        boolean vastaus = laiva.onkoUponnut();
        assertEquals(false, vastaus);
    }
}
