package org.svenehrke.java.misc.objectinitializing;

public class B extends A {
	private String name_b1 = Global.newString("field initializer: B.name_b1");
	private String name_b2;
	{
		name_b2 = Global.newString("object initializer: B.name_b2");

	}
	private String name_b3 = Global.newString("field initializer: B.name_b3");

	public B() {
		Global.newString("B.constructor");
	}
}
