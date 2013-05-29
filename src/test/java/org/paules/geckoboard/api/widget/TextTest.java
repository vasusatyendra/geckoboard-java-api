package org.paules.geckoboard.api.widget;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.paules.geckoboard.api.widget.Text.Type;

public class TextTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        Text text = new Text( "1234" );
        text.addText( "Test1" );
        text.addText( "Test2", Type.ALERT );
        text.addText( "Test3", Type.INFO );
        text.addText( "Test4", Type.NONE );

        ObjectMapper om = new ObjectMapper();
        JsonNode node = om.readTree( text.toJson() );

        assertEquals( 4, node.get( "item" ).size() );

        assertEquals( "Test1", node.get( "item" ).get( 0 ).get( "text" ).asText() );
        assertEquals( 0, node.get( "item" ).get( 0 ).get( "type" ).asInt() );

        assertEquals( "Test2", node.get( "item" ).get( 1 ).get( "text" ).asText() );
        assertEquals( 1, node.get( "item" ).get( 1 ).get( "type" ).asInt() );

        assertEquals( "Test3", node.get( "item" ).get( 2 ).get( "text" ).asText() );
        assertEquals( 2, node.get( "item" ).get( 2 ).get( "type" ).asInt() );

        assertEquals( "Test4", node.get( "item" ).get( 3 ).get( "text" ).asText() );
        assertEquals( 0, node.get( "item" ).get( 3 ).get( "type" ).asInt() );

    }

}
