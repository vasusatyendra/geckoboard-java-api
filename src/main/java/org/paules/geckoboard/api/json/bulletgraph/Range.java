package org.paules.geckoboard.api.json.bulletgraph;


public class Range extends Position {
    @SuppressWarnings( "unused" )
    private RAGColor color;

    public Range( int start, int end, RAGColor color ) {
        super( start, end );
        this.color = color;
    }
}