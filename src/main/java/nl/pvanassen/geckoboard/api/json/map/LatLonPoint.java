package nl.pvanassen.geckoboard.api.json.map;

/**
 * A point on the map based on GPS coordinates (latitude and longitude)
 * 
 * @author Paul van Assen
 */
public class LatLonPoint extends AbstractPoint {
    @SuppressWarnings( "unused" )
    private final String latitude;

    @SuppressWarnings( "unused" )
    private final String longitude;

    /**
     * Constructor for lat lon point specifying the coordinates
     * 
     * @param latitude GPS Latitude
     * @param longitude GPS Longitude
     */
    public LatLonPoint( String latitude, String longitude ) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
