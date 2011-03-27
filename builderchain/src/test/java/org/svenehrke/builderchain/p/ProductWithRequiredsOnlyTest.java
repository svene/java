package org.svenehrke.builderchain.p;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProductWithRequiredsOnlyTest {
	@Test
	public void testRequiredOnly() {
		ProductWithRequiredsOnly p = ProductWithRequiredsOnly.withRequired1("r1").withRequired2("r2").withRequired3("r3");
		assertNotNull(p);
		assertEquals("r1", p.getRequired1());
		assertEquals("r2", p.getRequired2());
		assertEquals("r3", p.getRequired3());
	}
}
