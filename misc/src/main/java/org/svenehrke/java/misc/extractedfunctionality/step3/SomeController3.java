package org.svenehrke.java.misc.extractedfunctionality.step3;

abstract class SomeController3<PM, K, SD, TO> {
	public String do1() { return "1";}
	public String do2() { return "2";}
	public String do3() { return "3";}

	//...

	public String do100() { return "100";}

	public void doSomething(PM aPM, K aKey, SD d, TO to) {}

	public abstract SomeControllerHandler3<PM, K, SD, TO> newControllerHandler();

}
