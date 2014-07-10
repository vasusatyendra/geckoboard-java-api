package nl.pvanassen.geckoboard.api.gson;

import java.awt.Color;

import nl.pvanassen.highchart.api.base.Style;
import nl.pvanassen.highchart.api.format.DateTimeLabelFormats;
import nl.pvanassen.highchart.api.serializer.DateTimeLabelFormatsSerializer;
import nl.pvanassen.highchart.api.serializer.StyleSerializer;

import com.google.gson.*;

/**
 * Gson factory for getting a correct configured Gson instance
 *
 * @author Paul van Assen
 */
public final class GsonFactory {

    private final GsonBuilder gsonBuilder;

    private static final String yyyy_MM_dd = "yyyyMMdd";

    private static final String USER_OBJECT = "userObject";

    private static final String WIDGET_KEY = "widgetKey";

    private static final GsonFactory INSTANCE = new GsonFactory();

    /**
     * Get a correct configured gson
     *
     * @return Gson implementation
     */
    public static Gson getGson() {
        return GsonFactory.INSTANCE.gsonBuilder.create();
    }

    private GsonFactory() {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Color.class, new AwtColorTypeAdapter());
        gsonBuilder.registerTypeAdapter(DateTimeLabelFormats.class, new DateTimeLabelFormatsSerializer());
        gsonBuilder.registerTypeAdapter(Style.class, new StyleSerializer());
        gsonBuilder.setDateFormat(GsonFactory.yyyy_MM_dd);
        gsonBuilder.setExclusionStrategies(new ExclusionStrategy() {

            @Override
            public boolean shouldSkipClass(Class<?> arg0) {
                return false;
            }

            @Override
            public boolean shouldSkipField(FieldAttributes attributes) {
                String name = attributes.getName();
                return name.equals(GsonFactory.USER_OBJECT) || name.equals(GsonFactory.WIDGET_KEY);
            }
        });

    }
}
