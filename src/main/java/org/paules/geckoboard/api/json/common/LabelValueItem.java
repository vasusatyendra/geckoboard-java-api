package org.paules.geckoboard.api.json.common;

/**
 * Label - value item for funnel graph
 * 
 * @author Paul van Assen
 */
public class LabelValueItem {
    @SuppressWarnings( "unused" )
    private final String label;

    @SuppressWarnings( "unused" )
    private String       value;

    public LabelValueItem( String label, String value ) {
        super();
        this.label = label;
        this.value = value;
    }
}
