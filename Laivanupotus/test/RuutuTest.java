/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import laivanupotus.Ruutu;
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
public class RuutuTest {
    
    public RuutuTest() {
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
    public void konstruktoriLuoLaivattomanRuudun(){
        Ruutu ruutu = new Ruutu();
        boolean vastaus = ruutu.getLaiva();
        assertEquals(false, vastaus);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
