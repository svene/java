package org.svenehrke.java.misc.selftypes;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertSame;

public class FileAssertTest {

	@Test
	public void test1() {
		final FileAssert fa = new FileAssert(new File("."));
		assertSame(fa, fa.isNotNull());
	}

}
