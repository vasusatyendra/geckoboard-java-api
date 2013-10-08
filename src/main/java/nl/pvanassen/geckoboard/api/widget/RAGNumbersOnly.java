package nl.pvanassen.geckoboard.api.widget;


import nl.pvanassen.geckoboard.api.Push;
import nl.pvanassen.geckoboard.api.error.ValidationException;
import nl.pvanassen.geckoboard.api.json.common.TextValueItem;

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
