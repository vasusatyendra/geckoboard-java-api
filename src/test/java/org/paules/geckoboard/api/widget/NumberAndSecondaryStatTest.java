package org.paules.geckoboard.api.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;
import org.paules.geckoboard.api.json.common.GraphType;
import org.paules.geckoboard.helper.JsonTestHelper;

public class NumberAndSecondaryStatTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        NumberAndSecondaryStat widget = new NumberAndSecondaryStat( "1234", true, GraphType.REVERSE );
        widget.setPrimary( "10", "$" );
        widget.setSecondary( "20" );

        JsonNode data = JsonTestHelper.getJsonFromWidget( widget );

        Assert.assertNotNull( data.get( "data" ) );
        JsonNode node = data.get( "data" );
        assertTrue( node.get( "absolute" ).asBoolean() );
        assertEquals( "reverse", node.get( "type" ).asText() );
        assertEquals( "10", node.get( "item" ).get( 0 ).get( "value" ).asText() );
        assertEquals( "", node.get( "item" ).get( 0 ).get( "text" ).asText() );
        assertEquals( "$", node.get( "item" ).get( 0 ).get( "prefix" ).asText() );
        assertEquals( "20", node.get( "item" ).get( 1 ).get( "value" ).asText() );
        assertEquals( "", node.get( "item" ).get( 1 ).get( "text" ).asText() );

    }

}
