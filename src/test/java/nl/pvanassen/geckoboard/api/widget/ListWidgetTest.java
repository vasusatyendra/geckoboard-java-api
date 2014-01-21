package nl.pvanassen.geckoboard.api.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.io.IOException;

import nl.pvanassen.geckoboard.api.JsonTestHelper;
import nl.pvanassen.geckoboard.api.json.list.Label;
import nl.pvanassen.geckoboard.api.json.list.ListItem;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

public class ListWidgetTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        ListWidget widget = new ListWidget( "1234" );

        ListItem item;
        item = widget.createItem("TestText1");
        item.setDescription( "Desc1" );
        item.setLabelColor( Color.RED );
        item.setLabelName( "LabelName1" );
        item.setTitleHighlight( false );

        item = widget.createItem("TestText2");
        item.setLabelColor( Color.YELLOW );
        item.setLabelName( "LabelName2" );

        item = widget.createItem("TestText3");
        item.setDescription( "Desc3" );
        item.setTitleHighlight( true );

        item = widget.createItem("TestText4");

        JsonNode data = JsonTestHelper.getJsonFromWidget( widget );

        Assert.assertNotNull( data.get( "data" ) );
        JsonNode node = data.get( "data" );
        assertNull(node.get( "widgetKey" ));

        assertTrue( node.get( "item" ).isArray() );
        assertEquals( 4, node.get( "item" ).size() );

        JsonNode item1 = node.get( "item" ).get( 0 );
        assertEquals( "TestText1", item1.get( "title" ).get("text").asText());
        assertEquals( "false", item1.get( "title" ).get("highlight").asText());

        JsonNode item2 = node.get( "item" ).get( 1 );
        assertEquals( "TestText2", item2.get( "title" ).get("text").asText());
        assertNull( item2.get( "title" ).get("highlight"));

        JsonNode item3 = node.get( "item" ).get( 2 );
        assertEquals( "TestText3", item3.get( "title" ).get("text").asText());
        assertEquals( "true", item3.get( "title" ).get("highlight").asText());

        JsonNode item4 = node.get( "item" ).get( 3 );
        assertEquals( "TestText4", item4.get( "title" ).get("text").asText());
        assertNull( item4.get( "title" ).get("highlight"));
        

    }

}
