package org.paules.geckoboard.api.gson;

import java.awt.Color;

import org.paules.geckoboard.api.json.serializer.AwtColorTypeAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Gson factory for getting a correct configured Gson instance
 * 
 * @author Paul van Assen
 */
public final class GsonFactory {
    private final GsonBuilder        gsonBuilder;

    private static final GsonFactory INSTANCE = new GsonFactory();

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
    }
}
