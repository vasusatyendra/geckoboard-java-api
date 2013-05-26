package org.paules.geckoboard.api.widget;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;
import org.paules.geckoboard.api.type.GraphType;

public class GeckOMeter extends Push {
    private final  GraphType type;

    private String           current;

    private Data          min;

    private Data          max;

    public GeckOMeter( String widgetKey, GraphType type) {
        super( widgetKey );
        this.type = type;
    }
    
    @Override
    public String toJson() {
        ObjectNode data = new ObjectMapper().getNodeFactory().objectNode();
        getData( data );
        return data.toString();
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
        this.max = new Data(label, value);
    }

    public void setMin( String label, String value ) {
        this.min =  new Data(label, value);;
    }
}
