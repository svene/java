package org.svenehrke.java.namedconstruction;

public class PrimitiveLongParameter<T> {
	private long value;
	
	public T init(long value) {
		this.value = value;
		return (T)this;
	}

	public long getValue() {
		return value;
	}
}
