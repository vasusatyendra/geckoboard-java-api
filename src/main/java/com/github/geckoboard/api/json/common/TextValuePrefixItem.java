package com.github.geckoboard.api.json.common;

/**
 * Text value prefix item for generic use
 * @author Paul van Assen
 *
 */
public class TextValuePrefixItem extends TextValueItem {

    private final String prefix;

    public TextValuePrefixItem( String text, int value, String prefix ) {
        super( text, value );
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}