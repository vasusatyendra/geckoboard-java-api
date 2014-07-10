package nl.pvanassen.geckoboard.api.widget;

import java.util.LinkedList;
import java.util.List;

import nl.pvanassen.geckoboard.api.Push;
import nl.pvanassen.geckoboard.api.error.ValidationException;
import nl.pvanassen.geckoboard.api.json.text.TextItem;
import nl.pvanassen.geckoboard.api.json.text.TextItemType;

import com.google.gson.annotations.SerializedName;

/**
 * Text widget type
 *
 * @author Paul van Assen
 */
public class Text extends Push {

    @SerializedName("item")
    private final List<TextItem> text = new LinkedList<TextItem>();

    public Text(String widgetKey) {
        super(widgetKey);
    }

    public void addText(String text) {
        addText(text, TextItemType.NONE);
    }

    public void addText(String text, TextItemType type) {
        this.text.add(new TextItem(text, type));
    }

    @Override
    protected void validate() throws ValidationException {
        if (text.size() == 0) {
            throw new ValidationException("item", "Cannot be empty");
        }
    }
}
