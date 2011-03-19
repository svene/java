package org.svenehrke.java.misc.visiblesingleton;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SomeClientTest {

	@Test
	public void testWithSingleton() {

		assertEquals("MySingleton.doSomething", new SomeClient().doSomething());

	}

	@Test
	public void testWithMockedSingleton() {

		assertEquals("SomeClientTest$TestSingleton.doSomething", new SomeClient(new TestSingleton()).doSomething());

	}

	private static class TestSingleton extends MySingleton {
		@Override
		public String doSomething() {
			return "SomeClientTest$TestSingleton.doSomething";
		}
	}

}
