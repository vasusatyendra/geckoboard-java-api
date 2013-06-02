package org.paules.geckoboard.api.widget;

import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;
import org.paules.geckoboard.api.json.GraphType;

/**
 * @author Paul van Assen
 *         Element for submiting data to the funnel graph
 *         http://www.geckoboard.com/developers/custom-widgets/widget-types/funnel-graph/
 */
public class FunnelGraph extends Push {
    private final List<Data> data = new LinkedList<Data>();

    private final GraphType  type;

    private final boolean    showPercentage;

    public FunnelGraph( String widgetKey, boolean showPercentage ) {
        this( widgetKey, GraphType.STANDARD, showPercentage );
    }

    public FunnelGraph( String widgetKey, GraphType type, boolean showPercentage ) {
        super( widgetKey );
        this.type = type;
        this.showPercentage = showPercentage;
    }

    public void addData( String label, String value ) {
        data.add( new Data( label, value ) );
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
        addData( data, this.data );
    }
}
