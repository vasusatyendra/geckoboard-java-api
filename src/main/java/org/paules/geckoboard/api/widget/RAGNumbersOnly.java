package org.paules.geckoboard.api.widget;

import org.paules.geckoboard.api.Push;
import org.paules.geckoboard.api.error.ValidationException;
import org.paules.geckoboard.api.json.common.TextValueItem;

import com.google.gson.annotations.SerializedName;

public class RAGNumbersOnly extends Push {
    @SerializedName( "item" )
    private final TextValueItem[] items = new TextValueItem[ 3 ];

    public RAGNumbersOnly( String widgetKey ) {
        super( widgetKey );
    }

    @Override
    protected void validate() throws ValidationException {
    }
    
    public void setRed( String label, int value ) {
        items[ 0 ] = new TextValueItem( label, value );
    }

    public void setAmber( String label, int value ) {
        items[ 1 ] = new TextValueItem( label, value );
    }

    public void setGreen( String label, int value ) {
        items[ 2 ] = new TextValueItem( label, value );
    }

}
