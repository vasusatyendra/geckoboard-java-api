package org.paules.geckoboard.api.json.linechart;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Settings class for linechart
 * 
 * @author Paul van Assen
 */
public class LineChartSettings {
    private final List<String> axisx = new LinkedList<String>();

    private final List<String> axisy = new LinkedList<String>();

    @SuppressWarnings( "unused" )
    @SerializedName( "colour" )
    private Color              color;

    public void setColor( Color color ) {
        this.color = color;
    }

    public List<String> getAxisx() {
        return axisx;
    }

    public List<String> getAxisy() {
        return axisy;
    }

}
