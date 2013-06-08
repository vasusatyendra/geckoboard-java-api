package org.paules.geckoboard.api.json.common;

import com.google.gson.annotations.SerializedName;

/**
 * This is the type for the text widget
 * http://www.geckoboard.com/developers/custom-widgets/widget-types/text/
 * 
 * @author Paul van Assen
 */
public enum TextItemType {

    /**
     * No alert icon
     */
    @SerializedName( "0" )
    NONE( 0 ),
    /**
     * Alert icon
     */
    @SerializedName( "1" )
    ALERT( 1 ),
    /**
     * Info icon
     */
    @SerializedName( "2" )
    INFO( 2 );
    final int jsonValue;

    private TextItemType( int jsonValue ) {
        this.jsonValue = jsonValue;
    }
}