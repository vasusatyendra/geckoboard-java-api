package com.github.geckoboard.api.widget;


import com.github.geckoboard.api.Push;
import com.github.geckoboard.api.error.ValidationException;
import com.github.geckoboard.api.json.common.TextValueItem;
import com.google.gson.annotations.SerializedName;

/**
 * Red Orange Green numbers only widget type
 * 
 * @author Paul van Assen
 */
public class RAGNumbersOnly extends Push {
    @SerializedName( "item" )
    private final TextValueItem[] items = new TextValueItem[ 3 ];

    public RAGNumbersOnly( String widgetKey ) {
        super( widgetKey );
    }

    public void setAmber( String label, int value ) {
        items[ 1 ] = new TextValueItem( label, value );
    }

    public void setGreen( String label, int value ) {
        items[ 2 ] = new TextValueItem( label, value );
    }

    public void setRed( String label, int value ) {
        items[ 0 ] = new TextValueItem( label, value );
    }

    @Override
    protected void validate() throws ValidationException {
    }

}
