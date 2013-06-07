package org.paules.geckoboard.api.json;

import java.awt.Color;

public final class ColorUtil {
    private ColorUtil() {

    }

    /**
     * Transforms awt color to a string suitable for Geckoboard
     * 
     * @param color AWT color
     * @return String for geckoboard json
     */
    public static final String toHexString( Color color ) {
        return String.format( "%06X%02X", ( 0xFFFFFF & color.getRGB() ), ( 0xFF & color.getAlpha() ) );
    }

}
