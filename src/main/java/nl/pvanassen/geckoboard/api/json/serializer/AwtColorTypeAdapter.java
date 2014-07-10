package nl.pvanassen.geckoboard.api.json.serializer;

import java.awt.Color;
import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Type adapter to convert awt to json
 *
 * @author Paul van Assen
 */
public class AwtColorTypeAdapter extends TypeAdapter<Color> {

    @Override
    public Color read(JsonReader in) throws IOException {
        // We only do writing atm
        return null;
    }

    @Override
    public void write(JsonWriter out, Color color) throws IOException {
        if (color == null) {
            out.nullValue();
            return;
        }
        String colorStr = String.format("%06X%02X", 0xFFFFFF & color.getRGB(), 0xFF & color.getAlpha());
        out.value(colorStr);
    }

}