package org.svenehrke.java.misc.extractedfunctionality.step3;

abstract class SomeControllerHandler3<PM, K, SD, TO> {
	public abstract SD createFromPM(PM aPM);
	public abstract void add(K key, SD value);
	public abstract void remove(K key);
	public abstract void update(K key, SD value);
}
