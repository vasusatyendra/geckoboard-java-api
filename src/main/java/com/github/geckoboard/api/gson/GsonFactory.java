package com.github.geckoboard.api.gson;

import java.awt.Color;

import com.github.geckoboard.api.json.serializer.AwtColorTypeAdapter;
import com.github.highchart.api.base.Style;
import com.github.highchart.api.format.DateTimeLabelFormats;
import com.github.highchart.api.serializer.DateTimeLabelFormatsSerializer;
import com.github.highchart.api.serializer.StyleSerializer;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Gson factory for getting a correct configured Gson instance
 * 
 * @author Paul van Assen
 */
public final class GsonFactory {
    private final GsonBuilder        gsonBuilder;

    private static final String      yyyy_MM_dd  = "yyyyMMdd";

    private static final String      USER_OBJECT = "userObject";

    private static final String      WIDGET_KEY = "widgetKey";

    private static final GsonFactory INSTANCE    = new GsonFactory();

    /**
     * Get a correct configured gson
     * 
     * @return Gson implementation
     */
    public static Gson getGson() {
        return INSTANCE.gsonBuilder.create();
    }

    private GsonFactory() {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter( Color.class, new AwtColorTypeAdapter() );
        gsonBuilder.registerTypeAdapter( DateTimeLabelFormats.class, new DateTimeLabelFormatsSerializer() );
        gsonBuilder.registerTypeAdapter( Style.class, new StyleSerializer() );
        gsonBuilder.setDateFormat( yyyy_MM_dd );
        gsonBuilder.setExclusionStrategies( new ExclusionStrategy() {

            @Override
            public boolean shouldSkipClass( Class<?> arg0 ) {
                return false;
            }

            @Override
            public boolean shouldSkipField( FieldAttributes attributes ) {
                String name = attributes.getName();
                return name.equals( USER_OBJECT ) || name.equals( WIDGET_KEY );
            }
        } );

    }
}
