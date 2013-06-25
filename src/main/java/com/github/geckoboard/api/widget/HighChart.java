package com.github.geckoboard.api.widget;

import com.github.geckoboard.api.Push;
import com.github.geckoboard.api.error.ValidationException;
import com.github.highchart.api.ChartOptions;
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
