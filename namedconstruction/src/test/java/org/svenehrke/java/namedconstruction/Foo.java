package org.svenehrke.java.namedconstruction;

public class Foo {
	// Required Parameters:
	private final String r1;
	private final Integer r2;
	private final long r3;

	// Optional Parameters:
	private final String o1;
	private final String o2;
	private final String o3;

	public Foo(R1 r1, R2 r2, R3 r3, O1 o1, O2 o2, O3 o3) {
		if (r1 == null) {
			throw new IllegalArgumentException("parameter 'r1' must not be null");
		}
		if (r2 == null) {
			throw new IllegalArgumentException("parameter 'r2' must not be null");
		}
		if (r3 == null) {
			throw new IllegalArgumentException("parameter 'r3' must not be null");
		}
		this.r1 = r1.getValue();
		this.r2 = r2.getValue();
		this.r3 = r3.getValue();

		this.o1 = OptionalParameter.valueOf(o1);
		this.o2 = OptionalParameter.valueOf(o2);
		this.o3 = OptionalParameter.valueOf(o3);
	}
	
	public static R1 r1(String v) {
		return new R1().init("r1", v);
	}
	public static R2 r2(Integer v) {
		return new R2().init("r2", v);
	}
	public static R3 r3(long v) {
		return new R3().init(v);
	}
	public static O1 o1(String v) {
		return new O1().setValue(v);
	}
	public static O2 o2(String v) {
		return new O2().setValue(v);
	}
	public static O3 o3(String v) {
		return new O3().setValue(v);
	}

	public String getR1() {
		return r1;
	}

	public Integer getR2() {
		return r2;
	}

	public long getR3() {
		return r3;
	}

	public String getO1() {
		return o1;
	}

	public String getO2() {
		return o2;
	}

	public String getO3() {
		return o3;
	}

	public static class R1 extends RequiredParameter<R1, String> {}
	public static class R2 extends RequiredParameter<R2, Integer> {}
	public static class R3 extends PrimitiveLongParameter<R3> {}

	public static class O1 extends OptionalParameter<O1, String> {}
	public static class O2 extends OptionalParameter<O2, String> {}
	public static class O3 extends OptionalParameter<O3, String> {}
}
