package nl.pvanassen.geckoboard.api.widget;

import nl.pvanassen.geckoboard.api.Push;
import nl.pvanassen.geckoboard.api.error.ValidationException;

/**
 * Monitoring widget
 *
 * @author Paul van Assen
 */
public class Monitoring extends Push {

    private String status;

    private String downTime;

    private String responseTime;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDownTime() {
        return downTime;
    }

    public void setDownTime(String downTime) {
        this.downTime = downTime;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * Constructor with widget key
     *
     * @param widgetKey Key of the widget to use
     */
    public Monitoring(String widgetKey) {
        super(widgetKey);
    }

    @Override
    protected void validate() throws ValidationException {
        if (status == null) {
            throw new ValidationException("status", "Should be filled");
        }
    }
}
