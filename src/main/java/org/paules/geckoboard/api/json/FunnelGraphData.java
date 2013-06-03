package org.paules.geckoboard.api.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public class FunnelGraphData {
    private final String label;

    private String       strValue;


    public FunnelGraphData( String label, String value ) {
        super();
        this.label = label;
        strValue = value;
    }
    public ObjectNode toJson() {
        ObjectNode item = new ObjectMapper().getNodeFactory().objectNode();
        item.put( "label", label );
        item.put( "value", strValue );
        return item;
    }
}
