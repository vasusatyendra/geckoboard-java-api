package org.paules.geckoboard.api.widget;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;

public class LineChart extends Push {
    private final List<String> items = new LinkedList<String>();

    private final List<String> xAxis = new LinkedList<String>();

    private final List<String> yAxis = new LinkedList<String>();

    private Color              color;

    public LineChart( String widgetKey ) {
        super( widgetKey );
    }

    public void addDataPoint( String dataPoint ) {
        items.add( dataPoint );
    }

    @Override
    public String toJson() {
        ObjectNode node = new ObjectMapper().getNodeFactory().objectNode();
        ArrayNode itemNode = node.arrayNode();
        for ( String item : items ) {
            itemNode.add( item );
        }
        node.put( "item", itemNode );
        ObjectNode settings = node.objectNode();
        ArrayNode xAxis = settings.arrayNode();
        settings.put( "xaxis", xAxis );
        for ( String x : this.xAxis ) {
            xAxis.add( x );
        }
        ArrayNode yAxis = settings.arrayNode();
        settings.put( "yaxis", yAxis );
        for ( String y : this.yAxis ) {
            yAxis.add( y );
        }
        if ( color != null ) {
            settings.put( "color", toHexString( color ) );
        }
        node.put( "settings", settings );
        return node.toString();
    }

    @Override
    protected void getData( ObjectNode node ) {

    }

    public void setColor( Color color ) {
        this.color = color;
    }

    public void setXAxisLabels( Collection<String> labels ) {
        xAxis.clear();
        xAxis.addAll( labels );
    }

    public void setXAxisLabels( String[] labels ) {
        setXAxisLabels( Arrays.asList( labels ) );
    }

    public void setYAxisLabels( Collection<String> labels ) {
        yAxis.clear();
        yAxis.addAll( labels );
    }

    public void setYAxisLabels( String[] labels ) {
        setYAxisLabels( Arrays.asList( labels ) );
    }
}
