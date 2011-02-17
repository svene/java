package org.svenehrke.java.misc.polymorph;

import org.svenehrke.java.misc.polymorph.overloading.Converter;

public class Holder<T> {
	private T value;

	public Holder() {
	}

	public Holder(T aValue) {
		value = aValue;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T aValue) {
		value = aValue;
	}
}
