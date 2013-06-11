package org.paules.geckoboard.api.json.common;

/**
 * Label - value item for funnel graph
 * 
 * @author Paul van Assen
 */
public class LabelValueItem {
    private final String label;

    private final String value;

    public LabelValueItem( String label, String value ) {
        super();
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }
}
