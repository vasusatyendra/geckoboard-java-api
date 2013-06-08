package org.paules.geckoboard.api.json.common;

public class TextValueItem {
    private final String text;

    private final int    value;

    public TextValueItem( String text, int value ) {
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