package org.paules.geckoboard.api.widget;

import org.paules.geckoboard.api.Push;
import org.paules.geckoboard.api.error.ValidationException;
import org.paules.geckoboard.api.json.common.GraphType;
import org.paules.geckoboard.api.json.common.TextStrValueItem;
import org.paules.geckoboard.api.json.common.TextStrValuePrefixItem;

import com.google.gson.annotations.SerializedName;

public class NumberAndSecondaryStat extends Push {
    @SerializedName( "item" )
    private final TextStrValueItem[] items = new TextStrValueItem[ 2 ];

    @SuppressWarnings( "unused" )
    private final boolean            absolute;

    @SerializedName( "type" )
    private final GraphType          graphType;

    public NumberAndSecondaryStat( String widgetKey, boolean absolute, GraphType graphType ) {
        super( widgetKey );
        this.absolute = absolute;
        this.graphType = graphType;
    }

    public void setPrimary( String primary, String prefix ) {
        items[ 0 ] = new TextStrValuePrefixItem( "", primary, prefix );
    }

    public void setSecondary( String secondary ) {
        items[ 1 ] = new TextStrValueItem( "", secondary );
    }

    @Override
    protected void validate() throws ValidationException {
        if ( items[ 0 ] != null ) {
            throw new ValidationException( "primary", "Cannot be empty" );
        }
        if (graphType == null) {
            throw new ValidationException( "graphType", "Cannot be null" );
        }
    }

}
