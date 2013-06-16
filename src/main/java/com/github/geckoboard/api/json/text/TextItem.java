package com.github.geckoboard.api.json.text;

/**
 * This is the type for the text widget
 * http://www.geckoboard.com/developers/custom-widgets/widget-types/text/
 * 
 * @author Paul van Assen
 */
public class TextItem {
    private final String       text;

    private final TextItemType type;

    public TextItem( String text, TextItemType type ) {
        super();
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public TextItemType getType() {
        return type;
    }
}