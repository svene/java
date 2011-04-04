package org.svenehrke.java.misc.objectinitializing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObjectInitializationTest {

	@Before
	public void initialize() {
		Global.clearLog();
	}

	@Test
	public void test1() {
		A a = new A();
		assertEquals(4, Global.log.size());
		// Verify that executions of field initializers and object initializers occurs in order of declaration:
		assertEquals("field initializer: A.name_a1", Global.log.get(0));
		assertEquals("object initializer: A.name_a2", Global.log.get(1));
		assertEquals("field initializer: A.name_a3", Global.log.get(2));
		assertEquals("A.constructor", Global.log.get(3));
	}

	@Test
	public void testInitializationWithInheritance() {
		B a = new B();
		assertEquals(8, Global.log.size());
		// Verify that executions of field initializers and object initializers occurs in order of declaration:
		assertEquals("field initializer: A.name_a1", Global.log.get(0));
		assertEquals("object initializer: A.name_a2", Global.log.get(1));
		assertEquals("field initializer: A.name_a3", Global.log.get(2));
		assertEquals("A.constructor", Global.log.get(3));

		assertEquals("field initializer: B.name_b1", Global.log.get(4));
		assertEquals("object initializer: B.name_b2", Global.log.get(5));
		assertEquals("field initializer: B.name_b3", Global.log.get(6));
		assertEquals("B.constructor", Global.log.get(7));
	}

}
