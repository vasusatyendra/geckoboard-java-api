package nl.pvanassen.geckoboard.api.json.list;

/**
 * Title item for list widget
 * 
 * @author Paul van Assen
 */
public class Title {
    private String  text;

    private Boolean highlight;

    public String getText() {
        return text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    public boolean isHighlight() {
        return highlight;
    }

    public void setHighlight( Boolean highlight ) {
        this.highlight = highlight;
    }

}
