package com.github.geckoboard.api.widget;

import com.github.geckoboard.api.Push;
import com.github.geckoboard.api.error.ValidationException;
import com.github.geckoboard.api.json.map.CityPoint;
import com.github.geckoboard.api.json.map.HostPoint;
import com.github.geckoboard.api.json.map.IpPoint;
import com.github.geckoboard.api.json.map.LatLonPoint;
import com.github.geckoboard.api.json.map.Point;
import com.github.geckoboard.api.json.map.Points;
import com.google.gson.annotations.SerializedName;

/**
 * Text widget type
 * 
 * @author Paul van Assen
 */
public class Map extends Push {
    @SerializedName( "points" )
    private final Points points = new Points();

    public Map( String widgetKey ) {
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
    
    public <T extends Point> T addPoint(T point) {
        points.addPoint(point);
        return point;
    }

    @Override
    protected void validate() throws ValidationException {
    }
}
