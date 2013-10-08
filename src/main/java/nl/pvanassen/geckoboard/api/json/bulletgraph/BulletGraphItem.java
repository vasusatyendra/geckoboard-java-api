package nl.pvanassen.geckoboard.api.json.bulletgraph;

import java.util.LinkedList;
import java.util.List;

import nl.pvanassen.geckoboard.api.error.ValidationException;

import com.google.gson.annotations.SerializedName;

/**
 * Data to fill a bullet graph
 * 
 * @author Paul van Assen
 */
public class BulletGraphItem {
    private String            label;

    @SerializedName( "sublabel" )
    @SuppressWarnings( "unused" )
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

    public void validate() throws ValidationException {
        if ( label == null ) {
            throw new ValidationException( "item.label", "Label cannot be empty" );
        }
        if ( axis.getPoints().size() == 0 ) {
            throw new ValidationException( "item.point", "Points must be set" );
        }
        if ( ranges.size() == 0 ) {
            throw new ValidationException( "item.ranges", "Ranges must be set" );
        }
        if (comparative == null) {
            throw new ValidationException( "item.comparative", "Comparative must be set" );
        }
        measure.validate();
        comparative.validate();
    }
}