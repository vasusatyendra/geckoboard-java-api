package nl.pvanassen.geckoboard.api.json.bulletgraph;

import nl.pvanassen.geckoboard.api.error.ValidationException;

/**
 * Bullet graph position object
 *
 * @author Paul van Assen
 */
public class Position {

    private final int start;

    private final int end;

    public Position(int start, int end) {
        super();
        this.start = start;
        this.end = end;
    }

    protected void validate() throws ValidationException {
        if (start < 0) {
            throw new ValidationException("start", "Start position cannot be less than 0");
        }
        if (end < 0) {
            throw new ValidationException("end", "End position cannot be less than 0");
        }
    }
}