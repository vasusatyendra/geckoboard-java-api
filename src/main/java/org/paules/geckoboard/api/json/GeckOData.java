package org.paules.geckoboard.api.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public class GeckOData {
    private final String text;

    private String       strValue;

    public GeckOData( String text, String value ) {
        super();
        this.text = text;
        strValue = value;
    }

    public ObjectNode toJson() {
        ObjectNode item = new ObjectMapper().getNodeFactory().objectNode();
        item.put( "text", text );
        item.put( "value", strValue );
        return item;
    }

}
