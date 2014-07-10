package nl.pvanassen.geckoboard.api.json.map;

import com.google.gson.annotations.SerializedName;

/**
 * City object for map api
 *
 * @author Paul van Assen
 */
class City {

    @SuppressWarnings("unused")
    @SerializedName("city_name")
    private final String cityName;

    @SuppressWarnings("unused")
    @SerializedName("region_code")
    private final String regionCode;

    @SuppressWarnings("unused")
    @SerializedName("country_code")
    private final String countryCode;

    /**
     * Constructor for city
     *
     * @param cityName City name, required
     * @param regionCode Region, optional
     * @param countryCode Country, optional
     */
    City(String cityName, String regionCode, String countryCode) {
        super();
        this.cityName = cityName;
        this.regionCode = regionCode;
        this.countryCode = countryCode;
    }

}
