package nl.pvanassen.geckoboard.api.json.bulletgraph;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Axis class for bullet graph
 *
 * @author Paul van Assen
 */
public class Axis {

    @SerializedName("point")
    private final List<String> points = new LinkedList<String>();

    public List<String> getPoints() {
        return points;
    }

}