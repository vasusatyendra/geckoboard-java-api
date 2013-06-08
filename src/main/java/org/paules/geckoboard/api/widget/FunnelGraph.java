package org.paules.geckoboard.api.widget;

import java.util.LinkedList;
import java.util.List;

import org.paules.geckoboard.api.Push;
import org.paules.geckoboard.api.error.ValidationException;
import org.paules.geckoboard.api.json.common.GraphType;
import org.paules.geckoboard.api.json.common.LabelValueItem;

import com.google.gson.annotations.SerializedName;

/**
 * @author Paul van Assen
 *         Element for submiting data to the funnel graph
 *         http://www.geckoboard.com/developers/custom-widgets/widget-types/funnel-graph/
 */
public class FunnelGraph extends Push {
    @SerializedName( "item" )
    private final List<LabelValueItem> items = new LinkedList<LabelValueItem>();

    @SuppressWarnings( "unused" )
    @SerializedName( "type" )
    private final GraphType             graphType;

    @SuppressWarnings( "unused" )
    private final String                percentage;

    public FunnelGraph( String widgetKey, boolean showPercentage ) {
        this( widgetKey, GraphType.STANDARD, showPercentage );
    }

    public FunnelGraph( String widgetKey, GraphType graphType, boolean showPercentage ) {
        super( widgetKey );
        this.graphType = graphType;
        if ( showPercentage ) {
            percentage = "show";
        }
        else {
            percentage = "hide";
        }
    }

    public void addData( String label, String value ) {
        items.add( new LabelValueItem( label, value ) );
    }

    @Override
    protected void validate() throws ValidationException {
        if ( items.size() == 0 ) {
            throw new ValidationException( "item", "Items cannot be empty" );
        }
    }
}
