package nl.pvanassen.geckoboard.api;

import nl.pvanassen.geckoboard.api.error.ValidationException;

/**
 * Abstract push type. This is the base type of every widget type
 *
 * @author Paul van Assen
 */
public abstract class Push {

    private final String widgetKey;

    protected Push(String widgetKey) {
        this.widgetKey = widgetKey;
    }

    final String getWidgetKey() {
        return widgetKey;
    }

    protected abstract void validate() throws ValidationException;

}
