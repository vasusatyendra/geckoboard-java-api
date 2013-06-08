package org.paules.geckoboard.api.json.common;

import com.google.gson.annotations.SerializedName;

public enum GraphType {
    /**
     * Standard graph
     */
    @SerializedName( "standard" )
    STANDARD,
    /**
     * Reverse graph
     */
    @SerializedName( "reverse" )
    REVERSE;
}