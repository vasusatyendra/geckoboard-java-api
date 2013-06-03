package org.paules.geckoboard.api.widget;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;
import org.paules.geckoboard.api.error.ValidationException;
import org.paules.geckoboard.api.json.PieChartData;

public class PieChart extends Push {
    private final List<PieChartData> items = new LinkedList<PieChartData>();

    public PieChart( String widgetKey ) {
        super( widgetKey );
    }

    public void addItem( String label, String value, Color color ) {
        items.add( new PieChartData( label, value, color ) );
    }
    
    @Override
    protected void validate() throws ValidationException {
        if (items.size() == 0) {
            throw new ValidationException( "item", "At least one item expected" );
        }
    }

    @Override
    protected void getData( ObjectNode node ) {
        ArrayNode items = node.arrayNode();
        for ( PieChartData dataEntry : this.items ) {
            items.add( dataEntry.toJson() );
        }
        node.put( "item", items );
    }
}
