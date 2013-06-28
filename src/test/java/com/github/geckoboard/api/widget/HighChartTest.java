package com.github.geckoboard.api.widget;

import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

import com.github.geckoboard.helper.JsonTestHelper;
import com.github.highchart.api.ChartOptions;
import com.github.highchart.api.Point;
import com.github.highchart.api.Series;

public class HighChartTest {
    private static final String pieJson = "{\"chart\":{\"width\":800,\"height\":600,\"marginLeft\":70,\"marginTop\":80},\"plotOptions\":{\"area\":{\"borderWidth\":0},\"areaspline\":{\"borderWidth\":0},\"line\":{\"borderWidth\":0},\"pie\":{\"dataLabels\":{\"color\":\"#000000\",\"enabled\":true,\"formatter\":\"function() {return \u0027\u003cb\u003e\u0027+ this.point.name +\u0027\u003c/b\u003e: \u0027+ this.y +\u0027 %\u0027;}\",\"align\":\"center\",\"rotation\":0.0},\"allowPointSelect\":true,\"borderWidth\":0},\"series\":{\"borderWidth\":0},\"spline\":{\"borderWidth\":0},\"column\":{\"borderWidth\":0},\"bar\":{\"borderWidth\":0}},\"series\":[{\"data\":[{\"y\":45.0,\"name\":\"Firefox\"},{\"y\":26.8,\"name\":\"IE\"},{\"y\":12.8,\"selected\":true,\"sliced\":true,\"name\":\"Chrome\"},{\"y\":8.5,\"name\":\"Safari\"},{\"y\":6.2,\"name\":\"Opera\"},{\"y\":0.7,\"name\":\"Others\"}],\"name\":\"Browser share\",\"type\":\"pie\"}],\"title\":{\"text\":\"Browser market shares at a specific website, 2010\"}}";

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        HighChart widget = new HighChart( "1234" );
        ChartOptions chartOptions = widget.getChartOptions();

        chartOptions.getChart().setWidth( 800 ).setHeight( 600 ).setMarginLeft( 70 ).setMarginTop( 80 );
        // title
        chartOptions.getTitle().setText( "Browser market shares at a specific website, 2010" );

        // plotOptions
        chartOptions.getPlotOptions().getPie().setAllowPointSelect( true ).getDataLabels().setEnabled( true ).setColor( "#000000" ).setFormatter( "function() {return '<b>'+ this.point.name +'</b>: '+ this.y +' %';}" );

        Series newSeries = new Series().setName( "Browser share" ).setType( "pie" );
        chartOptions.getSeries().pushElement( newSeries );
        newSeries.getData().pushElement( new Point().setName( "Firefox" ).setY( 45 ) ).pushElement( new Point().setName( "IE" ).setY( 26.8 ) ).pushElement( new Point().setName( "Chrome" ).setY( 12.8 ).setSliced( true ).setSelected( true ) ).pushElement( new Point().setName( "Safari" ).setY( 8.5 ) ).pushElement( new Point().setName( "Opera" ).setY( 6.2 ) ).pushElement( new Point().setName( "Others" ).setY( 0.7 ) );

        JsonNode data = JsonTestHelper.getJsonFromWidget( widget );

        Assert.assertNotNull( data.get( "data" ) );
        JsonNode node = data.get( "data" );
        assertNull(node.get( "widgetKey" ));

        Assert.assertNotNull( node.get( "highchart" ) );
        JsonNode highchart = node.get("highchart");
        Assert.assertEquals( "Expected pie json", pieJson, highchart.toString() );
    }

}
