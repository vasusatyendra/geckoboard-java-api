package com.github.geckoboard.api.json.map;

/**
 * A point on the map based on a city name
 * @author Paul van Assen
 *
 */
public class CityPoint extends Point {
    @SuppressWarnings( "unused" )
    private final City city;

    /**
     * Constructor with city name and optionally region and country code. 
     * @param cityName City name
     * @param regionCode Optional region code for more accuracy about the city
     * @param countryCode Optional country code for more accuracy about the city
     */
    public CityPoint( String cityName, String regionCode, String countryCode ) {
        city = new City( cityName, regionCode, countryCode );
    }
}
