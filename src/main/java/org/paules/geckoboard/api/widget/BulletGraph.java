package org.paules.geckoboard.api.widget;

import java.util.List;

import org.paules.geckoboard.api.Push;
import org.paules.geckoboard.api.error.ValidationException;
import org.paules.geckoboard.api.json.bulletgraph.BulletGraphItem;
import org.paules.geckoboard.api.json.bulletgraph.Position;
import org.paules.geckoboard.api.json.bulletgraph.RAGColor;
import org.paules.geckoboard.api.json.bulletgraph.Range;

/**
 * Element for submitting data to the bullet graph
 * http://www.geckoboard.com/developers/custom-widgets/widget-types/bullet-graph/
 * 
 * @author Paul van Assen
 */
public class BulletGraph extends Push {
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

    public String getOrientation() {
        return orientation;
    }

    @Override
    protected void validate() throws ValidationException {
    }
}
