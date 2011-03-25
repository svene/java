package org.svenehrke.builderchain.p;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProductTest {
	@Test
	public void testRequiredOnly() {
		Product p = Product.withRequired1("r1").withRequired2("r2").withRequired3("r3").build();
		assertNotNull(p);
		assertEquals("r1", p.getRequired1());
		assertEquals("r2", p.getRequired2());
		assertEquals("r3", p.getRequired3());
	}

	@Test
	public void testRequiredAndOptions() {
		Product p = Product.withRequired1("r1").withRequired2("r2").withRequired3("r3").andOptional1("o1").andOptional2("o2").andOptional3("o3").build();
		assertNotNull(p);
		assertEquals("r1", p.getRequired1());
		assertEquals("r2", p.getRequired2());
		assertEquals("r3", p.getRequired3());

		assertEquals("o1", p.getOptional1());
		assertEquals("o2", p.getOptional2());
		assertEquals("o3", p.getOptional3());
	}

}
