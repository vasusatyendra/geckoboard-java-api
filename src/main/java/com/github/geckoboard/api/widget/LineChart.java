package com.github.geckoboard.api.widget;

import java.awt.Color;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.github.geckoboard.api.Push;
import com.github.geckoboard.api.error.ValidationException;
import com.github.geckoboard.api.json.linechart.LineChartSettings;
import com.google.gson.annotations.SerializedName;

/**
 * Line chart widget
 * 
 * @author Paul van Assen
 */
public class LineChart extends Push {
    @SerializedName( "item" )
    private final List<String>      items    = new LinkedList<String>();

    private final LineChartSettings settings = new LineChartSettings();

    public LineChart( String widgetKey ) {
        super( widgetKey );
    }

    public void addDataPoint( String dataPoint ) {
        items.add( dataPoint );
    }

    public void setAxisXLabels( Collection<String> labels ) {
        settings.getAxisx().clear();
        settings.getAxisx().addAll( labels );
    }

    public void setAxisYLabels( Collection<String> labels ) {
        settings.getAxisy().clear();
        settings.getAxisy().addAll( labels );
    }

    public void setColor( Color color ) {
        settings.setColor( color );
    }

    @Override
    protected void validate() throws ValidationException {
        if ( items.size() == 0 ) {
            throw new ValidationException( "item", "Must be filled" );
        }
        if ( settings.getAxisx().size() == 0 ) {
            throw new ValidationException( "axisx", "Must be filled" );
        }
        if ( settings.getAxisy().size() == 0 ) {
            throw new ValidationException( "axisy", "Must be filled" );
        }
    }
}
