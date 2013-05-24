package org.paules.geckoboard.api.widget;

import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;

public class GeckOMeter extends Push {
    private final boolean reverse;

    private int           current;

    private Data          min;

    private Data          max;

    public GeckOMeter( String widgetKey, boolean reverse ) {
        super( widgetKey );
        this.reverse = reverse;
    }

    @Override
    protected void getData( ObjectNode node ) {
        ObjectNode dataNode = node.objectNode();
        node.put( "item", dataNode );
        if ( reverse ) {
            node.put( "item", "reverse" );
        }
        dataNode.put( "item", current );
        dataNode.put( "min", min.toJson() );
        dataNode.put( "max", max.toJson() );
    }

    public void setCurrent( int current ) {
        this.current = current;
    }

    public void setMax( Data max ) {
        this.max = max;
    }

    public void setMin( Data min ) {
        this.min = min;
    }
}
