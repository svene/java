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
		Product p = Product.withRequired1("r1").withRequired2("r2").withRequired3("r3").setOptional1("o1").setOptional2("o2").setOptional3("o3").build();
		assertNotNull(p);
		assertEquals("r1", p.getRequired1());
		assertEquals("r2", p.getRequired2());
		assertEquals("r3", p.getRequired3());

		assertEquals("o1", p.getOptional1());
		assertEquals("o2", p.getOptional2());
		assertEquals("o3", p.getOptional3());
	}

	@Test
	public void testCreationWithInitializedBuilder() {
		Product p = Product.withRequired1("r1").withRequired2("r2").withRequired3("r3").setOptional1("o1").setOptional2("o2").setOptional3("o3").build();
		Product p2 = p.newInitializedBuilder().setOptional2("o22").build();
		assertNotNull(p2);
		assertEquals("r1", p2.getRequired1());
		assertEquals("r2", p2.getRequired2());
		assertEquals("r3", p2.getRequired3());

		assertEquals("o1", p2.getOptional1());
		assertEquals("o22", p2.getOptional2());
		assertEquals("o3", p2.getOptional3());
	}

}
