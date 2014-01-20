package nl.pvanassen.geckoboard.api.widget;

import nl.pvanassen.geckoboard.api.Push;
import nl.pvanassen.geckoboard.api.error.ValidationException;
import nl.pvanassen.geckoboard.api.json.map.CityPoint;
import nl.pvanassen.geckoboard.api.json.map.HostPoint;
import nl.pvanassen.geckoboard.api.json.map.IpPoint;
import nl.pvanassen.geckoboard.api.json.map.LatLonPoint;
import nl.pvanassen.geckoboard.api.json.map.AbstractPoint;
import nl.pvanassen.geckoboard.api.json.map.Points;

import com.google.gson.annotations.SerializedName;

/**
 * Text widget type
 * 
 * @author Paul van Assen
 */
public class MapWidget extends Push {
    @SerializedName( "points" )
    private final Points points = new Points();

    public MapWidget( String widgetKey ) {
        super( widgetKey );
    }

    public CityPoint addCityPoint( String cityName, String regionCode, String countryCode ) {
        CityPoint cityPoint = new CityPoint( cityName, regionCode, countryCode );
        points.addPoint( cityPoint );
        return cityPoint;
    }

    public CityPoint addCityPoint( String cityName, String regionCode ) {
        CityPoint cityPoint = new CityPoint( cityName, regionCode, null );
        points.addPoint( cityPoint );
        return cityPoint;
    }

    public CityPoint addCityPoint( String cityName ) {
        CityPoint cityPoint = new CityPoint( cityName, null, null );
        points.addPoint( cityPoint );
        return cityPoint;
    }

    public HostPoint addHostPoint( String hostname ) {
        HostPoint hostPoint = new HostPoint( hostname );
        points.addPoint( hostPoint );
        return hostPoint;
    }
    
    public IpPoint addIpPoint (String ip) {
        IpPoint ipPoint = new IpPoint( ip );
        points.addPoint( ipPoint );
        return ipPoint;
    }
    
    public LatLonPoint addLatLonPoint(String latitude, String longitute) {
        LatLonPoint latLonPoint = new LatLonPoint(latitude, longitute );
        points.addPoint( latLonPoint );
        return latLonPoint;
    }
    
    public <T extends AbstractPoint> T addPoint(T point) {
        points.addPoint(point);
        return point;
    }

    @Override
    protected void validate() throws ValidationException {
    }
}
