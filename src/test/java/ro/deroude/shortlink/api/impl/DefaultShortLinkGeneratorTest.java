package ro.deroude.shortlink.api.impl;

import org.junit.Test;
import static org.junit.Assert.*;
import ro.deroude.shortlink.api.ShortLinkGenerator;

/**
 *
 * @author valentin.raduti
 */
public class DefaultShortLinkGeneratorTest {
    
    public DefaultShortLinkGeneratorTest() {
    }
    
    private final ShortLinkGenerator tested=new DefaultShortLinkGenerator();

    @Test
    public void testGenerate() {
	assertEquals(tested.generate(0), "yl");
	assertEquals(tested.generate(-100), "yl");
	assertEquals(tested.generate(1), "byl");
	assertEquals(tested.generate(54), "3yl");
	assertEquals(tested.generate(1000000000), "blnO7Nyl");
    }
    
}
