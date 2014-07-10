package nl.pvanassen.geckoboard.api.widget;

import java.io.IOException;

import nl.pvanassen.geckoboard.api.JsonTestHelper;
import nl.pvanassen.geckoboard.api.json.common.GraphType;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

public class RAGColumnsAndNumbersTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        RAGColumnsAndNumbers widget = new RAGColumnsAndNumbers("1234", GraphType.STANDARD);
        widget.setRed("Test-red", 123);
        widget.setAmber("Test-amber", 1234);
        widget.setGreen("Test-green", 12345, "$");

        JsonNode data = JsonTestHelper.getJsonFromWidget(widget);

        Assert.assertNotNull(data.get("data"));
        JsonNode node = data.get("data");
        Assert.assertNull(node.get("widgetKey"));

        Assert.assertEquals("standard", node.get("type").asText());

        Assert.assertEquals(3, node.get("item").size());

        Assert.assertEquals("Test-green", node.get("item").get(0).get("text").asText());
        Assert.assertEquals(12345, node.get("item").get(0).get("value").asInt());
        Assert.assertEquals("$", node.get("item").get(0).get("prefix").asText());

        Assert.assertEquals("Test-amber", node.get("item").get(1).get("text").asText());
        Assert.assertEquals(1234, node.get("item").get(1).get("value").asInt());
        Assert.assertNull(node.get("item").get(1).get("prefix"));

        Assert.assertEquals("Test-red", node.get("item").get(2).get("text").asText());
        Assert.assertEquals(123, node.get("item").get(2).get("value").asInt());
        Assert.assertNull(node.get("item").get(2).get("prefix"));
    }

}
