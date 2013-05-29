package org.paules.geckoboard.api.widget;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;

public class PieChart extends Push {
    private final List<Data> items = new LinkedList<Data>();

    public PieChart( String widgetKey ) {
        super( widgetKey );
    }

    public void addItem( String label, String value, Color color ) {
        items.add( new Data( label, value, color ) );
    }
    
    @Override
    public String toJson() {
        ObjectNode node = factory.objectNode();
        ArrayNode items = node.arrayNode();
        for ( Data dataEntry : this.items ) {
            items.add( dataEntry.toJson() );
        }
        node.put("item", items);
        return node.toString();
    }

    @Override
    protected void getData( ObjectNode node ) {
        addData( node, items );
    }
}
