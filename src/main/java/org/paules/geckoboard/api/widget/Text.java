package org.paules.geckoboard.api.widget;

import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;

public class Text extends Push {
    private static class TextItem {
        private final String text;

        private final Type   type;

        public TextItem( String text, Type type ) {
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

    public enum Type {
        NONE( 0 ), ALERT( 1 ), INFO( 2 );
        private final int jsonValue;

        private Type( int jsonValue ) {
            this.jsonValue = jsonValue;
        }
    }

    private List<TextItem> text = new LinkedList<TextItem>();

    public Text( String widgetKey ) {
        super( widgetKey );
    }

    public void addText( String text ) {
        addText( text, Type.NONE );
    }

    public void addText( String text, Type type ) {
        this.text.add( new TextItem( text, type ) );
    }

    @Override
    protected void getData( ObjectNode node ) {
    }

    @Override
    public String toJson() {
        ObjectNode node = factory.objectNode();
        ArrayNode items = node.arrayNode();
        for ( TextItem dataEntry : text ) {
            items.add( dataEntry.toJson() );
        }
        node.put( "item", items );
        return node.toString();
    }
}
