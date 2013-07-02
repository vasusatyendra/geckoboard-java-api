package com.github.geckoboard.api.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

import com.github.geckoboard.api.error.ValidationException;
import com.github.geckoboard.helper.JsonTestHelper;

public class LineChartTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        LineChart widget = new LineChart( "1234" );
        widget.addDataPoint( "1.2" );
        widget.addDataPoint( "2.0" );
        widget.addDataPoint( "4" );
        widget.addDataPoint( "0.4" );
        widget.setColor( Color.RED );
        widget.setAxisXLabels( Arrays.asList( new String[] { "Jan", "Feb", "Mar", "Apr" } ) );
        widget.setAxisYLabels( Arrays.asList( new String[] { "1", "2", "3", "4", "5" } ) );
        widget.validate();
        
        JsonNode data = JsonTestHelper.getJsonFromWidget( widget );

        Assert.assertNotNull( data.get( "data" ) );
        JsonNode node = data.get( "data" );
        assertNull(node.get( "widgetKey" ));

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
    
    @Test(expected=ValidationException.class)
    public void testValidateEmptyItems() {
        LineChart widget = new LineChart( "1234" );
        widget.setColor( Color.RED );
        widget.setAxisXLabels( Arrays.asList( new String[] { "Jan", "Feb", "Mar", "Apr" } ) );
        widget.setAxisYLabels( Arrays.asList( new String[] { "1", "2", "3", "4", "5" } ) );
        widget.validate();
    }

    @Test(expected=ValidationException.class)
    public void testValidateEmptySettingsAxisX() {
        LineChart widget = new LineChart( "1234" );
        widget.addDataPoint( "1.2" );
        widget.addDataPoint( "2.0" );
        widget.addDataPoint( "4" );
        widget.addDataPoint( "0.4" );
        widget.setColor( Color.RED );
        widget.setAxisYLabels( Arrays.asList( new String[] { "1", "2", "3", "4", "5" } ) );
        widget.validate();
    }

    @Test(expected=ValidationException.class)
    public void testValidateEmptySettingsAxisY() {
        LineChart widget = new LineChart( "1234" );
        widget.addDataPoint( "1.2" );
        widget.addDataPoint( "2.0" );
        widget.addDataPoint( "4" );
        widget.addDataPoint( "0.4" );
        widget.setColor( Color.RED );
        widget.setAxisXLabels( Arrays.asList( new String[] { "1", "2", "3", "4", "5" } ) );
        widget.validate();
    }
    
    @Test(expected=ValidationException.class)
    public void testValidateNewObject() {
        new LineChart( "1234" ).validate();
    }
}
