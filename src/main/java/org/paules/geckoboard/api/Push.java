package org.paules.geckoboard.api;

import java.awt.Color;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.error.ValidationException;

public abstract class Push {
    private final boolean disableValidation;
    
    private final ObjectNode        node;

    protected final JsonNodeFactory factory;

    private final String            widgetKey;
    
    protected Push( String widgetKey ) {
        this(widgetKey, false);
    }

    protected Push( String widgetKey, boolean disableValidation ) {
        factory = new ObjectMapper().getNodeFactory();
        node = factory.objectNode();
        this.widgetKey = widgetKey;
        this.disableValidation = disableValidation;
    }

    protected abstract void getData( ObjectNode node );
    
    protected abstract void validate() throws ValidationException;

    String getWidgetKey() {
        return widgetKey;
    }

    void setApiKey( String apiKey ) {
        node.put( "api_key", apiKey );
    }

    public static final String toHexString( Color color ) {
        return String.format( "%06X%02X", ( 0xFFFFFF & color.getRGB() ), ( 0xFF & color.getAlpha() ) );
    }

    public String toJson() {
        if (!disableValidation) {
            validate();
        }
        ObjectNode data = factory.objectNode();
        getData( data );
        node.put( "data", data );
        return node.toString();
    }

}
