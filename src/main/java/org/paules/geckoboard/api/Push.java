package org.paules.geckoboard.api;

import org.paules.geckoboard.api.error.ValidationException;

public abstract class Push {
    private final String widgetKey;

    protected Push( String widgetKey ) {
        this.widgetKey = widgetKey;
    }

    protected abstract void validate() throws ValidationException;

    String getWidgetKey() {
        return widgetKey;
    }

}
