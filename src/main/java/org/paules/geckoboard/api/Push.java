package org.paules.geckoboard.api;

import java.awt.Color;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;

public abstract class Push {
    protected class Data {
        private final String label;

        private final int    value;

        private final String prefix;

        private final Color  color;

        public Data( String label, int value ) {
            super();
            this.label = label;
            this.value = value;
            prefix = null;
            color = null;
        }

        public Data( String label, int value, Color color ) {
            super();
            this.label = label;
            this.value = value;
            prefix = null;
            this.color = color;
        }

        public Data( String label, int value, String prefix ) {
            super();
            this.label = label;
            this.value = value;
            this.prefix = prefix;
            color = null;
        }

        public String getLabel() {
            return label;
        }

        public String getPrefix() {
            return prefix;
        }

        public int getValue() {
            return value;
        }

        public ObjectNode toJson() {
            ObjectNode item = new ObjectMapper().getNodeFactory().objectNode();
            item.put( "label", label );
            item.put( "value", value );
            if ( prefix != null ) {
                item.put( "prefix", prefix );
            }
            if ( color != null ) {
                item.put( "color", toHexString( color ) );
            }
            return item;
        }
    }

    private final ObjectNode      node;

    private final JsonNodeFactory factory;

    private final String          widgetKey;

    protected Push( String widgetKey ) {
        factory = new ObjectMapper().getNodeFactory();
        node = factory.objectNode();
        this.widgetKey = widgetKey;
    }

    protected void addData( ObjectNode node, List<Data> data ) {
        ArrayNode items = node.arrayNode();
        node.put( "item", items );
        for ( Data dataEntry : data ) {
            items.add( dataEntry.toJson() );
        }
    }

    protected abstract void getData( ObjectNode node );

    public String getWidgetKey() {
        return widgetKey;
    }

    void setApiKey( String apiKey ) {
        node.put( "api_key", apiKey );
    }

    protected final String toHexString( Color color ) {
        return Integer.toHexString( color.getRed() ) //
        .concat( Integer.toHexString( color.getGreen() ) ) //
        .concat( Integer.toHexString( color.getBlue() ) ) //
        .concat( Integer.toHexString( color.getAlpha() ) );
    }

    public final String toJson() {
        ObjectNode data = factory.objectNode();
        getData( data );
        node.put( "data", data );
        return node.toString();
    }

}
