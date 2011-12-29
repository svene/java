package org.svenehrke.java.misc.enummap;

import org.junit.Test;

import java.util.EnumMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EnumMapTest {
	@Test
	public void test1() throws Exception {
		final EnumMap<DBKey,String> enumMap = DBKey.load(EnumMapTest.class.getResourceAsStream("/enummap/db_connection.properties"));
		assertTrue(enumMap.containsKey(DBKey.USER));
		assertEquals("admin", enumMap.get(DBKey.USER));
		assertTrue(enumMap.containsKey(DBKey.PASSWORD));
		assertTrue(enumMap.containsKey(DBKey.URL));
		assertTrue(enumMap.containsKey(DBKey.MIN_CONNECTION));
		assertTrue(enumMap.containsKey(DBKey.MAX_CONNECTION));
	}
}
