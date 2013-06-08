package org.paules.geckoboard.helper;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.paules.geckoboard.api.Push;
import org.paules.geckoboard.api.WidgetWrapper;
import org.paules.geckoboard.api.gson.GsonFactory;

import com.google.gson.Gson;

public final class JsonTestHelper {
    public static JsonNode getJsonFromWidget( Push widget ) throws JsonProcessingException, IOException {
        Gson gson = GsonFactory.getGson();
        WidgetWrapper wrapper = new WidgetWrapper( widget, "1234" );

        ObjectMapper om = new ObjectMapper();
        return om.readTree( gson.toJson( wrapper ) );
    }
}
