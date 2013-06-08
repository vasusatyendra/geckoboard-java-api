package org.paules.geckoboard.api.json.bulletgraph;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public class Position {
    protected int start;

    protected int end;

    public Position( int start, int end ) {
        super();
        this.start = start;
        this.end = end;
    }

    public ObjectNode toJson() {
        ObjectNode node = new ObjectMapper().getNodeFactory().objectNode();
        node.put( "start", start );
        node.put( "end", end );
        return node;
    }
}