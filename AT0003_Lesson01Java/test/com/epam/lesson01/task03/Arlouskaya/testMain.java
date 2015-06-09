package com.epam.lesson01.task03.Arlouskaya;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testMain {
	@Test
	public void testArea() {
		Assert.assertEquals(main.getArea(1, 1), 0.5);
		Assert.assertEquals(main.getArea(3, 4), 6.0);
	}

	@Test
	public void testPerimetr() {
		Assert.assertEquals(main.getPerimetr(1, 1), 3.414213562373095);
		Assert.assertEquals(main.getPerimetr(3, 4), 12.0);
	}

}
