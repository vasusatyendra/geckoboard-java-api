package org.paules.geckoboard.api.widget;

import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;
import org.paules.geckoboard.api.error.ValidationException;
import org.paules.geckoboard.api.json.FunnelGraphData;
import org.paules.geckoboard.api.json.GraphType;

/**
 * @author Paul van Assen
 *         Element for submiting data to the funnel graph
 *         http://www.geckoboard.com/developers/custom-widgets/widget-types/funnel-graph/
 */
public class FunnelGraph extends Push {
    private final List<FunnelGraphData> data = new LinkedList<FunnelGraphData>();

    private final GraphType             type;

    private final boolean               showPercentage;

    public FunnelGraph( String widgetKey, boolean showPercentage ) {
        this( widgetKey, GraphType.STANDARD, showPercentage );
    }

    public FunnelGraph( String widgetKey, GraphType type, boolean showPercentage ) {
        super( widgetKey );
        this.type = type;
        this.showPercentage = showPercentage;
    }

    public void addData( String label, String value ) {
        data.add( new FunnelGraphData( label, value ) );
    }

    @Override
    protected void validate() throws ValidationException {
        if ( data.size() == 0 ) {
            throw new ValidationException( "item", "Items cannot be empty" );
        }
    }

    @Override
    protected void getData( ObjectNode data ) {
        data.put( "type", type.toString().toLowerCase() );
        if ( showPercentage ) {
            data.put( "percentage", "show" );
        }
        else {
            data.put( "percentage", "hide" );
        }
        ArrayNode items = data.arrayNode();
        data.put( "item", items );
        for ( FunnelGraphData dataEntry : this.data ) {
            items.add( dataEntry.toJson() );
        }
    }
}
