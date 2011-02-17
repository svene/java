package org.svenehrke.java.misc.polymorph.overriding;

import org.svenehrke.java.misc.polymorph.Holder;

public class SpecialConverter extends BaseConverter {
	static final String SPECIAL_MESSAGE = "SpecialConverter.convert called";

	//	@Override
	public double convert(int aValue, Holder aHolder) {
		aHolder.setValue(SPECIAL_MESSAGE);
		return aValue;
	}
}
