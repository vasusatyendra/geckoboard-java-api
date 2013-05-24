package org.paules.geckoboard.api.widget;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;


public class RAGNumbersOnly extends Push
{
    private final List<Data> data = new ArrayList<Data>(3);

    public RAGNumbersOnly(String widgetKey)
    {
        super(widgetKey);
    }

    public void addRed(String label, int value)
    {
        data.set(0, new Data(label, value));
    }

    public void addOrange(String label, int value)
    {
        data.set(1, new Data(label, value));
    }

    public void addGreen(String label, int value)
    {
        data.set(2, new Data(label, value));
    }

    @Override
    protected void getData(ObjectNode data)
    {
        addData(data, this.data);
    }
}
