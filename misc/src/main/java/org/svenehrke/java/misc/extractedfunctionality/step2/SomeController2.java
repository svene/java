package org.svenehrke.java.misc.extractedfunctionality.step2;

abstract class SomeController2<PM, K, SD, TO> {
	public String do1() { return "1";}
	public String do2() { return "2";}
	public String do3() { return "3";}

	//...

	public String do100() { return "100";}


	protected abstract SD createFromPM(PM aPM);
	protected abstract void add(K key, SD value);
	protected abstract void remove(K key);
	protected abstract void update(K key, SD value);

	public void doSomething(PM aPM, K aKey, SD d, TO to) {}
}
