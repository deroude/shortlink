package ro.deroude.shortlink.api.impl;

import org.junit.Test;
import static org.junit.Assert.*;
import ro.deroude.shortlink.api.InvalidURLException;
import ro.deroude.shortlink.api.URLProcessor;

/**
 *
 * @author valentin.raduti
 */
public class DefaultURLProcessorTest {

    private final URLProcessor tested = new DefaultURLProcessor();

    public DefaultURLProcessorTest() {
    }

    @Test
    public void testProcessURL() throws InvalidURLException {
	assertEquals(tested.processURL("http://google.com"), "http://google.com");
    }

    @Test(expected = InvalidURLException.class)
    public void testProcessURLFailed() throws InvalidURLException {
	tested.processURL("httl://google.com");
    }
    
    @Test(expected = InvalidURLException.class)
    public void testProcessURLNull() throws InvalidURLException {
	tested.processURL(null);
    }

}
