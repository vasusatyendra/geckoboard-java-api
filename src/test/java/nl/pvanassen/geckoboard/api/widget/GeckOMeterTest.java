package nl.pvanassen.geckoboard.api.widget;

import java.io.IOException;

import nl.pvanassen.geckoboard.api.JsonTestHelper;
import nl.pvanassen.geckoboard.api.json.common.GraphType;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

public class GeckOMeterTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        GeckOMeter widget = new GeckOMeter("1234", GraphType.STANDARD);
        widget.setCurrent("10");
        widget.setMin("No one", "0");
        widget.setMax("Panic!", "1000");

        JsonNode data = JsonTestHelper.getJsonFromWidget(widget);

        Assert.assertNotNull(data.get("data"));
        JsonNode node = data.get("data");
        Assert.assertNull(node.get("widgetKey"));

        Assert.assertEquals("10", node.get("item").asText());
        Assert.assertEquals("0", node.get("min").get("value").asText());
        Assert.assertEquals("No one", node.get("min").get("text").asText());
        Assert.assertEquals("1000", node.get("max").get("value").asText());
        Assert.assertEquals("Panic!", node.get("max").get("text").asText());
    }

}
