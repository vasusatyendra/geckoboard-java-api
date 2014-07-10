package nl.pvanassen.geckoboard.api.widget;

import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;

import nl.pvanassen.geckoboard.api.JsonTestHelper;
import nl.pvanassen.geckoboard.api.error.ValidationException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

public class LineChartTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        LineChart widget = new LineChart("1234");
        widget.addDataPoint("1.2");
        widget.addDataPoint("2.0");
        widget.addDataPoint("4");
        widget.addDataPoint("0.4");
        widget.setColor(Color.RED);
        widget.setAxisXLabels(Arrays.asList(new String[] { "Jan", "Feb", "Mar", "Apr" }));
        widget.setAxisYLabels(Arrays.asList(new String[] { "1", "2", "3", "4", "5" }));
        widget.validate();

        JsonNode data = JsonTestHelper.getJsonFromWidget(widget);

        Assert.assertNotNull(data.get("data"));
        JsonNode node = data.get("data");
        Assert.assertNull(node.get("widgetKey"));

        Assert.assertTrue(node.get("item").isArray());
        Assert.assertEquals(4, node.get("item").size());
        Assert.assertEquals("1.2", node.get("item").get(0).asText());
        Assert.assertEquals("2.0", node.get("item").get(1).asText());
        Assert.assertEquals("4", node.get("item").get(2).asText());
        Assert.assertEquals("0.4", node.get("item").get(3).asText());

        Assert.assertTrue(node.get("settings").get("axisx").isArray());
        Assert.assertEquals(4, node.get("settings").get("axisx").size());
        Assert.assertEquals("Jan", node.get("settings").get("axisx").get(0).asText());
        Assert.assertEquals("Feb", node.get("settings").get("axisx").get(1).asText());
        Assert.assertEquals("Mar", node.get("settings").get("axisx").get(2).asText());
        Assert.assertEquals("Apr", node.get("settings").get("axisx").get(3).asText());

        Assert.assertTrue(node.get("settings").get("axisy").isArray());
        Assert.assertEquals(5, node.get("settings").get("axisy").size());
        Assert.assertEquals("1", node.get("settings").get("axisy").get(0).asText());
        Assert.assertEquals("2", node.get("settings").get("axisy").get(1).asText());
        Assert.assertEquals("3", node.get("settings").get("axisy").get(2).asText());
        Assert.assertEquals("4", node.get("settings").get("axisy").get(3).asText());
        Assert.assertEquals("5", node.get("settings").get("axisy").get(4).asText());

        Assert.assertEquals("FF0000FF", node.get("settings").get("colour").asText());
    }

    @Test(expected = ValidationException.class)
    public void testValidateEmptyItems() {
        LineChart widget = new LineChart("1234");
        widget.setColor(Color.RED);
        widget.setAxisXLabels(Arrays.asList(new String[] { "Jan", "Feb", "Mar", "Apr" }));
        widget.setAxisYLabels(Arrays.asList(new String[] { "1", "2", "3", "4", "5" }));
        widget.validate();
    }

    @Test(expected = ValidationException.class)
    public void testValidateEmptySettingsAxisX() {
        LineChart widget = new LineChart("1234");
        widget.addDataPoint("1.2");
        widget.addDataPoint("2.0");
        widget.addDataPoint("4");
        widget.addDataPoint("0.4");
        widget.setColor(Color.RED);
        widget.setAxisYLabels(Arrays.asList(new String[] { "1", "2", "3", "4", "5" }));
        widget.validate();
    }

    @Test(expected = ValidationException.class)
    public void testValidateEmptySettingsAxisY() {
        LineChart widget = new LineChart("1234");
        widget.addDataPoint("1.2");
        widget.addDataPoint("2.0");
        widget.addDataPoint("4");
        widget.addDataPoint("0.4");
        widget.setColor(Color.RED);
        widget.setAxisXLabels(Arrays.asList(new String[] { "1", "2", "3", "4", "5" }));
        widget.validate();
    }

    @Test(expected = ValidationException.class)
    public void testValidateNewObject() {
        new LineChart("1234").validate();
    }
}
