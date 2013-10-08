package nl.pvanassen.geckoboard.api.json.common;

/**
 * A text-string value prefix type for generic use
 * 
 * @author Paul van Assen
 */
public class TextStrValuePrefixItem extends TextStrValueItem {

    private final String prefix;

    public TextStrValuePrefixItem( String text, String value, String prefix ) {
        super( text, value );
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}