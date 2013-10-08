package nl.pvanassen.geckoboard.api.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import nl.pvanassen.geckoboard.api.json.common.GraphType;
import nl.pvanassen.geckoboard.api.widget.RAGColumnsAndNumbers;
import nl.pvanassen.geckoboard.helper.JsonTestHelper;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

public class RAGColumnsAndNumbersTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        RAGColumnsAndNumbers widget = new RAGColumnsAndNumbers( "1234", GraphType.STANDARD );
        widget.setRed( "Test-red", 123 );
        widget.setAmber( "Test-amber", 1234 );
        widget.setGreen( "Test-green", 12345, "$" );

        JsonNode data = JsonTestHelper.getJsonFromWidget( widget );

        Assert.assertNotNull( data.get( "data" ) );
        JsonNode node = data.get( "data" );
        assertNull(node.get( "widgetKey" ));

        assertEquals( "standard", node.get( "type" ).asText() );

        assertEquals( 3, node.get( "item" ).size() );

        assertEquals( "Test-green", node.get( "item" ).get( 0 ).get( "text" ).asText() );
        assertEquals( 12345, node.get( "item" ).get( 0 ).get( "value" ).asInt() );
        assertEquals( "$", node.get( "item" ).get( 0 ).get( "prefix" ).asText() );

        assertEquals( "Test-amber", node.get( "item" ).get( 1 ).get( "text" ).asText() );
        assertEquals( 1234, node.get( "item" ).get( 1 ).get( "value" ).asInt() );
        assertNull( node.get( "item" ).get( 1 ).get( "prefix" ) );

        assertEquals( "Test-red", node.get( "item" ).get( 2 ).get( "text" ).asText() );
        assertEquals( 123, node.get( "item" ).get( 2 ).get( "value" ).asInt() );
        assertNull( node.get( "item" ).get( 2 ).get( "prefix" ) );
    }

}
