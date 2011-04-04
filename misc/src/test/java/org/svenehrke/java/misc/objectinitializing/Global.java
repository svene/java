package org.svenehrke.java.misc.objectinitializing;

import java.util.ArrayList;
import java.util.List;

public class Global {
	public static ArrayList<String> log = new ArrayList<String>();

	public static void clearLog() {
		log.clear();
	}
	public static String newString(String s) {
		log.add(s);
		return s;
	}
}
