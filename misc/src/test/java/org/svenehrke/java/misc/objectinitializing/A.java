package org.svenehrke.java.misc.objectinitializing;

public class A {
	private String name_a1 = Global.newString("field initializer: A.name_a1");
	private String name_a2;
	{
		name_a2 = Global.newString("object initializer: A.name_a2");
		
	}
	private String name_a3 = Global.newString("field initializer: A.name_a3");

	public A() {
		Global.newString("A.constructor");
	}
}
