package org.paules.geckoboard.api.json.bulletgraph;

/**
 * Bullet graph range
 * 
 * @author Paul van Assen
 */
public class Range extends Position {
    private final RAGColor color;

    public Range( int start, int end, RAGColor color ) {
        super( start, end );
        this.color = color;
    }

    public RAGColor getColor() {
        return color;
    }
}