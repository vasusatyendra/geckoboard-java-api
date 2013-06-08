package org.paules.geckoboard.api.json.common;

public class TextStrValueItem {
    private final String text;

    private final String value;

    public TextStrValueItem( String text, String value ) {
        super();
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}