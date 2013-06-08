package org.paules.geckoboard.api.json.bulletgraph;

/**
 * Measure class for the bullet graph
 * @author Paul van Assen
 *
 */
public class Measure {
    @SuppressWarnings("unused")
    private Position current;

    @SuppressWarnings("unused")
    private Position projected;

    public void setCurrent( Position current ) {
        this.current = current;
    }

    public void setProjected( Position projected ) {
        this.projected = projected;
    }
}