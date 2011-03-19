package org.svenehrke.java.misc.visiblesingleton;

public class SomeClient {

	@VisibleForTesting
	final MySingleton mySingleton;

	public SomeClient() {
		this(MySingleton.instance());
	}

	@VisibleForTesting
	SomeClient(MySingleton mySingleton) {
		this.mySingleton = mySingleton;
	}

	public String doSomething() {
		return mySingleton.doSomething();
	}
}