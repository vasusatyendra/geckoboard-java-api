package org.paules.geckoboard.api.json;

import java.awt.Color;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;

public class PieChartData {
    private final String label;

    private final String strValue;

    private final Color  color;

    public PieChartData( String label, String value, Color color ) {
        super();
        this.label = label;
        strValue = value;
        this.color = color;
    }

    public ObjectNode toJson() {
        ObjectNode item = new ObjectMapper().getNodeFactory().objectNode();
        item.put( "label", label );
        item.put( "value", strValue );
        if ( color != null ) {
            item.put( "color", Push.toHexString( color ) );
        }
        return item;
    }
}
