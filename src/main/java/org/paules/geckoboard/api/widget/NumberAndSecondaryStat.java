package org.paules.geckoboard.api.widget;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;
import org.paules.geckoboard.api.error.ValidationException;
import org.paules.geckoboard.api.json.GraphType;

public class NumberAndSecondaryStat extends Push {
    private String          primary;

    private String          secondary;

    private final boolean   absolute;

    private final GraphType graphType;

    private String          prefix;

    public NumberAndSecondaryStat( String widgetKey, boolean absolute, GraphType graphType ) {
        super( widgetKey );
        this.absolute = absolute;
        this.graphType = graphType;
    }
    
    @Override
    protected void validate() throws ValidationException {
        if (primary == null || primary.isEmpty()) {
            throw new ValidationException( "primary", "cannot be empty" );
        }
    }

    @Override
    protected void getData( ObjectNode node ) {
        node.put( "absolute", absolute );
        node.put( "type", graphType.toString().toLowerCase() );
        ArrayNode items = node.arrayNode();
        node.put( "item", items );
        ObjectNode item = node.objectNode();
        item.put( "value", primary );
        item.put( "text", "" );
        items.add( item );
        if ( prefix != null ) {
            item.put( "prefix", prefix );
        }
        if ( secondary != null ) {
            item = node.objectNode();
            item.put( "value", secondary );
            item.put( "text", "" );
            items.add( item );
        }
    }

    public void setPrimary( String primary, String prefix ) {
        this.primary = primary;
        this.prefix = prefix;
    }

    public void setSecondary( String secondary ) {
        this.secondary = secondary;
    }

}
