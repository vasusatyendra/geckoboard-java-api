package org.paules.geckoboard.api.widget;

import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;
import org.paules.geckoboard.api.error.ValidationException;
import org.paules.geckoboard.api.json.GeckOData;
import org.paules.geckoboard.api.json.GraphType;

public class GeckOMeter extends Push {
    private final GraphType type;

    private String          current;

    private GeckOData       min;

    private GeckOData       max;

    public GeckOMeter( String widgetKey, GraphType type ) {
        super( widgetKey );
        this.type = type;
    }
    
    @Override
    protected void validate() throws ValidationException {
    }

    @Override
    protected void getData( ObjectNode node ) {
        if ( type == GraphType.REVERSE ) {
            node.put( "type", "reverse" );
        }
        else {
            node.put( "type", "standard" );
        }
        node.put( "item", current );
        node.put( "min", min.toJson() );
        node.put( "max", max.toJson() );
    }

    public void setCurrent( String current ) {
        this.current = current;
    }

    public void setMax( String label, String value ) {
        max = new GeckOData( label, value );
    }

    public void setMin( String label, String value ) {
        min = new GeckOData( label, value );
    }
}
