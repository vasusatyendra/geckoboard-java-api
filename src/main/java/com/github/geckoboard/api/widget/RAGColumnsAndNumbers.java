package com.github.geckoboard.api.widget;


import com.github.geckoboard.api.Push;
import com.github.geckoboard.api.error.ValidationException;
import com.github.geckoboard.api.json.common.GraphType;
import com.github.geckoboard.api.json.common.TextValuePrefixItem;
import com.google.gson.annotations.SerializedName;

public class RAGColumnsAndNumbers extends Push {
    @SerializedName( "item" )
    private TextValuePrefixItem[] items = new TextValuePrefixItem[ 3 ];

    @SerializedName( "type" )
    private GraphType             graphType;

    public RAGColumnsAndNumbers( String widgetKey, GraphType graphType ) {
        super( widgetKey );
        this.graphType = graphType;
    }

    public void setAmber( String label, int value ) {
        setAmber( label, value, null );
    }

    public void setAmber( String label, int value, String prefix ) {
        items[ 1 ] = new TextValuePrefixItem( label, value, prefix );
    }

    public void setGreen( String label, int value ) {
        setGreen( label, value, null );
    }

    public void setGreen( String label, int value, String prefix ) {
        items[ 0 ] = new TextValuePrefixItem( label, value, prefix );
    }

    public void setRed( String label, int value ) {
        setRed( label, value, null );
    }

    public void setRed( String label, int value, String prefix ) {
        items[ 2 ] = new TextValuePrefixItem( label, value, prefix );
    }

    @Override
    protected void validate() throws ValidationException {
        if (graphType == null) {
            throw new ValidationException( "graphType", "Cannot be null" );
        }
    }
}
