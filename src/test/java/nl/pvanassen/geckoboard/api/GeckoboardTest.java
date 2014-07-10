package nl.pvanassen.geckoboard.api;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import java.io.IOException;

import nl.pvanassen.geckoboard.api.error.ValidationException;

import org.junit.Rule;
import org.junit.Test;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

/**
 * Input validation test
 * @author Paul van Assen
 *
 */
public class GeckoboardTest {
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8080);
    
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
    
    @Test
    public void testHttpCalls() throws IOException {
        stubFor(get(urlEqualTo("/my/resource"))
                .withHeader("Accept", equalTo("text/xml"))
                .willReturn(aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "text/xml")
                    .withBody("<response>Some content</response>")));

        Geckoboard geckoboard = new Geckoboard( "test" );
        geckoboard.setBaseUrl( "http://localhost:8080/" );
        geckoboard.push( new MockedPush() );
        /*
        assertTrue(result.wasSuccessFul());

        verify(postRequestedFor(urlMatching("/my/resource/[a-z0-9]+"))
                .withRequestBody(matching(".*<message>1234</message>.*"))
                .withHeader("Content-Type", notMatching("application/json")));
                */
    }
    
    private static class MockedPush extends Push {
        public MockedPush() {
            super("123");
        }
        
        @Override
        protected void validate() throws ValidationException {
        }
    }

}
