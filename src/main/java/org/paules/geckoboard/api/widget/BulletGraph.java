package org.paules.geckoboard.api.widget;

import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.paules.geckoboard.api.Push;

public class BulletGraph extends Push {

	public enum Color {
		RED("red"), AMBER("amber"), GREEN("green");
		private final String json;

		private Color(String json) {
			this.json = json;
		}
	}

	private static class Item {
		private String label;

		private String subLabel;

		private List<Integer> axisPoints = new LinkedList<Integer>();

		private List<Range> ranges = new LinkedList<Range>();

		private Position current;

		private Position projected;

		private int comparative;

		public ObjectNode toJson() {
			ObjectNode node = new ObjectMapper().getNodeFactory().objectNode();
			node.put("label", label);
			if (subLabel != null) {
				node.put("sublabel", subLabel);
			}
			ObjectNode axis = node.objectNode();
			node.put("axis", axis);
			ArrayNode point = axis.arrayNode();
			axis.put("point", point);
			for (int pt : axisPoints) {
				point.add(pt);
			}
			ArrayNode range = node.arrayNode();
			node.put("range", range);
			for (Range rng : ranges) {
				range.add(rng.toJson());
			}
			ObjectNode measure = node.objectNode();
			node.put("measure", measure);
			if (current != null) {
				measure.put("current", current.toJson());
			}
			if (projected != null) {
				measure.put("projected", projected.toJson());
			}
			ObjectNode comparativeNode = node.objectNode();
			comparativeNode.put("point", comparative);
			measure.put("comparative", comparativeNode);
			return node;
		}
	}

	private static class Position {
		protected int start;

		protected int end;

		public Position(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public ObjectNode toJson() {
			ObjectNode node = new ObjectMapper().getNodeFactory().objectNode();
			node.put("start", start);
			node.put("end", end);
			return node;
		}
	}

	private static class Range extends Position {
		private Color color;

		public Range(int start, int end, Color color) {
			super(start, end);
			this.color = color;
		}

		@Override
		public ObjectNode toJson() {
			ObjectNode node = new ObjectMapper().getNodeFactory().objectNode();
			node.put("color", color.json);
			node.put("start", start);
			node.put("end", end);
			return node;
		}
	}

	private final boolean vertical;

	private final List<Item> items = new LinkedList<Item>();

	private Item current = null;

	public BulletGraph(String widgetKey, boolean vertical) {
		super(widgetKey);
		this.vertical = vertical;
	}

	public void addItem() {
		current = new Item();
		items.add(current);
	}

	public void addRange(int start, int end, Color color) {
		current.ranges.add(new Range(start, end, color));
	}

	@Override
	protected void getData(ObjectNode node) {
		ArrayNode itemsNode = node.arrayNode();
		for (Item i : items) {
			itemsNode.add(i.toJson());
		}
		node.put("item", itemsNode);
		if (vertical) {
			node.put("orientation", "vertial");
		} else {
			node.put("orientation", "horizontal");
		}
	}

	public void setAxisPoints(List<Integer> points) {
		current.axisPoints.addAll(points);
	}

	public void setComparative(int position) {
		current.comparative = position;
	}

	public void setCurrent(int start, int end) {
		current.current = new Position(start, end);
	}

	public void setLabel(String label) {
		current.label = label;
	}

	public void setProjected(int start, int end) {
		current.projected = new Position(start, end);
	}

	public void setSubLabel(String subLabel) {
		current.subLabel = subLabel;
	}
}
