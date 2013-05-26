package org.paules.geckoboard.api.widget;

import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;

public class FunnelGraph extends Push {
	private final List<Data> data = new LinkedList<Data>();

	private final FunnelGraphType type;

	private final boolean showPercentage;

	public FunnelGraph(String widgetKey, boolean showPercentage) {
		this(widgetKey, FunnelGraphType.STANDARD, showPercentage);
	}

	public FunnelGraph(String widgetKey, FunnelGraphType type,
			boolean showPercentage) {
		super(widgetKey);
		this.type = type;
		this.showPercentage = showPercentage;
	}

	public void addData(String label, String value) {
		data.add(new Data(label, value));
	}

	@Override
	protected void getData(ObjectNode data) {
		data.put("type", type.toString().toLowerCase());
		if (showPercentage) {
			data.put("percentage", "show");
		} else {
			data.put("percentage", "hide");
		}
		addData(data, this.data);
	}

	enum FunnelGraphType {
		STANDARD, REVERSE;
	}
}
