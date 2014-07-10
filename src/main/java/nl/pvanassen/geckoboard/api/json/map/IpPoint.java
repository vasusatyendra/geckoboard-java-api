package nl.pvanassen.geckoboard.api.json.map;

/**
 * A point on the map based on an IP address. This IP address is resolved to a location by geckoboard based on geo-ip
 * data
 *
 * @author Paul van Assen
 */
public class IpPoint extends AbstractPoint {

    @SuppressWarnings("unused")
    private final String ip;

    /**
     * Constructor for point
     *
     * @param ip Ip address
     */
    public IpPoint(String ip) {
        super();
        this.ip = ip;
    }

}
