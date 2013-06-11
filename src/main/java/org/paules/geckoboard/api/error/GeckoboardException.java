package org.paules.geckoboard.api.error;

public class GeckoboardException extends RuntimeException {
    private static final long serialVersionUID = -2261233303060732601L;

    public GeckoboardException( String message ) {
        super( message );
    }

    public GeckoboardException( String message, Throwable cause ) {
        super( message, cause );
    }
}
