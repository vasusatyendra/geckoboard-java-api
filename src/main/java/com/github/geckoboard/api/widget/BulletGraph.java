package com.github.geckoboard.api.widget;

import java.util.List;

import com.github.geckoboard.api.Push;
import com.github.geckoboard.api.error.ValidationException;
import com.github.geckoboard.api.json.bulletgraph.BulletGraphItem;
import com.github.geckoboard.api.json.bulletgraph.Position;
import com.github.geckoboard.api.json.bulletgraph.RAGColor;
import com.github.geckoboard.api.json.bulletgraph.Range;

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

    /**
     * Adds a new range to the bullet graph. A range is a colored band of either red, amber or green
     * @param start
     * @param end
     * @param color
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

    public String getOrientation() {
        return orientation;
    }

    @Override
    protected void validate() throws ValidationException {
    }
}
