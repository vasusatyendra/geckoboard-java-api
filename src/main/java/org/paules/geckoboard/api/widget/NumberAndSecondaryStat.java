package org.paules.geckoboard.api.widget;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;
import org.paules.geckoboard.api.type.GraphType;

public class NumberAndSecondaryStat extends Push {
    private int             primary;

    private Integer         secondary;

    private final boolean   absolute;

    private final GraphType graphType;

    private final String    prefix;

    public NumberAndSecondaryStat( String widgetKey, boolean absolute, GraphType graphType, String prefix ) {
        super( widgetKey );
        this.absolute = absolute;
        this.graphType = graphType;
        this.prefix = prefix;
    }

    public NumberAndSecondaryStat( String widgetKey, boolean absolute, GraphType graphType ) {
        this( widgetKey, absolute, graphType, null );
    }

    @Override
    public String toJson() {
        ObjectNode data = factory.objectNode();
        data.put( "absolute", absolute );
        data.put( "type", graphType.toString().toLowerCase() );
        ArrayNode items = data.arrayNode();
        data.put( "item", items );
        ObjectNode item = data.objectNode();
        item.put( "value", primary );
        item.put( "label", "" );
        items.add( item );
        if ( prefix != null ) {
            item.put( "prefix", prefix );
        }
        if ( secondary != null ) {
            item = data.objectNode();
            item.put( "value", secondary );
            item.put( "label", "" );
            items.add( item );
        }
        return data.toString();
    }

    @Override
    protected void getData( ObjectNode node ) {
    }

    public void setPrimary( int primary ) {
        this.primary = primary;
    }

    public void setSecondary( Integer secondary ) {
        this.secondary = secondary;
    }
}
