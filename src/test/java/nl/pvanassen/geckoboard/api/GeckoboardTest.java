package nl.pvanassen.geckoboard.api;

import java.io.IOException;

import nl.pvanassen.geckoboard.api.error.ValidationException;

import org.junit.Rule;
import org.junit.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

/**
 * Input validation test
 * 
 * @author Paul van Assen
 *
 */
public class GeckoboardTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8080);

    @Test(expected = IllegalArgumentException.class)
    public void testGeckoboardEmpty() {
        new Geckoboard("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGeckoboardNull() {
        new Geckoboard(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPushNull() throws IOException {
        Geckoboard geckoboard = new Geckoboard("test");
        geckoboard.push(null);
    }

    @Test
    public void testHttpCalls() throws IOException {
        WireMock.stubFor(WireMock
                .get(WireMock.urlEqualTo("/my/resource"))
                .withHeader("Accept", WireMock.equalTo("text/xml"))
                .willReturn(
                        WireMock.aResponse().withStatus(200).withHeader("Content-Type", "text/xml")
                                .withBody("<response>Some content</response>")));

        Geckoboard geckoboard = new Geckoboard("test");
        geckoboard.setBaseUrl("http://localhost:8080/");
        geckoboard.push(new MockedPush());
        /*
         * assertTrue(result.wasSuccessFul());
         * 
         * verify(postRequestedFor(urlMatching("/my/resource/[a-z0-9]+"))
         * .withRequestBody(matching(".*<message>1234</message>.*")) .withHeader("Content-Type",
         * notMatching("application/json")));
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
