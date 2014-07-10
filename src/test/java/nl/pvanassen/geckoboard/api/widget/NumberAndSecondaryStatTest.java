package nl.pvanassen.geckoboard.api.widget;

import java.io.IOException;

import nl.pvanassen.geckoboard.api.JsonTestHelper;
import nl.pvanassen.geckoboard.api.json.common.GraphType;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

public class NumberAndSecondaryStatTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        NumberAndSecondaryStat widget = new NumberAndSecondaryStat("1234", true, GraphType.REVERSE);
        widget.setPrimary("10", "$");
        widget.setSecondary("20");

        JsonNode data = JsonTestHelper.getJsonFromWidget(widget);

        Assert.assertNotNull(data.get("data"));
        JsonNode node = data.get("data");
        Assert.assertNull(node.get("widgetKey"));

        Assert.assertTrue(node.get("absolute").asBoolean());
        Assert.assertEquals("reverse", node.get("type").asText());
        Assert.assertEquals("10", node.get("item").get(0).get("value").asText());
        Assert.assertEquals("", node.get("item").get(0).get("text").asText());
        Assert.assertEquals("$", node.get("item").get(0).get("prefix").asText());
        Assert.assertEquals("20", node.get("item").get(1).get("value").asText());
        Assert.assertEquals("", node.get("item").get(1).get("text").asText());

    }

}
