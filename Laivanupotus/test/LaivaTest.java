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
        int koko = laiva.GetKoko();
        assertEquals(3, koko);
    }
}
