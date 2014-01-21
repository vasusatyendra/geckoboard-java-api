package nl.pvanassen.geckoboard.api.widget;

import nl.pvanassen.geckoboard.api.Push;
import nl.pvanassen.geckoboard.api.error.ValidationException;
import nl.pvanassen.geckoboard.api.json.monitoring.MonitorItem;

import com.google.gson.annotations.SerializedName;

/**
 * Monitoring widget
 * 
 * @author Paul van Assen
 */
public class Monitoring extends Push {
    @SerializedName( "item" )
    private MonitorItem item;

    /**
     * Constructor with widget key
     * 
     * @param widgetKey Key of the widget to use
     */
    public Monitoring( String widgetKey ) {
        super( widgetKey );
        item = new MonitorItem();
    }

    public void setStatus( String status ) {
        item.setStatus( status );
    }

    public void setDownTime( String downTime ) {
        item.setDownTime( downTime );
    }

    public void setResponseTime( String responseTime ) {
        item.setResponseTime( responseTime );
    }

    @Override
    protected void validate() throws ValidationException {
        if ( item.getStatus() == null ) {
            throw new ValidationException( "status", "Should be filled" );
        }
    }
}
