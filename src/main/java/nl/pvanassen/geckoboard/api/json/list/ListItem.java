package nl.pvanassen.geckoboard.api.json.list;

import java.awt.Color;

/**
 * Item/line for the list widget
 * 
 * @author Paul van Assen
 */
public class ListItem {
    
    private Label  label = new Label();
    private Title  title = new Title();
    private String description;
    
    public ListItem(String text) {
        this.title.setText( text );
    }

    public void setLabelName(String labelName) {
        label.setName( labelName );
    }

    public void setLabelColor(Color labelColor) {
        label.setColor(labelColor);
    }
    
    public void setTitleHighlight(boolean titleHighlight) {
        this.title.setHighlight( titleHighlight );
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Title getTitle() {
        return title;
    }
    
    public Label getLabel() {
        return label;
    }
        
}
