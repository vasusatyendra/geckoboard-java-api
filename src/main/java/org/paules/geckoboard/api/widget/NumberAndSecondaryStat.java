package org.paules.geckoboard.api.widget;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;
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
    protected void getData( ObjectNode node ) {
    }

    public void setPrimary( String primary, String prefix ) {
        this.primary = primary;
        this.prefix = prefix;
    }

    public void setSecondary( String secondary ) {
        this.secondary = secondary;
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
        item.put( "text", "" );
        items.add( item );
        if ( prefix != null ) {
            item.put( "prefix", prefix );
        }
        if ( secondary != null ) {
            item = data.objectNode();
            item.put( "value", secondary );
            item.put( "text", "" );
            items.add( item );
        }
        return data.toString();
    }
}
