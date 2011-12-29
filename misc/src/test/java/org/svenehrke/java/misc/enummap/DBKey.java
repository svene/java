package org.svenehrke.java.misc.enummap;

import java.io.IOException;
import java.io.InputStream;
import java.util.EnumMap;
import java.util.Properties;

public enum DBKey {
	USER, PASSWORD, URL, MIN_CONNECTION, MAX_CONNECTION;

	private final String propKey;

	private DBKey() {
		propKey = name().toLowerCase();
	}

	public static EnumMap<DBKey, String> load(InputStream is) throws IOException {
		EnumMap<DBKey, String> result = new EnumMap<DBKey, String>(DBKey.class);
		final Properties properties = new Properties();
		properties.load(is);
		for (DBKey key : DBKey.values()) {
			result.put(key, (String) properties.get(key.propKey));
		}
		return result;
	}
}
