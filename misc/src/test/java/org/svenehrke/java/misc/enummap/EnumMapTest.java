package org.svenehrke.java.misc.enummap;

import org.junit.Test;

import java.util.EnumMap;

public class EnumMapTest {
	@Test
	public void test1() throws Exception {
		final EnumMap<DBKey,String> enumMap = DBKey.load(EnumMapTest.class.getResourceAsStream("db_connection.properties"));
		for (DBKey key : enumMap.keySet()) {
			System.out.printf("%s: %s%n", key.name(), enumMap.get(key));
		}

	}
}
