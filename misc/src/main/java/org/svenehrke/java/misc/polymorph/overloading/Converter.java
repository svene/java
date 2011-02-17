package org.svenehrke.java.misc.polymorph.overloading;

import org.svenehrke.java.misc.polymorph.Holder;

public class Converter {
	public enum Result {OBJECT, DOUBLE, INT}
	static final String OBJECT_MESSAGE = "Converter.convert with double called";
	static final String DOUBLE_MESSAGE = "Converter.convert with double called";
	static final String INT_MESSAGE = "Converter.convert with int called";

	public double convert(Object aValue, Holder<Result> aHolder) {
		aHolder.setValue(Result.OBJECT);
		return 2;
	}
	public double convert(Double aValue, Holder<Result> aHolder) {
		aHolder.setValue(Result.DOUBLE);
		return aValue;
	}
	public double convert(Integer aValue, Holder<Result> aHolder) {
		aHolder.setValue(Result.INT);
		return aValue;
	}

	public static double sconvert(Object aValue, Holder<Result> aHolder) {
		aHolder.setValue(Result.OBJECT);
		return 2;
	}
	public static double sconvert(Double aValue, Holder<Result> aHolder) {
		aHolder.setValue(Result.DOUBLE);
		return aValue;
	}
	public static double sconvert(Integer aValue, Holder<Result> aHolder) {
		aHolder.setValue(Result.INT);
		return aValue;
	}
}
