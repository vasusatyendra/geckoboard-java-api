package org.paules.geckoboard.api;

import com.google.gson.annotations.SerializedName;

/**
 * Wrapper to get correct json through gson
 * 
 * @author Paul van Assen
 */
public class WidgetWrapper {
    @SerializedName( "data" )
    private final Push   push;

    @SerializedName( "api_key" )
    private final String apiKey;

    public WidgetWrapper( Push push, String apiKey ) {
        this.push = push;
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public Push getPush() {
        return push;
    }

}
