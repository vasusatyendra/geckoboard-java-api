package org.paules.geckoboard.api.widget;

import static org.junit.Assert.*;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.paules.geckoboard.api.type.GraphType;

public class GeckOMeterTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        GeckOMeter geckOMeter = new GeckOMeter( "1234", GraphType.STANDARD );
        geckOMeter.setCurrent( "10" );
        geckOMeter.setMin( "No one", "0" );
        geckOMeter.setMax( "Panic!", "1000" );

        ObjectMapper om = new ObjectMapper();
        JsonNode node = om.readTree( geckOMeter.toJson() );
        assertEquals( "10", node.get( "item" ).asText() );
        assertEquals( "0", node.get( "min" ).get( "value" ).asText() );
        assertEquals( "No one", node.get( "min" ).get( "label" ).asText() );
        assertEquals( "1000", node.get( "max" ).get( "value" ).asText() );
        assertEquals( "Panic!", node.get( "max" ).get( "label" ).asText() );
    }

}
