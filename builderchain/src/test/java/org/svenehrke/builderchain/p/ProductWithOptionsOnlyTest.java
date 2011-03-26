package org.svenehrke.builderchain.p;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProductWithOptionsOnlyTest {

	@Test
	public void testWithNoOptionals() {
		ProductWithOptionsOnly p = ProductWithOptionsOnly.newBuilder().build();
		assertNull(p.getOptional1());
		assertNull(p.getOptional2());
		assertNull(p.getOptional3());
	}

	@Test
	public void testWithOneOptional() {
		ProductWithOptionsOnly p;

		p = ProductWithOptionsOnly.newBuilder().setOptional1("o1").build();
		assertEquals("o1", p.getOptional1());
		assertNull(p.getOptional2());
		assertNull(p.getOptional3());

		p = ProductWithOptionsOnly.newBuilder().setOptional2("o2").build();
		assertNull(p.getOptional1());
		assertEquals("o2", p.getOptional2());
		assertNull(p.getOptional3());

		p = ProductWithOptionsOnly.newBuilder().setOptional3("o3").build();
		assertNull(p.getOptional1());
		assertNull(p.getOptional2());
		assertEquals("o3", p.getOptional3());

	}

	@Test
	public void testWithTwoOptionals() {
		ProductWithOptionsOnly p;

		p = ProductWithOptionsOnly.newBuilder().setOptional1("o1").setOptional2("o2").build();
		assertEquals("o1", p.getOptional1());
		assertEquals("o2", p.getOptional2());
		assertNull(p.getOptional3());

		p = ProductWithOptionsOnly.newBuilder().setOptional1("o1").setOptional3("o3").build();
		assertEquals("o1", p.getOptional1());
		assertNull(p.getOptional2());
		assertEquals("o3", p.getOptional3());

		p = ProductWithOptionsOnly.newBuilder().setOptional2("o2").setOptional3("o3").build();
		assertNull(p.getOptional1());
		assertEquals("o2", p.getOptional2());
		assertEquals("o3", p.getOptional3());
	}

	@Test
	public void testWithThreeOptionals() {
		ProductWithOptionsOnly p = ProductWithOptionsOnly.newBuilder().setOptional1("o1").setOptional2("o2").setOptional3("o3").build();
		assertEquals("o1", p.getOptional1());
		assertEquals("o2", p.getOptional2());
		assertEquals("o3", p.getOptional3());
	}

	@Test
	public void demonstrateDisadvantages() {
		// disadvantage: the API does not prevent to call 'setOptional1()' more than once:
		ProductWithOptionsOnly p = ProductWithOptionsOnly.newBuilder().setOptional1("o1").setOptional1("o2").build();
		assertEquals("o2", p.getOptional1());
	}

	@Test
	public void testCreationWithInitializedBuilder() {
		ProductWithOptionsOnly p = ProductWithOptionsOnly.newBuilder().setOptional1("o1").setOptional2("o2").setOptional3("o3").build();
		ProductWithOptionsOnly p2 = p.newInitializedBuilder().setOptional2("o22").build();
		assertEquals("o1", p2.getOptional1());
		assertEquals("o22", p2.getOptional2());
		assertEquals("o3", p2.getOptional3());

	}
}
