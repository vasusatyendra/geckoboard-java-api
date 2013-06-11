package org.paules.geckoboard.api.json.bulletgraph;

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

    public String getPoint() {
        return point;
    }
}