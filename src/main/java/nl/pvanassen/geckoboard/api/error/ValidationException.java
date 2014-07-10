package nl.pvanassen.geckoboard.api.error;

/**
 * Validation error message
 *
 * @author Paul van Assen
 */
public class ValidationException extends GeckoboardException {

    private static final long serialVersionUID = 178537955277326969L;

    private final String field;

    private final String validationError;

    public ValidationException(String field, String validationError) {
        super(String.format("Validation failed for field: '%s' with validation error: %s", field, validationError));
        this.field = field;
        this.validationError = validationError;
    }

    public String getField() {
        return field;
    }

    public String getValidationError() {
        return validationError;
    }
}
