package org.paules.geckoboard.api.widget;

import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;

public class Text extends Push {
    private static class TextItem {
        private String text;

        private Type   type;

        public TextItem( String text, Type type ) {
            super();
            this.text = text;
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public Type getType() {
            return type;
        }
    }

    public enum Type {
        NONE( 0 ), ALERT( 1 ), INFO( 2 );
        private final int jsonValue;

        private Type( int jsonValue ) {
            this.jsonValue = jsonValue;
        }

        public int getJsonValue() {
            return jsonValue;
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
        ArrayNode itemsNode = node.arrayNode();
        node.put( "item", itemsNode );
        for ( TextItem item : text ) {
            ObjectNode itemNode = itemsNode.objectNode();
            itemNode.put( "text", item.getText() );
            itemNode.put( "type", item.getType().jsonValue );
            itemsNode.add( itemNode );
        }
    }
}
