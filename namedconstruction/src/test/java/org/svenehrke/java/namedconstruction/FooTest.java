package org.svenehrke.java.namedconstruction;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.svenehrke.java.namedconstruction.Foo.*;

public class FooTest {

	@Test
	public void excercise_invalid_construction() throws Exception {
		Foo foo;
		try{
			foo = new Foo(null, null, null, null, null, null);
			fail("IllegalArgumentException expected");
		}
		catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().contains("parameter 'r1' must not be null"));
		}
		try{
			foo = new Foo(null, r2(2), null, null, null, null);
			fail("IllegalArgumentException expected");
		}
		catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().contains("parameter 'r1' must not be null"));
		}
		try{
			foo = new Foo(r1(null), r2(2), null, null, null, null);
			fail("IllegalArgumentException expected");
		}
		catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().contains("parameter 'r1' must not be null"));
		}
		try{
			foo = new Foo(r1("1"), null, null, null, null, null);
			fail("IllegalArgumentException expected");
		}
		catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().contains("parameter 'r2' must not be null"));
		}
		try{
			foo = new Foo(r1("1"), r2(null), null, null, null, null);
			fail("IllegalArgumentException expected");
		}
		catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().contains("parameter 'r2' must not be null"));
		}
		try{
			foo = new Foo(r1("1"), r2(2), null, null, null, null);
			fail("IllegalArgumentException expected");
		}
		catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().contains("parameter 'r3' must not be null"));
		}

		// No exception expected:
		foo = new Foo(r1("1"), r2(2), r3(3), null, null, null);
	}

	@Test
	public void exercise_with_requireds_only() throws Exception {
		Foo foo = new Foo(r1("1"), r2(2), r3(3), null, null, null);
		assertEquals("1", foo.getR1());
		assertEquals(2, foo.getR2().longValue());
		assertEquals(3, foo.getR3());
		
		assertNull(foo.getO1());
		assertNull(foo.getO2());
		assertNull(foo.getO3());
	}


	@Test
	public void exercise_with_optionals() throws Exception {
		Foo foo = new Foo(r1("1"), r2(2), r3(3), o1("o1"), o2("o2"), o3("o3"));
		assertEquals("1", foo.getR1());
		assertEquals(2, foo.getR2().longValue());
		assertEquals(3, foo.getR3());
		assertEquals("o1", foo.getO1());
		assertEquals("o2", foo.getO2());
		assertEquals("o3", foo.getO3());
	}
}
