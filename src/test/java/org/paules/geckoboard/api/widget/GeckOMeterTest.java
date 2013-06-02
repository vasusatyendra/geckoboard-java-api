package org.paules.geckoboard.api.widget;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.paules.geckoboard.api.json.GraphType;

public class GeckOMeterTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        GeckOMeter widget = new GeckOMeter( "1234", GraphType.STANDARD );
        widget.setCurrent( "10" );
        widget.setMin( "No one", "0" );
        widget.setMax( "Panic!", "1000" );

        ObjectMapper om = new ObjectMapper();
        JsonNode data = om.readTree( widget.toJson() );
        Assert.assertNotNull( data.get( "data" ) );
        JsonNode node = data.get( "data" );
        assertEquals( "10", node.get( "item" ).asText() );
        assertEquals( "0", node.get( "min" ).get( "value" ).asText() );
        assertEquals( "No one", node.get( "min" ).get( "text" ).asText() );
        assertEquals( "1000", node.get( "max" ).get( "value" ).asText() );
        assertEquals( "Panic!", node.get( "max" ).get( "text" ).asText() );
    }

}
