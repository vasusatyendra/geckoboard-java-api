package org.paules.geckoboard.api.widget;

import java.util.Arrays;

import org.junit.Test;

public class BulletGraphTest {

	@Test
	public void testGetData() {
		BulletGraph widget = new BulletGraph("1234", false);
		widget.setAxisPoints(Arrays.asList(new Integer[]{1,2,3,4,8,0}));
		widget.setComparative(10);
		widget.setLabel("test-label");
		widget.setProjected(10, 100);
		widget.setSubLabel("sub-test-label");
		
		// widget.getData(node)
	}

}
