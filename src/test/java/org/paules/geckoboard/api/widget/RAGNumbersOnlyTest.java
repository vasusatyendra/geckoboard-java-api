package org.paules.geckoboard.api.widget;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class RAGNumbersOnlyTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        RAGNumbersOnly ragNumbersOnly = new RAGNumbersOnly( "1234" );
        ragNumbersOnly.setRed( "Test-red", 123 );
        ragNumbersOnly.setAmber( "Test-amber", 1234 );
        ragNumbersOnly.setGreen( "Test-green", 12345 );

        ObjectMapper om = new ObjectMapper();
        JsonNode node = om.readTree( ragNumbersOnly.toJson() );

        assertEquals( 3, node.get( "item" ).size() );
        assertEquals( "Test-red", node.get( "item" ).get( 0 ).get( "text" ).asText() );
        assertEquals( 123, node.get( "item" ).get( 0 ).get( "value" ).asInt() );

        assertEquals( "Test-amber", node.get( "item" ).get( 1 ).get( "text" ).asText() );
        assertEquals( 1234, node.get( "item" ).get( 1 ).get( "value" ).asInt() );

        assertEquals( "Test-green", node.get( "item" ).get( 2 ).get( "text" ).asText() );
        assertEquals( 12345, node.get( "item" ).get( 2 ).get( "value" ).asInt() );
    }

}
