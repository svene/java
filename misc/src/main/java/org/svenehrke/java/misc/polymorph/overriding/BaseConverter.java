package org.svenehrke.java.misc.polymorph.overriding;

import org.svenehrke.java.misc.polymorph.Holder;

public class BaseConverter {
	static final String BASE_MESSAGE = "BaseConverter.convert called";

	public double convert(double aValue, Holder aHolder) {
		aHolder.setValue(BASE_MESSAGE);
		return aValue;
	}
}
