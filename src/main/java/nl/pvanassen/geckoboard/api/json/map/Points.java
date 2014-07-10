package nl.pvanassen.geckoboard.api.json.map;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Holder for all points to push to Geckoboard
 *
 * @author Paul van Assen
 */
public class Points {

    @SerializedName("point")
    private final List<AbstractPoint> points = new LinkedList<AbstractPoint>();

    /**
     * Adds a point to the push message for geckoboard
     * 
     * @param point Point to add.
     */
    public void addPoint(AbstractPoint point) {
        points.add(point);
    }
}
