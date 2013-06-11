package org.paules.geckoboard.api.json.common;


public class TextItem {
    @SuppressWarnings( "unused" )
    private final String text;

    @SuppressWarnings( "unused" )
    private final TextItemType   type;

    public TextItem( String text, TextItemType type ) {
        super();
        this.text = text;
        this.type = type;
    }
}