package com.github.geckoboard.api.json.bulletgraph;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Data to fill a bullet graph
 * 
 * @author Paul van Assen
 */
public class BulletGraphItem {
    private String            label;

    @SerializedName( "sublabel" )
    private String            subLabel;

    private final Axis        axis    = new Axis();

    @SerializedName( "range" )
    private final List<Range> ranges  = new LinkedList<Range>();

    private final Measure     measure = new Measure();

    private Point             comparative;

    public void setLabel( String label ) {
        this.label = label;
    }

    public void setSubLabel( String subLabel ) {
        this.subLabel = subLabel;
    }

    public List<String> getAxisPoints() {
        return axis.getPoints();
    }

    public List<Range> getRanges() {
        return ranges;
    }

    public void setCurrent( Position current ) {
        this.measure.setCurrent( current );
    }

    public void setProjected( Position projected ) {
        this.measure.setProjected( projected );
    }

    public void setComparative( String comparative ) {
        this.comparative = new Point( comparative );
    }

    public Point getComparative() {
        return comparative;
    }

    public String getLabel() {
        return label;
    }

    public Axis getAxis() {
        return axis;
    }

    public Measure getMeasure() {
        return measure;
    }

    public String getSubLabel() {
        return subLabel;
    }

}