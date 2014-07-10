package nl.pvanassen.geckoboard.api.widget;

import nl.pvanassen.geckoboard.api.Push;
import nl.pvanassen.geckoboard.api.error.ValidationException;
import nl.pvanassen.geckoboard.api.json.common.GraphType;
import nl.pvanassen.geckoboard.api.json.common.TextStrValueItem;

import com.google.gson.annotations.SerializedName;

/**
 * Geck-o-meter widget
 *
 * @author Paul van Assen
 */
public class GeckOMeter extends Push {

    @SerializedName("type")
    private final GraphType type;

    @SerializedName("item")
    private String current;

    private TextStrValueItem min;

    private TextStrValueItem max;

    public GeckOMeter(String widgetKey, GraphType type) {
        super(widgetKey);
        this.type = type;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public void setMax(String label, String value) {
        max = new TextStrValueItem(label, value);
    }

    public void setMin(String label, String value) {
        min = new TextStrValueItem(label, value);
    }

    @Override
    protected void validate() throws ValidationException {
        if (current == null || current.isEmpty()) {
            throw new ValidationException("current", "Must be set");
        }
        if (min == null) {
            throw new ValidationException("min", "Must be set");
        }
        if (max == null) {
            throw new ValidationException("max", "Must be set");
        }
        if (type == null) {
            throw new ValidationException("type", "Must be set");
        }
    }
}
