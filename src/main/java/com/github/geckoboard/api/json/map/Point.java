package com.github.geckoboard.api.json.map;

import java.awt.Color;

import com.google.gson.annotations.SerializedName;

/**
 * Base type for a point containing generic properties
 * 
 * @author Paul van Assen
 */
public class Point {

    @SuppressWarnings( "unused" )
    private Integer    size;

    @SuppressWarnings( "unused" )
    private Color  color;

    @SuppressWarnings( "unused" )
    @SerializedName( "cssclass" )
    private String cssClass;

    public Point setSize( int size ) {
        this.size = size;
        return this;
    }

    public Point setColor( Color color ) {
        this.color = color;
        return this;
    }

    public Point setCssClass( String cssClass ) {
        this.cssClass = cssClass;
        return this;
    }

}
