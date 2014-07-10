package nl.pvanassen.geckoboard.api.json.list;

import java.awt.Color;

/**
 * Label type for the list widget http://www.geckoboard.com/developers/custom-widgets/widget-types/list
 *
 * @author Paul van Assen
 */
public class Label {

    private String name;

    private Color color;

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    void setColor(Color color) {
        this.color = color;
    }
}
