package org.paules.geckoboard.api.widget;

import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;

public class Numbers extends Push {
    private final List<Data> data = new LinkedList<Data>();

    public Numbers( String widgetKey ) {
        super( widgetKey );
    }

    public void addPrimary( String label, int value ) {
        data.set( 0, new Data( label, value ) );
    }

    public void addSecondary( String label, int value ) {
        data.set( 1, new Data( label, value ) );
    }

    @Override
    protected void getData( ObjectNode data ) {
        addData( data, this.data );
    }
}
