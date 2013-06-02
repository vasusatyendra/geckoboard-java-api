package org.paules.geckoboard.api.widget;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;

public class RAGNumbersOnly extends Push {
    private static final class Item {
        private final String text;

        private final int    value;

        public Item( String text, int value ) {
            super();
            this.text = text;
            this.value = value;
        }

        public String getText() {
            return text;
        }

        public int getValue() {
            return value;
        }
    }

    private Item red;

    private Item amber;

    private Item green;

    public RAGNumbersOnly( String widgetKey ) {
        super( widgetKey );
    }

    @Override
    protected void getData( ObjectNode data ) {
        ArrayNode items = data.arrayNode();
        data.put( "item", items );
        ObjectNode red = data.objectNode();
        red.put( "value", this.red.getValue() );
        red.put( "text", this.red.getText() );
        items.add( red );

        ObjectNode amber = data.objectNode();
        amber.put( "value", this.amber.getValue() );
        amber.put( "text", this.amber.getText() );
        items.add( amber );

        ObjectNode green = data.objectNode();
        green.put( "value", this.green.getValue() );
        green.put( "text", this.green.getText() );
        items.add( green );
    }

    public void setAmber( String label, int value ) {
        amber = new Item( label, value );
    }

    public void setGreen( String label, int value ) {
        green = new Item( label, value );
    }

    public void setRed( String label, int value ) {
        red = new Item( label, value );
    }
}
