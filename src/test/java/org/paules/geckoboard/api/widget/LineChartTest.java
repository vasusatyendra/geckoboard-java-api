package org.paules.geckoboard.api.widget;

import java.awt.Color;
import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import static org.junit.Assert.*;

public class LineChartTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        LineChart lineChart = new LineChart("123");
        lineChart.addDataPoint( "1.2" );
        lineChart.addDataPoint( "2.0" );
        lineChart.addDataPoint( "4" );
        lineChart.addDataPoint( "0.4" );
        lineChart.setColor( Color.RED );
        lineChart.setXAxisLabels( new String[]{"Jan", "Feb", "Mar", "Apr"} );
        lineChart.setYAxisLabels( new String[]{"1","2","3","4","5"} );
        
        ObjectMapper om = new ObjectMapper();
        JsonNode node = om.readTree( lineChart.toJson() );
        assertTrue(node.get( "item" ).isArray());
        assertEquals(4,node.get("item").size());
        assertEquals("1.2", node.get("item").get( 0 ).asText());
        assertEquals("2.0", node.get("item").get( 1 ).asText());
        assertEquals("4", node.get("item").get( 2 ).asText());
        assertEquals("0.4", node.get("item").get( 3 ).asText());
        
        assertTrue(node.get( "settings" ).get("xaxis").isArray());
        assertEquals(4,node.get("settings").get("xaxis").size());
        assertEquals("Jan", node.get("settings").get("xaxis").get( 0 ).asText());
        assertEquals("Feb", node.get("settings").get("xaxis").get( 1 ).asText());
        assertEquals("Mar", node.get("settings").get("xaxis").get( 2 ).asText());
        assertEquals("Apr", node.get("settings").get("xaxis").get( 3 ).asText());
        
        assertTrue(node.get( "settings" ).get("yaxis").isArray());
        assertEquals(5,node.get("settings").get("yaxis").size());
        assertEquals("1", node.get("settings").get("yaxis").get( 0 ).asText());
        assertEquals("2", node.get("settings").get("yaxis").get( 1 ).asText());
        assertEquals("3", node.get("settings").get("yaxis").get( 2 ).asText());
        assertEquals("4", node.get("settings").get("yaxis").get( 3 ).asText());
        assertEquals("5", node.get("settings").get("yaxis").get( 4 ).asText());
    }

}
