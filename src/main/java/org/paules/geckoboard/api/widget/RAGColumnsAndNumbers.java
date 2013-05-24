package org.paules.geckoboard.api.widget;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;


public class RAGColumnsAndNumbers extends Push
{
    private final List<Data> data = new ArrayList<Data>(3);
    private final boolean reverse;

    public RAGColumnsAndNumbers(String widgetKey, boolean reverse)
    {
        super(widgetKey);
        this.reverse = reverse;
    }

    public void addRed(String label, int value)
    {
        data.set(0, new Data(label, value));
    }

    public void addRed(String label, int value, String prefix)
    {
        data.set(0, new Data(label, value, prefix));
    }

    public void addOrange(String label, int value)
    {
        data.set(1, new Data(label, value));
    }

    public void addOrange(String label, int value, String prefix)
    {
        data.set(1, new Data(label, value, prefix));
    }

    public void addGreen(String label, int value)
    {
        data.set(2, new Data(label, value));
    }

    public void addGreen(String label, int value, String prefix)
    {
        data.set(2, new Data(label, value, prefix));
    }

    @Override
    protected void getData(ObjectNode data)
    {
        if (reverse)
        {
            data.put("type", "reverse");
        }
        addData(data, this.data);
    }
}
