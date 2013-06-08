package org.paules.geckoboard.api.json.bulletgraph;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BulletGraphItem {
    @SuppressWarnings( "unused" )
    private String            label;

    @SerializedName( "sublabel" )
    @SuppressWarnings( "unused" )
    private String            subLabel;

    private final Axis        axis    = new Axis();

    @SerializedName( "range" )
    private final List<Range> ranges  = new LinkedList<Range>();

    private final Measure     measure = new Measure();

    @SuppressWarnings( "unused" )
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

}