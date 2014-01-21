package nl.pvanassen.geckoboard.api.json.monitoring;

/**
 * Monitor item for the monitoring widget
 * 
 * @author Paul van Assen
 */
public class MonitorItem {
    private String status;
    private String downTime;
    private String responseTime;

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public String getDownTime() {
        return downTime;
    }

    public void setDownTime( String downTime ) {
        this.downTime = downTime;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime( String responseTime ) {
        this.responseTime = responseTime;
    }

}
