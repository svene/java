package org.svenehrke.java.misc;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * Use Void instead of void for commands so that they can be used as arguments for the ternary operator
 *
 * Sven, 21.12.2010
 */
public class TernaryTest {

	@Test
	public void testNormalTernaryOperator() {
		int r = 1 > 2 ? 2 : 3;
	}

	@Test
	public void testTernaryOperatorForBooleanCommands() {
		final Holder h = new Holder();

		nop(2>1 ? command1(h) : command2(h));
		assertEquals("TernaryTest.command1", h.getValue());

		nop(1>1 ? command1(h) : command2(h));
		assertEquals("TernaryTest.command2", h.getValue());


		nop(2>1 ? command3Wrapper(h) : command2(h));
		assertEquals("TernaryTest.command3", h.getValue());

	}

	public static void nop(Void v) {
	}

	private Void command1(Holder aHolder) {
		aHolder.setValue("TernaryTest.command1");
		return null;
	}
	private Void command2(Holder aHolder) {
		aHolder.setValue("TernaryTest.command2");
		return null;
	}
	private void command3(Holder aHolder) {
		aHolder.setValue("TernaryTest.command3");
	}
	private Void command3Wrapper(Holder aHolder) {
		command3(aHolder);
		return null;
	}


	private static class Holder {
		private String value;

		public String getValue() {
			return value;
		}

		public void setValue(String aValue) {
			value = aValue;
		}
	}

}
