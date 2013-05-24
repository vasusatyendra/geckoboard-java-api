package org.paules.geckoboard.api.widget;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;


public class LineChart extends Push
{
    private final List<Double> items = new LinkedList<Double>();

    private List<String> xAxis;

    private List<String> yAxis;

    private Color color;

    public LineChart(String widgetKey)
    {
        super(widgetKey);
    }

    public void addDataPoint(double dataPoint)
    {
        items.add(dataPoint);
    }

    public void setXAxisLabels(String[] labels)
    {
        setXAxisLabels(Arrays.asList(labels));
    }

    public void setXAxisLabels(Collection<String> labels)
    {
        xAxis = new ArrayList<String>(labels);
    }

    public void setYAxisLabels(String[] labels)
    {
        setYAxisLabels(Arrays.asList(labels));
    }

    public void setYAxisLabels(Collection<String> labels)
    {
        yAxis = new ArrayList<String>(labels);
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    @Override
    protected void getData(ObjectNode node)
    {
        ArrayNode itemNode = node.arrayNode();
        for (double item : items)
        {
            itemNode.add(item);
        }
        node.put("item", itemNode);
        ObjectNode settings = node.objectNode();
        if (xAxis != null)
        {
            ArrayNode xAxis = settings.arrayNode();
            node.put("xaxis", xAxis);
            for (String x : this.xAxis)
            {
                xAxis.add(x);
            }
        }
        if (yAxis != null)
        {
            ArrayNode yAxis = settings.arrayNode();
            node.put("yaxis", yAxis);
            for (String y : this.yAxis)
            {
                yAxis.add(y);
            }
        }
        if (color != null)
        {
            settings.put("color", toHexString(color));
        }
        if (settings.size() > 0)
        {
            node.put("settings", settings);
        }
    }
}
