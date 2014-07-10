package nl.pvanassen.geckoboard.api;

import com.google.gson.annotations.SerializedName;

/**
 * Wrapper to get correct json through gson
 * 
 * @author Paul van Assen
 */
class WidgetWrapper {
    @SerializedName( "data" )
    private final Push   push;

    @SerializedName( "api_key" )
    private final String apiKey;

    WidgetWrapper( Push push, String apiKey ) {
        this.push = push;
        this.apiKey = apiKey;
    }

    String getApiKey() {
        return apiKey;
    }

    Push getPush() {
        return push;
    }

}
