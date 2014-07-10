package nl.pvanassen.geckoboard.api.widget;

import java.io.IOException;

import nl.pvanassen.geckoboard.api.JsonTestHelper;
import nl.pvanassen.geckoboard.api.json.text.TextItemType;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

public class TextTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        Text widget = new Text("1234");
        widget.addText("Test1");
        widget.addText("Test2", TextItemType.ALERT);
        widget.addText("Test3", TextItemType.INFO);
        widget.addText("Test4", TextItemType.NONE);

        JsonNode data = JsonTestHelper.getJsonFromWidget(widget);

        Assert.assertNotNull(data.get("data"));
        JsonNode node = data.get("data");
        Assert.assertNull(node.get("widgetKey"));
        Assert.assertEquals(4, node.get("item").size());

        Assert.assertEquals("Test1", node.get("item").get(0).get("text").asText());
        Assert.assertEquals(0, node.get("item").get(0).get("type").asInt());

        Assert.assertEquals("Test2", node.get("item").get(1).get("text").asText());
        Assert.assertEquals(1, node.get("item").get(1).get("type").asInt());

        Assert.assertEquals("Test3", node.get("item").get(2).get("text").asText());
        Assert.assertEquals(2, node.get("item").get(2).get("type").asInt());

        Assert.assertEquals("Test4", node.get("item").get(3).get("text").asText());
        Assert.assertEquals(0, node.get("item").get(3).get("type").asInt());

    }

}
