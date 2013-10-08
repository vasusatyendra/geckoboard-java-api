package nl.pvanassen.geckoboard.api.widget;

import nl.pvanassen.geckoboard.api.Push;
import nl.pvanassen.geckoboard.api.error.ValidationException;
import nl.pvanassen.highchart.api.ChartOptions;

import com.google.gson.annotations.SerializedName;

/**
 * Line chart widget
 * 
 * @author Paul van Assen
 */
public class HighChart extends Push {
    @SerializedName("highchart")
    private ChartOptions chartOptions = new ChartOptions();
    
    public HighChart( String widgetKey ) {
        super( widgetKey );
    }
    
    public ChartOptions getChartOptions() {
        return chartOptions;
    }
    
    @Override
    protected void validate() throws ValidationException {
        // TODO Auto-generated method stub
        
    }

}
