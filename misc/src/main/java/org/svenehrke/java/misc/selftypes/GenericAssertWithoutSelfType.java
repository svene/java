package org.svenehrke.java.misc.selftypes;

public abstract class GenericAssertWithoutSelfType<ELEMENT_TYPE> {
	protected final ELEMENT_TYPE actual;

	public GenericAssertWithoutSelfType(ELEMENT_TYPE aActual) {
		actual = aActual;
	}

	protected abstract GenericAssertWithoutSelfType<ELEMENT_TYPE> isNotNull();
}
