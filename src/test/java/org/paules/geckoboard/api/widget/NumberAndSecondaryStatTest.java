package org.paules.geckoboard.api.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.paules.geckoboard.api.type.GraphType;

public class NumberAndSecondaryStatTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        NumberAndSecondaryStat nass = new NumberAndSecondaryStat( "1234", true, GraphType.REVERSE, "$" );
        nass.setPrimary( 10 );
        nass.setSecondary( 20 );

        ObjectMapper om = new ObjectMapper();
        JsonNode node = om.readTree( nass.toJson() );
        assertTrue( node.get( "absolute" ).asBoolean() );
        assertEquals( "reverse", node.get( "type" ).asText() );
        assertEquals( 10, node.get( "item" ).get( 0 ).get( "value" ).asInt() );
        assertEquals( "", node.get( "item" ).get( 0 ).get( "label" ).asText() );
        assertEquals( "$", node.get( "item" ).get( 0 ).get( "prefix" ).asText() );
        assertEquals( 20, node.get( "item" ).get( 1 ).get( "value" ).asInt() );
        assertEquals( "", node.get( "item" ).get( 1 ).get( "label" ).asText() );

    }

}
