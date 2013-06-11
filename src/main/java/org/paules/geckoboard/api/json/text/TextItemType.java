package org.paules.geckoboard.api.json.text;

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
    NONE(),
    /**
     * Alert icon
     */
    @SerializedName( "1" )
    ALERT(),
    /**
     * Info icon
     */
    @SerializedName( "2" )
    INFO();
}