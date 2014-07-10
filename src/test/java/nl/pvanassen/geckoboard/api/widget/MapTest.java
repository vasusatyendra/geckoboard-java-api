package nl.pvanassen.geckoboard.api.widget;

import java.awt.Color;
import java.io.IOException;

import nl.pvanassen.geckoboard.api.JsonTestHelper;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

public class MapTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        MapWidget widget = new MapWidget("1234");
        widget.addCityPoint("test1");
        widget.addCityPoint("test2", "CA").setColor(Color.RED);
        widget.addCityPoint("test3", "BE", "NL").setSize(1);
        widget.addHostPoint("localhost");
        widget.addIpPoint("192.168.0.1");
        widget.addLatLonPoint("51.526263", "-0.092429");

        JsonNode data = JsonTestHelper.getJsonFromWidget(widget);

        Assert.assertNotNull(data.get("data"));
        JsonNode node = data.get("data");
        Assert.assertNull(node.get("widgetKey"));

        Assert.assertNotNull(node.get("points"));
        JsonNode points = node.get("points");
        Assert.assertEquals(6, points.get("point").size());
        JsonNode point = points.get("point");
        Assert.assertNotNull(point.get(0).get("city"));
        Assert.assertEquals("test1", point.get(0).get("city").get("city_name").asText());
        Assert.assertNull(point.get(0).get("city").get("region_name"));
        Assert.assertNull(point.get(0).get("city").get("country_name"));

    }

}
