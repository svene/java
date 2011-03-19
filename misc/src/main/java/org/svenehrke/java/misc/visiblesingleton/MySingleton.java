package org.svenehrke.java.misc.visiblesingleton;

public class MySingleton {

	private static final MySingleton INSTANCE = new MySingleton();

	public static MySingleton instance() {
		return INSTANCE;
	}

	@VisibleForTesting
	MySingleton() {
	}

	public String doSomething() {
		return "MySingleton.doSomething";
	}
}