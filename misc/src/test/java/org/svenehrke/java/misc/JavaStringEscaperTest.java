package org.svenehrke.java.misc;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class JavaStringEscaperTest {
	@Test
	public void test() {
		assertEquals("\"", new JavaStringEscaper().escapedString("'"));

		assertEquals("{\"symbol\":\"SVEN\",\"price\":\"1.2\",\"delay\":\"4\"}",
			new JavaStringEscaper().escapedString("{'symbol':'SVEN','price':'1.2','delay':'4'}") );
	}

}
