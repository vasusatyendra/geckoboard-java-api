package org.paules.geckoboard.api.json.bulletgraph;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public class Range extends Position {
    private RAGColor color;

    public Range( int start, int end, RAGColor color ) {
        super( start, end );
        this.color = color;
    }

    @Override
    public ObjectNode toJson() {
        ObjectNode node = new ObjectMapper().getNodeFactory().objectNode();
        node.put( "color", color.name().toLowerCase() );
        node.put( "start", start );
        node.put( "end", end );
        return node;
    }
}