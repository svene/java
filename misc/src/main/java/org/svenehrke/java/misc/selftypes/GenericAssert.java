package org.svenehrke.java.misc.selftypes;

public abstract class GenericAssert<SELF_TYPE extends GenericAssert<SELF_TYPE, ELEMENT_TYPE>, ELEMENT_TYPE> {
	protected final ELEMENT_TYPE actual;

	@SuppressWarnings("unchecked")
	protected final SELF_TYPE self() {
		return (SELF_TYPE) this;
	}

	public GenericAssert(ELEMENT_TYPE aActual) {
		actual = aActual;
	}

	public final SELF_TYPE isNotNull() {
		return self();
	}
}
