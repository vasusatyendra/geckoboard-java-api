package org.paules.geckoboard.api.json.common;

public class TextStrValuePrefixItem extends TextStrValueItem {

    private final String prefix;

    public TextStrValuePrefixItem( String text, String value, String prefix ) {
        super(text, value);
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}