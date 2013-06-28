package com.github.geckoboard.api.json.map;

/**
 * A point on a map based on a machines host name
 * @author Paul van Assen
 *
 */
public class HostPoint extends Point {
    @SuppressWarnings( "unused" )
    private final String host;

    /**
     * Constructor with name
     * @param hostname Hostname of the machine
     */
    public HostPoint( String hostname ) {
        super();
        this.host = hostname;
    }
    
    
}
