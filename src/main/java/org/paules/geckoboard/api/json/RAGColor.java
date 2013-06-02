package org.paules.geckoboard.api.json;

import com.google.gson.annotations.SerializedName;

public enum RAGColor {
    /**
     * Red color
     */
    @SerializedName( "red" )
    RED,
    /**
     * Amber color
     */
    @SerializedName( "amber" )
    AMBER,
    /**
     * Green color
     */
    @SerializedName( "green" )
    GREEN;
}
