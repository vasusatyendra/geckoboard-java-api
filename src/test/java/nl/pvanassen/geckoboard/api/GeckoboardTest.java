package nl.pvanassen.geckoboard.api;

import java.io.IOException;

import org.junit.Test;

/**
 * Input validation test
 * @author Paul van Assen
 *
 */
public class GeckoboardTest {

    @Test( expected = IllegalArgumentException.class )
    public void testGeckoboardEmpty() {
        new Geckoboard( "" );
    }

    @Test( expected = IllegalArgumentException.class )
    public void testGeckoboardNull() {
        new Geckoboard( null );
    }

    @Test( expected = IllegalArgumentException.class )
    public void testPushNull() throws IOException {
        Geckoboard geckoboard = new Geckoboard( "test" );
        geckoboard.push( null );
    }

}
