package org.paules.geckoboard.api.widget;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;

public class NumberAndSecondaryStat extends Push {
    private int   number;

    private Float percent;

    public NumberAndSecondaryStat( String widgetKey ) {
        super( widgetKey );
    }

    @Override
    protected void getData( ObjectNode node ) {
        ArrayNode item = node.arrayNode();
        ObjectNode number = item.objectNode();
        number.put( "value", this.number );
        item.add( number );
        if ( percent != null ) {
            ObjectNode percent = item.objectNode();
            percent.put( "value", this.percent );
            item.add( percent );
        }
    }

    public void setNumber( int number ) {
        this.number = number;
    }

    public void setPercent( Float percent ) {
        this.percent = percent;
    }
}
