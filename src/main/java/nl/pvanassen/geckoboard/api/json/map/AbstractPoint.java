package nl.pvanassen.geckoboard.api.json.map;

import java.awt.Color;

import com.google.gson.annotations.SerializedName;

/**
 * Base type for a point containing generic properties
 *
 * @author Paul van Assen
 */
public abstract class AbstractPoint {

    @SuppressWarnings("unused")
    private Integer size;

    @SuppressWarnings("unused")
    private Color color;

    @SuppressWarnings("unused")
    @SerializedName("cssclass")
    private String cssClass;

    public AbstractPoint setSize(int size) {
        this.size = size;
        return this;
    }

    public AbstractPoint setColor(Color color) {
        this.color = color;
        return this;
    }

    public AbstractPoint setCssClass(String cssClass) {
        this.cssClass = cssClass;
        return this;
    }

}
