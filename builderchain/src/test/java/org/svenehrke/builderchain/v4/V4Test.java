package org.svenehrke.builderchain.v4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class V4Test {
	@Test
	public void testP1_P3() {
		V4 v4 = V4
			.withP1(1)
			.withP3(2)
			.build();

		assertNotNull(v4);
		assertEquals(1, v4.getP1());
		assertEquals(0, v4.getP2());
		assertEquals(2, v4.getP3());
		assertEquals(0, v4.getP4a());
		assertEquals(0, v4.getP4b());
		assertEquals(0, v4.getP5());
		assertEquals(0, v4.getP6());
		assertEquals(0, v4.getP7());
	}

	@Test
	public void testP1_P3_P4a() {
		V4 v4 = V4.withP1(1).withP3(2).withP4a(41).build();

		assertNotNull(v4);
		assertEquals(1, v4.getP1());
		assertEquals(0, v4.getP2());
		assertEquals(2, v4.getP3());
		assertEquals(41, v4.getP4a());
		assertEquals(0, v4.getP4b());
		assertEquals(0, v4.getP5());
		assertEquals(0, v4.getP6());
		assertEquals(0, v4.getP7());
	}

	@Test
	public void testP1_P3_P4b() {
		V4 v4 = V4.withP1(1).withP3(2).withP4b(42).build();

		assertNotNull(v4);
		assertEquals(1, v4.getP1());
		assertEquals(2, v4.getP3());
		assertEquals(42, v4.getP4b());
	}

	@Test
	public void testP1_P3_P4a_P4b() {
		V4 v4 = V4.withP1(1).withP3(2).withP4a(41).withP4b(42).build();

		assertNotNull(v4);
		assertEquals(1, v4.getP1());
		assertEquals(2, v4.getP3());
		assertEquals(41, v4.getP4a());
		assertEquals(42, v4.getP4b());
	}

	@Test
	public void testP1_P3_P4a_P4b_P5_P6() {
		V4 v4 = V4.withP1(1).withP3(2).withP4a(41).withP4b(42).withP5(5).initP6(6).build();

		assertNotNull(v4);
		assertEquals(1, v4.getP1());
		assertEquals(2, v4.getP3());
		assertEquals(41, v4.getP4a());
		assertEquals(42, v4.getP4b());
		assertEquals(5, v4.getP5());
		assertEquals(6, v4.getP6());
	}

//________________________

	@Test
	public void testP2() {
		V4 v4 = V4
			.initP2(2)
			.build();

		assertNotNull(v4);
		assertEquals(0, v4.getP1());
		assertEquals(2, v4.getP2());
		assertEquals(0, v4.getP3());
		assertEquals(0, v4.getP4a());
		assertEquals(0, v4.getP4b());
		assertEquals(0, v4.getP5());
		assertEquals(0, v4.getP6());
		assertEquals(0, v4.getP7());
	}

	@Test
	public void testP2_P5() {
		V4 v4 = V4
			.initP2(2)
			.withP5(5)
			.initP7(7)
			.build();

		assertNotNull(v4);
		assertEquals(0, v4.getP1());
		assertEquals(5, v4.getP5());
		assertEquals(7, v4.getP7());
	}

}
