package nl.pvanassen.geckoboard.api.json.bulletgraph;

import nl.pvanassen.geckoboard.api.error.ValidationException;

/**
 * Measure class for the bullet graph
 * 
 * @author Paul van Assen
 */
public class Measure {
    private Position current;

    private Position projected;

    public void setCurrent( Position current ) {
        this.current = current;
    }

    public void setProjected( Position projected ) {
        this.projected = projected;
    }

    protected void validate() throws ValidationException {
        if ( current == null ) {
            throw new ValidationException( "current", "Current position may not be empty" );
        }
        if ( projected == null ) {
            throw new ValidationException( "current", "Current projected may not be empty" );
        }
        current.validate();
        projected.validate();
    }
}