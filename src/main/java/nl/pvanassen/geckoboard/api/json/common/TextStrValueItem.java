package nl.pvanassen.geckoboard.api.json.common;

/**
 * A text-string value type for generic use
 * 
 * @author Paul van Assen
 */
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