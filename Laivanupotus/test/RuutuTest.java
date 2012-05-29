/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import laivanupotus.Laiva;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
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
    public void konstruktoriLuoAmpumattomanRuudun(){
        Ruutu ruutu = new Ruutu();
        boolean vastaus = ruutu.getAmmuttu();
        assertFalse(vastaus);
    }
    
    @Test
    public void konstruktoriLuoLaivattomanRuudun(){
        Ruutu ruutu = new Ruutu();
        Laiva vastaus = ruutu.getLaiva();
        assertNull(vastaus);
        
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
