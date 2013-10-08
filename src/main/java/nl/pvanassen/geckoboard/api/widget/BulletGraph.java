package nl.pvanassen.geckoboard.api.widget;

import java.util.List;

import nl.pvanassen.geckoboard.api.Push;
import nl.pvanassen.geckoboard.api.error.ValidationException;
import nl.pvanassen.geckoboard.api.json.bulletgraph.BulletGraphItem;
import nl.pvanassen.geckoboard.api.json.bulletgraph.Position;
import nl.pvanassen.geckoboard.api.json.bulletgraph.RAGColor;
import nl.pvanassen.geckoboard.api.json.bulletgraph.Range;

/**
 * Element for submitting data to the bullet graph
 * http://www.geckoboard.com/developers/custom-widgets/widget-types/bullet-graph/
 * 
 * @author Paul van Assen
 */
public class BulletGraph extends Push {
    @SuppressWarnings( "unused" )
    private final String    orientation;

    private BulletGraphItem item = new BulletGraphItem();

    public BulletGraph( String widgetKey, boolean vertical ) {
        super( widgetKey );
        if ( vertical ) {
            orientation = "vertical";
        }
        else {
            orientation = "horizontal";
        }
    }

    /**
     * Adds a new range to the bullet graph. A range is a colored band of either red, amber or green
     * 
     * @param start Start of the range
     * @param end End of the range
     * @param color Color, either red, amber or green
     */
    public void addRange( int start, int end, RAGColor color ) {
        item.getRanges().add( new Range( start, end, color ) );
    }

    public void setAxisPoints( List<String> points ) {
        item.getAxisPoints().addAll( points );
    }

    public void setComparative( String position ) {
        item.setComparative( position );
    }

    public void setCurrent( int start, int end ) {
        item.setCurrent( new Position( start, end ) );
    }

    public void setLabel( String label ) {
        item.setLabel( label );
    }

    public void setProjected( int start, int end ) {
        item.setProjected( new Position( start, end ) );
    }

    public void setSubLabel( String subLabel ) {
        item.setSubLabel( subLabel );
    }

    @Override
    protected void validate() throws ValidationException {
        item.validate();
    }
}
