package org.paules.geckoboard.api.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class LineChartTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        LineChart lineChart = new LineChart( "123" );
        lineChart.addDataPoint( "1.2" );
        lineChart.addDataPoint( "2.0" );
        lineChart.addDataPoint( "4" );
        lineChart.addDataPoint( "0.4" );
        lineChart.setColor( Color.RED );
        lineChart.setXAxisLabels( Arrays.asList( new String[] { "Jan", "Feb", "Mar", "Apr" } ) );
        lineChart.setYAxisLabels( Arrays.asList( new String[] { "1", "2", "3", "4", "5" } ) );

        ObjectMapper om = new ObjectMapper();
        JsonNode node = om.readTree( lineChart.toJson() );
        assertTrue( node.get( "item" ).isArray() );
        assertEquals( 4, node.get( "item" ).size() );
        assertEquals( "1.2", node.get( "item" ).get( 0 ).asText() );
        assertEquals( "2.0", node.get( "item" ).get( 1 ).asText() );
        assertEquals( "4", node.get( "item" ).get( 2 ).asText() );
        assertEquals( "0.4", node.get( "item" ).get( 3 ).asText() );

        assertTrue( node.get( "settings" ).get( "axisx" ).isArray() );
        assertEquals( 4, node.get( "settings" ).get( "axisx" ).size() );
        assertEquals( "Jan", node.get( "settings" ).get( "axisx" ).get( 0 ).asText() );
        assertEquals( "Feb", node.get( "settings" ).get( "axisx" ).get( 1 ).asText() );
        assertEquals( "Mar", node.get( "settings" ).get( "axisx" ).get( 2 ).asText() );
        assertEquals( "Apr", node.get( "settings" ).get( "axisx" ).get( 3 ).asText() );

        assertTrue( node.get( "settings" ).get( "axisy" ).isArray() );
        assertEquals( 5, node.get( "settings" ).get( "axisy" ).size() );
        assertEquals( "1", node.get( "settings" ).get( "axisy" ).get( 0 ).asText() );
        assertEquals( "2", node.get( "settings" ).get( "axisy" ).get( 1 ).asText() );
        assertEquals( "3", node.get( "settings" ).get( "axisy" ).get( 2 ).asText() );
        assertEquals( "4", node.get( "settings" ).get( "axisy" ).get( 3 ).asText() );
        assertEquals( "5", node.get( "settings" ).get( "axisy" ).get( 4 ).asText() );

        assertEquals( "FF0000FF", node.get( "settings" ).get( "colour" ).asText() );
    }

}
