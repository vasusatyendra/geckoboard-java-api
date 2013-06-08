package org.paules.geckoboard.api.json.common;

import java.awt.Color;

/**
 * Label value color item for PieChart
 * 
 * @author Paul van Assen
 */
public class LabelValueColorItem extends LabelValueItem {

    @SuppressWarnings( "unused" )
    private final Color color;

    public LabelValueColorItem( String label, String value, Color color ) {
        super( label, value );
        this.color = color;
    }

}
