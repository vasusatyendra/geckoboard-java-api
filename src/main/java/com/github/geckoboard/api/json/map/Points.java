package com.github.geckoboard.api.json.map;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Holder for all points to push to Geckoboard
 * 
 * @author Paul van Assen
 */
public class Points {
    @SerializedName( "point" )
    private List<Point> points = new LinkedList<Point>();

    /**
     * Adds a point to the push message for geckoboard
     * @param point Point to add. 
     */
    public void addPoint( Point point ) {
        points.add( point );
    }
}
