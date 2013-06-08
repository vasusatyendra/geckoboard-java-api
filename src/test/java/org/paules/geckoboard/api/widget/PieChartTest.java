package org.paules.geckoboard.api.widget;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;
import org.paules.geckoboard.helper.JsonTestHelper;

public class PieChartTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        PieChart widget = new PieChart( "1234" );
        widget.addItem( "Test1", "100", Color.RED );
        widget.addItem( "Test2", "200", Color.GREEN );
        widget.addItem( "Test3", "300", Color.BLUE );
        widget.addItem( "Test4", "400", Color.WHITE );

        JsonNode data = JsonTestHelper.getJsonFromWidget( widget );

        Assert.assertNotNull( data.get( "data" ) );
        JsonNode node = data.get( "data" );
        assertEquals( 4, node.get( "item" ).size() );
        assertEquals( "Test1", node.get( "item" ).get( 0 ).get( "label" ).asText() );
        assertEquals( "100", node.get( "item" ).get( 0 ).get( "value" ).asText() );
        assertEquals( "FF0000FF", node.get( "item" ).get( 0 ).get( "color" ).asText() );

        assertEquals( "Test2", node.get( "item" ).get( 1 ).get( "label" ).asText() );
        assertEquals( "200", node.get( "item" ).get( 1 ).get( "value" ).asText() );
        assertEquals( "00FF00FF", node.get( "item" ).get( 1 ).get( "color" ).asText() );

        assertEquals( "Test3", node.get( "item" ).get( 2 ).get( "label" ).asText() );
        assertEquals( "300", node.get( "item" ).get( 2 ).get( "value" ).asText() );
        assertEquals( "0000FFFF", node.get( "item" ).get( 2 ).get( "color" ).asText() );

        assertEquals( "Test4", node.get( "item" ).get( 3 ).get( "label" ).asText() );
        assertEquals( "400", node.get( "item" ).get( 3 ).get( "value" ).asText() );
        assertEquals( "FFFFFFFF", node.get( "item" ).get( 3 ).get( "color" ).asText() );
    }

}
