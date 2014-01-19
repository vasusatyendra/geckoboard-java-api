package nl.pvanassen.geckoboard.api;

import nl.pvanassen.geckoboard.api.error.ValidationException;

public abstract class Push {
    private final String widgetKey;

    protected Push( String widgetKey ) {
        this.widgetKey = widgetKey;
    }

    final String getWidgetKey() {
        return widgetKey;
    }

    protected abstract void validate() throws ValidationException;

}
