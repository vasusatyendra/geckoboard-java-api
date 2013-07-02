package com.github.geckoboard.api.json.bulletgraph;

import com.github.geckoboard.api.error.ValidationException;

/**
 * Bullet graph comparative point
 * 
 * @author Paul van Assen
 */
public class Point {

    private final String point;

    public Point( String point ) {
        this.point = point;
    }

    public void validate() throws ValidationException {
        if ( point == null ) {
            throw new ValidationException( "point", "Point cannot be null" );

        }
    }
}