package org.paules.geckoboard.api.json.common;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public class TextItem {
    private final String text;

    private final TextItemType   type;

    public TextItem( String text, TextItemType type ) {
        super();
        this.text = text;
        this.type = type;
    }

    public ObjectNode toJson() {
        ObjectNode item = new ObjectMapper().getNodeFactory().objectNode();
        item.put( "text", text );
        item.put( "type", type.jsonValue );
        return item;

    }
}