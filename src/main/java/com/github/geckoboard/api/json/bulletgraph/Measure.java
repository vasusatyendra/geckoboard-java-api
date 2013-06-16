package com.github.geckoboard.api.json.bulletgraph;

/**
 * Measure class for the bullet graph
 * 
 * @author Paul van Assen
 */
public class Measure {
    private Position current;

    private Position projected;

    public Position getCurrent() {
        return current;
    }

    public void setCurrent( Position current ) {
        this.current = current;
    }

    public Position getProjected() {
        return projected;
    }

    public void setProjected( Position projected ) {
        this.projected = projected;
    }


}