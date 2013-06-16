package com.github.geckoboard.api.json.bulletgraph;

/**
 * Bullet graph position object
 * @author Paul van Assen
 *
 */
public class Position {
    private final int start;

    private final int end;

    public Position( int start, int end ) {
        super();
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}