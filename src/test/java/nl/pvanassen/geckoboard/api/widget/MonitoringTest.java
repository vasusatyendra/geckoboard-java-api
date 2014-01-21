package nl.pvanassen.geckoboard.api.widget;

import static org.junit.Assert.*;

import java.io.IOException;

import nl.pvanassen.geckoboard.api.JsonTestHelper;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

public class MonitoringTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        Monitoring widget = new Monitoring( "1234" );
        widget.setStatus( "Up" );
        widget.setResponseTime( "1 ms" );
        widget.setDownTime( "10 days" );
        JsonNode data = JsonTestHelper.getJsonFromWidget( widget );

        Assert.assertNotNull( data.get( "data" ) );
        JsonNode node = data.get( "data" );
        assertNull(node.get( "widgetKey" ));

        assertTrue( node.get( "item" ).isObject() );
        
        JsonNode monitorItem = node.get("item");
        assertEquals( "Up", monitorItem.get( "status" ).asText() );
        assertEquals( "1 ms", monitorItem.get( "responseTime" ).asText() );
        assertEquals( "10 days", monitorItem.get( "downTime" ).asText() );

    }

}
