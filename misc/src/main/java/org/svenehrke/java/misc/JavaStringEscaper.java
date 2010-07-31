package org.svenehrke.java.misc;

public class JavaStringEscaper {
	public String escapedString(String aString) {
		return aString.replaceAll("'", "\"");
	}

}
