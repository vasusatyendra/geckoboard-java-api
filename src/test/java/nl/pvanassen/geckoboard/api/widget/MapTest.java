package nl.pvanassen.geckoboard.api.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.awt.Color;
import java.io.IOException;

import nl.pvanassen.geckoboard.api.JsonTestHelper;
import nl.pvanassen.geckoboard.api.widget.MapWidget;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Test;

public class MapTest {
    @Test
    public void testJson() throws JsonProcessingException, IOException {
        MapWidget widget = new MapWidget( "1234" );
        widget.addCityPoint( "test1" );
        widget.addCityPoint( "test2", "CA" ).setColor( Color.RED );
        widget.addCityPoint( "test3", "BE", "NL" ).setSize( 1 );
        widget.addHostPoint( "localhost" );
        widget.addIpPoint( "192.168.0.1" );
        widget.addLatLonPoint( "51.526263", "-0.092429" );

        JsonNode data = JsonTestHelper.getJsonFromWidget( widget );

        assertNotNull( data.get( "data" ) );
        JsonNode node = data.get( "data" );
        assertNull( node.get( "widgetKey" ) );

        assertNotNull( node.get( "points" ) );
        JsonNode points = node.get( "points" );
        assertEquals( 6, points.get( "point" ).size() );
        JsonNode point = points.get( "point" );
        assertNotNull( point.get( 0 ).get( "city" ) );
        assertEquals( "test1", point.get( 0 ).get( "city" ).get( "city_name" ).asText() );
        assertNull( point.get( 0 ).get( "city" ).get( "region_name" ) );
        assertNull( point.get( 0 ).get( "city" ).get( "country_name" ) );

    }

}
