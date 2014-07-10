package nl.pvanassen.geckoboard.api.widget;

import java.io.IOException;

import nl.pvanassen.geckoboard.api.JsonTestHelper;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

public class MonitoringTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        Monitoring widget = new Monitoring("1234");
        widget.setStatus("Up");
        widget.setResponseTime("1 ms");
        widget.setDownTime("10 days");
        JsonNode data = JsonTestHelper.getJsonFromWidget(widget);

        Assert.assertNotNull(data.get("data"));
        JsonNode node = data.get("data");
        Assert.assertNull(node.get("widgetKey"));

        Assert.assertEquals("Up", node.get("status").asText());
        Assert.assertEquals("1 ms", node.get("responseTime").asText());
        Assert.assertEquals("10 days", node.get("downTime").asText());

    }

}
