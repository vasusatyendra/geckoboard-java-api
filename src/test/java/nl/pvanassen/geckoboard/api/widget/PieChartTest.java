package nl.pvanassen.geckoboard.api.widget;

import java.awt.Color;
import java.io.IOException;

import nl.pvanassen.geckoboard.api.JsonTestHelper;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

public class PieChartTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        PieChart widget = new PieChart("1234");
        widget.addItem("Test1", "100", Color.RED);
        widget.addItem("Test2", "200", Color.GREEN);
        widget.addItem("Test3", "300", Color.BLUE);
        widget.addItem("Test4", "400", Color.WHITE);

        JsonNode data = JsonTestHelper.getJsonFromWidget(widget);

        Assert.assertNotNull(data.get("data"));
        JsonNode node = data.get("data");
        Assert.assertNull(node.get("widgetKey"));

        Assert.assertEquals(4, node.get("item").size());
        Assert.assertEquals("Test1", node.get("item").get(0).get("label").asText());
        Assert.assertEquals("100", node.get("item").get(0).get("value").asText());
        Assert.assertEquals("FF0000FF", node.get("item").get(0).get("color").asText());

        Assert.assertEquals("Test2", node.get("item").get(1).get("label").asText());
        Assert.assertEquals("200", node.get("item").get(1).get("value").asText());
        Assert.assertEquals("00FF00FF", node.get("item").get(1).get("color").asText());

        Assert.assertEquals("Test3", node.get("item").get(2).get("label").asText());
        Assert.assertEquals("300", node.get("item").get(2).get("value").asText());
        Assert.assertEquals("0000FFFF", node.get("item").get(2).get("color").asText());

        Assert.assertEquals("Test4", node.get("item").get(3).get("label").asText());
        Assert.assertEquals("400", node.get("item").get(3).get("value").asText());
        Assert.assertEquals("FFFFFFFF", node.get("item").get(3).get("color").asText());
    }

}
