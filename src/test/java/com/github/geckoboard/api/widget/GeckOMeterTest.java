package com.github.geckoboard.api.widget;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

import com.github.geckoboard.api.json.common.GraphType;
import com.github.geckoboard.api.widget.GeckOMeter;
import com.github.geckoboard.helper.JsonTestHelper;

public class GeckOMeterTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        GeckOMeter widget = new GeckOMeter( "1234", GraphType.STANDARD );
        widget.setCurrent( "10" );
        widget.setMin( "No one", "0" );
        widget.setMax( "Panic!", "1000" );

        JsonNode data = JsonTestHelper.getJsonFromWidget( widget );

        Assert.assertNotNull( data.get( "data" ) );
        JsonNode node = data.get( "data" );
        assertEquals( "10", node.get( "item" ).asText() );
        assertEquals( "0", node.get( "min" ).get( "value" ).asText() );
        assertEquals( "No one", node.get( "min" ).get( "text" ).asText() );
        assertEquals( "1000", node.get( "max" ).get( "value" ).asText() );
        assertEquals( "Panic!", node.get( "max" ).get( "text" ).asText() );
    }

}
