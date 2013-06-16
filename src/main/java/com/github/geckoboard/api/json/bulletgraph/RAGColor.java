package com.github.geckoboard.api.json.bulletgraph;

import com.google.gson.annotations.SerializedName;

/**
 * Red Amber Green enum for use in a bullet graph
 * 
 * @author Paul van Assen
 */
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
