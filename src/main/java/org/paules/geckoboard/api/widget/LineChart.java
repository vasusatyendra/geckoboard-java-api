package org.paules.geckoboard.api.widget;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;
import org.paules.geckoboard.api.error.ValidationException;
import org.paules.geckoboard.api.json.ColorUtil;

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
    protected void validate() throws ValidationException {
        if (items.size() == 0) {
            throw new ValidationException( "item", "Must be filled" );
        }
        if (xAxis.size() == 0) {
            throw new ValidationException( "axisx", "Must be filled" );
        }
        if (yAxis.size() == 0) {
            throw new ValidationException( "axisy", "Must be filled" );
        }
    }


    @Override
    protected void getData( ObjectNode data ) {
        ArrayNode itemNode = data.arrayNode();
        for ( String item : items ) {
            itemNode.add( item );
        }
        data.put( "item", itemNode );
        ObjectNode settings = data.objectNode();
        ArrayNode xAxis = settings.arrayNode();
        settings.put( "axisx", xAxis );
        for ( String x : this.xAxis ) {
            xAxis.add( x );
        }
        ArrayNode yAxis = settings.arrayNode();
        settings.put( "axisy", yAxis );
        for ( String y : this.yAxis ) {
            yAxis.add( y );
        }
        if ( color != null ) {
            settings.put( "colour", ColorUtil.toHexString( color ) );
        }
        data.put( "settings", settings );
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
